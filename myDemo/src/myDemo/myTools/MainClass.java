package myDemo.myTools;

import java.util.Arrays;

import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.BaseModel.BaseModel;

public class MainClass {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		new MainClass().run(Command.END);
	}
	/**
	 * 传入指令 获取类 ,封装的时候是有问题的, 我没有考虑到传参的问题啊?? 怎么破
	 * @param command
	 */
	void run(Command command){  
		Class<?> commandClass   =  command.getClass();
		try {
			//获取枚举类 field 上面的注解
		     Description description =	(Description) commandClass
						    		 .getField(command.toString())
						    		 .getAnnotation(Description.class);
		     Class<?> clazz = description.baseModelImpl();
		     BaseModel baseModel =(BaseModel) clazz.newInstance();  // 实例化的类
		     baseModel.parseArgv(""); // 对输入的参数进行解析 
		     baseModel.run();   //执行对应的方法
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
}
