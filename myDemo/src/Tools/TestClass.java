package Tools;

import java.io.File;

import Tools.file.FileControl;

public class TestClass {
	
	public static void main(String[] args) {
//		String test = "name/age/test";
//		String age = "name/age";
//		String re = test.substring(test.indexOf(age)+age.length(), test.length());
//		System.out.println(re);
		FileControl fileControl = new FileControl() { }; 
		fileControl.copyFolder("C:/Users/uigsw/Desktop/DBF Viewer 2000", "C:/Users/uigsw/Desktop/test");
	}
}
