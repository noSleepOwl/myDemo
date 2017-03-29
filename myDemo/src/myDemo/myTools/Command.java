package myDemo.myTools;

import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.endModel;

/**
 * 命令的接口,只是用于储存一些命令
 * @author uigsw
 *
 */
public interface Command {
	/**
	 * 结束命令
	 */
	@Description(commandType="sys",description="结束退出命令" ,baseModelImpl=endModel.class)
	public static final String END="END";
}
