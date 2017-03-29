package myDemo.myTools;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
	public String description() default "系统指令";
}
