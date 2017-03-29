package myDemo.myTools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import myDemo.myTools.model.endModel;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	/**
	 * 命令的类型  预定义的是 SYS , FEATRUES  
	 * 方法的名称也需要在这里定义么? 
	 * 一个命令绑定各种各样的模块 , 在输入对应命令的时候 , 进行类的调用? 但是写的时候还是挺麻烦的
	 * 需要多个地方的定义 ?
	 * @return
	 */
	public String commandType() default "sys";
	/**
	 * 命令的概述 用于命令的描述 help 文档的获取之类的值
	 * @return
	 */
	public String description() default "系统指令";
	/**
	 * 功能的实现类
	 * @return
	 */
	public Class< ? super endModel> baseModelImpl ()  ;
}
