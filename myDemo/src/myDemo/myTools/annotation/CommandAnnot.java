package myDemo.myTools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import myDemo.myTools.Command;

@Target(ElementType.TYPE)
public @interface CommandAnnot{
	 public Command command();
}
