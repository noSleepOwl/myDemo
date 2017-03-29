package myDemo.myTools;

import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.endModel;

/**
 * 命令的接口,只是用于储存一些命令
 * @author uigsw
 *
 */
public enum Command {
	@Description(baseModelImpl = endModel.class) END
}
