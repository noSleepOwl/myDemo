package Tools;

import Tools.file.WebObjFileControl;

public class TestClass {
	
	public static void main(String[] args) {
//		genObj("数据字段管理", "com.noxa.fiber.basic.basicdata", "BASIC_DATA","BasicData", "basic/data", false, "史恭文");
		WebObjFileControl webObjFileControl = new WebObjFileControl();
		webObjFileControl.setWebAppDir("O:/orcaldriver/fiber");
		webObjFileControl.setSrcDir("O:/orcaldriver/fiber/webapp");
		webObjFileControl.jspDir("/jsp/basic/data/");
	}
}
