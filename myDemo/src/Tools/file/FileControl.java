package Tools.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作的抽象类 一般的包含的文件的操,复制,黏贴 重命名
 * @author uigsw
 *
 */
public abstract class FileControl {
	/**
	 *文件读取缓冲区的大小
	 */
	private int bufferSize = 1024;
	/**
	 * 拷贝文件
	 * @param pathname 文件 地址
	 * @param copyTargetPath 拷贝到的目标 地址
	 * @return true 成功 , false 失败
	 */
	public boolean copyFile(String pathname,String copyTargetPath){
		File file = new File(pathname);
		File targetFile = this.createDir(copyTargetPath);
		if(file.exists()&&file.isFile()){
			BufferedInputStream bufferedInputStream = null;
			BufferedOutputStream bufferedOutputStream = null;
			try {
				File cpFile = new File(verifyPath(copyTargetPath)+file.getName());
				if(!cpFile.exists())cpFile.createNewFile();
				bufferedInputStream= new BufferedInputStream(new FileInputStream(file));
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(cpFile));
				byte [] b = new byte[bufferSize];
				while(bufferedInputStream.read()>0){
					bufferedOutputStream.write(b);
					bufferedOutputStream.flush();
				}
			} catch ( IOException e) {
				e.printStackTrace();
			}finally {
				if(bufferedInputStream!= null)
					try { bufferedInputStream.close(); } 
					catch (IOException e) { e.printStackTrace();}
				if(bufferedOutputStream != null)
					try { bufferedOutputStream.close(); } 
					catch (IOException e) { e.printStackTrace();}
			}
		}else return false;
		return true;
	}
	
	/**
	 * 地址  : 处理
	 * @param pathname
	 * @param copyTargetPath
	 * @return
	 */
	public boolean copyFolder(String pathname,String copyTargetPath){
		File file =new File(pathname);
		if(file.exists()&&file.isDirectory()){
			File copyTar = createDir(verifyPath(copyTargetPath)+file.getName());
			File[] files = file.listFiles();
			for (File file2 : files) {
				copyFolder(file2.getAbsolutePath(), copyTar.getAbsolutePath());
			}
		}else copyFile(pathname, copyTargetPath);
		return true;
	}
	/**
	 * 路径不存在,或者路径是个文件创建一个文件 并返回
	 * @param path
	 * @return
	 */
	private File createDir(String path){
		File file = new File(path);
		if(!file.exists()||file.isFile()) file.mkdirs();
		return file;
	}
	/**
	 * 验证文件路径结尾是否是 \ 或者 / 没有的话 加上
	 * @param path
	 * @return
	 */
	private String verifyPath(String path){
		char suffix = path.charAt(path.length()-1);
		if(suffix == '\\' || suffix == '/') return path;
		else return path+File.separator;
	}
}
