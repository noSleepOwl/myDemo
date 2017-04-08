package myDemo.myTools.model;

import myDemo.myTools.model.BaseModel.BaseModel;

public class CopyFile extends BaseModel {
	String tar;
	String to;
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void parseArgv(Object... obj) {
		try {
			 tar = obj[0].toString();
			 to = obj[1].toString();
		} catch (Exception e) {
			System.out.println("参数错误,请检查参数");
		}
	}
}
