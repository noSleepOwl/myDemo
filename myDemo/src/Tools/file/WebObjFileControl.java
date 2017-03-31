package Tools.file;

import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 项目文件的操作类
 * @author uigsw 
 *
 */
public class WebObjFileControl  extends FileControl{
	/**
	 * 项目资源文件的地址
	 */
	private String srcDir;
	/**
	 * web应用的地址
	 */
	private String webAppDir;
	
	/**
	 * 包名替换路径名称
	 * @param packagePath
	 * @return  错误返回 null
	 */
	public String packagePathToDir(String packagePath){
		Pattern pattern = Pattern.compile("(\\w+\\.+)+\\w+");
		Matcher matcher = pattern.matcher(packagePath);
		if(matcher.matches()){
			 return srcDir+packagePath.replaceAll("\\.", "/");
		} return null;
	}
	/**
	 * 地址转换成 包的名称
	 * @param dir
	 * @return
	 */
	public String dirToPackagePath(String dir){
		if(dir.startsWith(srcDir)&&dir.length() != srcDir.length()){
			return   dir.substring(srcDir.length()).replaceAll("[\\\\|/]", ".");
		} return null;
	}
	public String jspDir(String dir){
		return webAppDir+dir;
	}
	/**
	 * 获取 地址
	 * @return
	 */
	public String getSrcDir() {
		return srcDir;
	}
	/**
	 * 设置项目的 地址 , 转换成 结尾是/ 的 保存在类的参数中
	 * @param srcDir
	 */
	public void setSrcDir(String srcDir) {
		this.srcDir = verifyPath(Paths.get(srcDir).toString());
	}
	public String getWebAppDir() {
		return webAppDir;
	}
	/**
	 * webApp 的地址
	 * @param webAppDir
	 */
	public void setWebAppDir(String webAppDir) {
		this.webAppDir = verifyPath(Paths.get(webAppDir).toString());
	}
}
