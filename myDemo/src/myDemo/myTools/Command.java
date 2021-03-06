package myDemo.myTools;

import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.endModel;

/**
 * 命令的接口,只是用于储存一些命令   
 * 在这个枚举类中保存命令, 输入或者引用对应的命令,可以获取并制定 对应的实例化过的类,
 * 
 * @author uigsw
 *
 */
public enum Command {
	@Description(baseModelImpl = endModel.class) END
}
