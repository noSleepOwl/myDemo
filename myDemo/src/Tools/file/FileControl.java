package Tools.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.base.Strings;


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
		File cpFile = new File(verifyPath(copyTargetPath)+file.getName());
		if(!cpFile.exists()){
			try {
				cpFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(file.exists()&&file.isFile()){
			try (	BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
					BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(cpFile)); ){
				byte [] b = new byte[bufferSize];
				while(bufferedInputStream.read(b)>0){
					bufferedOutputStream.write(b);
					bufferedOutputStream.flush();
				}
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}else{
			return false;
			}
		return true;
	}
	
	/**
	 * 批量的文件拷贝,
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
	protected File createDir(String path){
		File file = new File(path);
		if(!file.exists()||file.isFile()) file.mkdirs();
		return file;
	}
	/**
	 * 验证文件路径结尾是否是 \ 或者 / 没有的话 加上
	 * @param path
	 * @return
	 */
	protected String verifyPath(String path){
		char suffix = path.charAt(path.length()-1);
		if(suffix == '\\' || suffix == '/') return path;
		else return path+File.separator;
	}
	private List<File> getFileByFilter(File file ,List<File> files, Predicate<String> filter){
		if(file.exists()){
			if(file.isDirectory()){
				File[] fileArray =  file.listFiles();
				for (File f : fileArray) {
					getFileByFilter(f, files,filter);
				}
			}
			if(file.isFile()){
				if(filter == null||filter.test(file.getName())){
					files.add(file);
				}
			}
		}
		return files;
	}
	public  List<File> getFileByFilter(File file,Predicate<String> filter){
		List<File> list = new ArrayList<>();
		getFileByFilter(file, list,filter);
		return list;
	}
	
	/**
	 * 批量读取 
	 * @param files
	 * @param outPath
	 * @param onlineChange
	 * @param onContentChange
	 * @param skip
	 */
	public void readAllFiles( List<File> files ,String outPath,Function<String, String> onlineChange,Function<String, String> onContentChange,long skip){
		for (File file : files) {
			readAllFiles(file, outPath, onlineChange, onContentChange,skip);
		}
	}
	
	/**
	 * 批量读取
	 * @param files
	 * @param outPath
	 * @param onContentChange
	 * @param skip
	 */
	public void readAllFiles( List<File> files ,String outPath,Function<String, String> onContentChange,long skip){
		readAllFiles(files, outPath,null, onContentChange,skip);
	}
	public void readAllFiles( List<File> files ,Function<String, String> onContentChange,long skip){
		for (File file : files) {
			readAllFiles(file, file.getAbsolutePath(),null, onContentChange,skip);
		}
	}
	/**
	 * 读取所有的文件 并对文本进行处理
	 * @param file 文件列表
	 * @param outPath 输出的文件位置
	 * @param onlineChange 对文件的每一行进行操作
	 * @param onContentChange 对文件的全文进行操作
	 * @param skip 跳过的行数
	 */
	public void readAllFiles(File file ,String outPath,Function<String, String> onlineChange,Function<String, String> onContentChange,long skip){
		if(file.exists()&&file.isFile()){
			File outTo = new File(outPath);
			if(outTo.exists() && outTo.isFile()){
			try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
					){
					 String res = in.lines().skip(skip).map(o->{
						if(onlineChange!=null){
							o= onlineChange.apply(o);
						}
						return o;
					}).reduce((a,b)->a+"\n"+b).map(o->{
						if(onContentChange!=null){
							o=onContentChange.apply(o);
						}
						return o;
					}).orElse("");
					 if(addSkip()){
						 String sk =in.lines().limit(skip).reduce((a,b)->a+"\n"+b).orElse("");
						 res = sk+res;
					 }
					 if(Strings.isNullOrEmpty(res))
					 {
						 write(res, outPath);
					 }
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public boolean addSkip(){
		 return true;
	 }
	public void write(String data , String filePath){
		File file = new File(filePath);
		try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))){
			bufferedWriter.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
