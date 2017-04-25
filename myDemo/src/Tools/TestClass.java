package Tools;

import java.io.File;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Strings;

import Tools.webproject.WebFile;
import Tools.webproject.WebProject;

public class TestClass{
	public static void main(String[] args) {
		WebProject webProject = new WebProject("O:/orcaldriver/njust-jw");
		WebFile webFile = new WebFile(webProject);
		List<File> file = webFile.getWebAppFileByEndsWith("_alert.jsp");
		System.out.println(file.size());
		webFile.readAllFiles(file, o->{
			System.out.println("---------");
			Document document = Jsoup.parse(o);
			Elements elements =document.select(".modal-body  table ");
			for (Element element : elements) {
				String ToobarId = element.attr("data-toolbar");
				if(!Strings.isNullOrEmpty(ToobarId)){
					document.select(ToobarId).remove();
				}
			}
			return document.select("body").html();
		},2);
	}
}