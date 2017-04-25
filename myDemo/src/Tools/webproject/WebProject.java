package Tools.webproject;

import java.io.File;
import java.util.List;

public class WebProject {
	public WebProject(String proDir) {
		this.proDir = proDir;
		this.webDir = proDir +"/webapp";
		this.srcDir=proDir+"/src";
	}
	private List<File> jspFile;
	/**
	 *项目地址 
	 */
	private String proDir;
	/**
	 * web应用地址
	 */
	private String webDir;
	/**
	 * 主要的资源文件地址
	 */
	private String srcDir;
	
	public String getProDir() {
		return proDir;
	}
	public void setProDir(String proDir) {
		this.proDir = proDir;
	}
	public String getWebDir() {
		return webDir;
	}
	public void setWebDir(String webDir) {
		this.webDir = webDir;
	}
	public String getSrcDir() {
		return srcDir;
	}
	public void setSrcDir(String srcDir) {
		this.srcDir = srcDir;
	}
	public List<File> getJspFile() {
		return jspFile;
	}
	public void setJspFile(List<File> jspFile) {
		this.jspFile = jspFile;
	}
}
