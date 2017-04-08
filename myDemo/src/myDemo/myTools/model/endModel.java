package myDemo.myTools.model;

import myDemo.myTools.model.BaseModel.BaseModel;

public class endModel extends BaseModel {

	@Override
	public void run() {
		this.mainClass.setEndFlag(false);
	}

	@Override
	public void parseArgv(Object... obj) {
		for (Object object : obj) {
			System.out.println(object);
		}
	}
	@Override
	public void end() {
		System.out.println("退出成功");
	}
	
}
