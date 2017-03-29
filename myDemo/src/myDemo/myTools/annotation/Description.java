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
	 * 用于实例化的类
	 * @return
	 */
	public Class< ? super endModel> baseModelImpl ()  ;
}
