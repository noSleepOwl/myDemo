package Tools.String;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author uigsw
 *  用于处理字符串的类
 */
public class StringControl {
	/**
	 * 专业代码
	 */
	
	/**
	 * 字符串分割
	 * @param regex 正则表达式
	 * @param tar 目标字符串
	 * @return
	 */
	public String[] split(String regex,String tar){
		return tar.split(regex);
	}
	/**
	 * @param tar 需要修改的字符串数组
	 * @param function 回调函数 入参 String[] 返回 String
	 * @return 
	 */
	public Optional<String> format(String[] tar , BinaryOperator<String> accumulator){
		return  Stream.of(tar).reduce(accumulator);
	}
	
	/**
	 * 返回 sql 语句中的 ('a','b','c') 样式的字符串
	 * @param tar  目标字符串
	 * @param regex 正则表达式
	 * @return  成功返回字符串截取后拼接成的值  失败后返回 "";
	 */
	public String changeToSqlInsertValueOrIn(String tar,String regex){
		/*这里尝试使用 两个参数对应一个参数的方式进行 lambda 进行便捷的书写*/
		BinaryOperator<String> arrtostring = this::addDouHao;
		Function<String,String> mapper = this::perfixAndEnd;
		return Stream.of(split(regex, tar)).reduce(arrtostring).map(mapper).orElse("");
	}
	/**前后都加上 ('+tar+');
	 * @param tar
	 * @return
	 */
	private String perfixAndEnd(String tar){
		return "('"+tar.trim()+"')";
	}
	/**
	 * 中间的空格符号替换成 ','
	 * @param count
	 * @param item
	 * @return
	 */
	private String addDouHao(String count ,String item){
		return count+"','"+item;
	}
}
