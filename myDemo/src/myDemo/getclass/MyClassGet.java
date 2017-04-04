package myDemo.getclass;

import java.net.URL;

/**
 * 通过包的名称来加载一些类
 * @author uigsw
 *
 */
public class MyClassGet {
	
	
	public static void main(String[] args) {
		new MyClassGet().getAllUrl();
	}
	
	public void getAllUrl(){
		URL url= Thread.currentThread().getContextClassLoader().getResource("/java/lang/");
		print(url);
	}
	private void print(Object ...args){
		for (Object object : args) {
			System.out.println(object);
		}
	}
	
}
