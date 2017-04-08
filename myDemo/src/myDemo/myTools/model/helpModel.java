package myDemo.myTools.model;

import java.util.ArrayList;
import java.util.List;

import myDemo.myTools.Command;
import myDemo.myTools.annotation.Description;
import myDemo.myTools.model.BaseModel.BaseModel;

public class helpModel extends BaseModel {
	private List<String> info;
	@Override
	public void run() {
		if(info != null && info.size()>0){
			info.forEach(o->{
				System.out.println(o);
			});
		}else{
			System.out.println("请输入正确的指令");
		}
	}

	@Override
	public void parseArgv(Object... obj) {
		info = new ArrayList<>();
		if(obj!=null && obj.length>0){
			for (Object object : obj) {
				String res = commandHelp(object.toString().toUpperCase());
				info.add(res);
			}
		}else{
			Command[] commands = Command.values();
			for (Command command : commands) {
				String res =commandHelp(command.name());
				info.add(res);
			}
		}
	}
	private String commandHelp(String name){
		Description description = null;
		String helpInfo = null;
		try {
			description = Command.class.getField(name).getAnnotation(Description.class);
			helpInfo = String.format("名称:%s \n \t类型:%s \n\t说明:%s\n", name,description.type(),description.helpInfo());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return helpInfo;
	}
}
