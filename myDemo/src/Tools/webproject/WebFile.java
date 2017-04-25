package Tools.webproject;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

import Tools.file.FileControl;

public class WebFile extends FileControl {
	private WebProject webProject;
	/**
	 * 传入参数
	 * @param webProject
	 */
	public WebFile(WebProject webProject) {
		this.webProject = webProject;
	}
	
	/**
	 * 根据过滤器 查找对应的 jsp 文件, 或者 是在 web app 下的其他文件
	 * @param filter
	 * @return
	 */
	public List<File> getWebAppFile(Predicate<String> filter){
		File file = new File(webProject.getWebDir());
		return getFileByFilter(file, filter);
	}
	
	/**
	 * 获取webAppFile指定后缀的文件
	 * @param filter
	 * @return
	 */
	public List<File> getWebAppFileByEndsWith(String endsWith){
		return getWebAppFile(o->o.endsWith(endsWith));
	}
	/**
	 * 获取所有的jsp文件
	 * @param filter
	 * @return
	 */
	public List<File> getJspFile(Predicate<String> filter){
		return getWebAppFile(o->o.endsWith(".jsp"));
	}
	
	
}
