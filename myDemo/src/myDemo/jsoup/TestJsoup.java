package myDemo.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import myDemo.MyDemon;

public class TestJsoup implements MyDemon{
	public static final String CHARSET_NAME_UTF_8 = "UTF-8"; 
	public static void main(String[] args) {
//		O:\getHub\myDemo\myDemo\srcFile\view.html
		File file = new File(BASE_URL+"/srcFile/view.html");
		try {
			 Document document = Jsoup.parse(file, CHARSET_NAME_UTF_8);
			 String html = document.select("body").html().toString();
			 html = html.replaceAll("\\$\\[name\\=\\((.*)\\)\\s+value=\\((.*)\\)\\]", "$2,$1");
			 System.out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
