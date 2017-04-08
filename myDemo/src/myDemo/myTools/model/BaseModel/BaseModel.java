package myDemo.myTools.model.BaseModel;

import myDemo.myTools.MainClass;

public abstract class BaseModel {
	/**
	 * 系统执行的类,用作系统操作命令的设置
	 */
	protected MainClass mainClass;
	/**
	 * 执行的方法
	 */
	public abstract void run();
	/**
	 * 解析参数的方法
	 * @param obj
	 */
	public abstract void parseArgv(Object ...obj);
	/**
	 * 执行结束之后执行的方法,
	 */
	public void end() {
		System.out.println("命令执行结束,等待下个命令的输入......");
	}
	public void setMainClass(MainClass mainClass) {
		this.mainClass = mainClass;
	}
	
}
