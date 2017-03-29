package myDemo.myTools.model.BaseModel;

public abstract class BaseModel {
	/**
	 * 执行的方法
	 */
	public abstract void run();
	/**
	 * 解析参数的方法
	 * @param obj
	 */
	public abstract void parseArgv(Object ...obj);
}
