package myDemo.myTools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import myDemo.myTools.model.BaseModel.BaseModel;

/**
 * 使用这个注释来进 获取实例化的类
 * @author uigsw
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	/**
	 * 用于实例化的类
	 * @return
	 */
	public Class< ? extends BaseModel> baseModelImpl ()  ;
	/**
	 * 类型 , 一个是sys 
	 * @return
	 */
	public String type();
	/**
	 * 帮助信息
	 * @return
	 */
	public String helpInfo();
	
}
