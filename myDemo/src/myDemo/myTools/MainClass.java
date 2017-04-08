package myDemo.myTools;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Strings;

import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.BaseModel.BaseModel;

public class MainClass {
	/**
	 * 结束的标志
	 */
	private boolean endFlag= true;
	public static void main(String[] args) {
		MainClass ma = new MainClass();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	STAR:
		while(ma.isEndFlag()){
			try {
				String res = sc.nextLine();
				ma.parseCommand(res);
			} catch (Exception e) {
				ma.print(e.getMessage());
				continue STAR;
			}
		}
	}
	
	/**
	 * 命令的解析
	 * @param argv
	 * @return
	 * @throws RuntimeException 抛出异常, 参数有错误
	 */
	public void parseCommand(String argv) throws RuntimeException{
		if(Strings.isNullOrEmpty(argv)){
			throw new RuntimeException("请输入参数");
		}
		String [] commandAndArgv = argv.split("\\s");
		int len = commandAndArgv.length;
		Command com = null;
		List<String> argvs = Stream
				.of(commandAndArgv)
				.skip(1)
				.collect(Collectors.toList());
		if(len>=1){
			try {
			com = Enum.valueOf(Command.class, commandAndArgv[0].toUpperCase());
			} catch (Exception e) {
				throw new RuntimeException("参数错误:未找到命令"+commandAndArgv[0]);
			}
		}
		run(com,argvs);
	}
	/**
	 * 
	 * 传入指令 获取类 ,封装的时候是有问题的, 我没有考虑到传参的问题啊?? 怎么破
	 * @param command
	 */
	void run(Command command,List<String> argv){  
		Class<?> commandClass   =  command.getClass();
		try {
			//获取枚举类 field 上面的注解
		     Description description =	(Description) commandClass
						    		 	.getField(command.toString())
						    		 	.getAnnotation(Description.class);
		     Class<?> clazz = description.baseModelImpl();
		     // 实例化的类
		     BaseModel baseModel =(BaseModel) clazz.newInstance();  
		     // 是否是系统模块
		     if(description.type().equals("sys")){ 
		    	 baseModel.setMainClass(this);
		     }
		     // 对输入的参数进行解析 
	    	 baseModel.parseArgv(argv.toArray()); 
		     //执行对应的方法
		     baseModel.run();  
		     //结束命令
		     baseModel.end();
		} catch (NoSuchFieldException e) { 
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public boolean isEndFlag() {
		return endFlag;
	}

	public void setEndFlag(boolean endFlag) {
		this.endFlag = endFlag;
	}
	public void print(Object ...argvs){
		for (Object object : argvs) {
			System.out.println(object);
		}
	}
}
