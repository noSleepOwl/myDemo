package myDemo.myTools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import myDemo.myTools.Command;

@Target(ElementType.TYPE)
public @interface CommandAnnot{
	 /**
	  * 获取的指令  
	  *  commadn 上面的注解进行获取对应的class
	 * @return
	 */
	public Command command();
}
