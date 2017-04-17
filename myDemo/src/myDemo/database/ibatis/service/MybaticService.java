package myDemo.database.ibatis.service;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myDemo.database.ibatis.mapper.TableMapper;

public  class MybaticService<R> {
	private static String resource = "mybatis.xml";
	private static  SqlSession session ;
	private Function<TableMapper, R> function;
	private static SqlSessionFactory sqlSessionFactory;
	public  MybaticService(Function<TableMapper, R> function) {
		this.function = function;
	}
	public MybaticService(){}
	static {
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession(){
		return session != null?session:sqlSessionFactory.openSession();
	}
	public R run(){
		TableMapper tableMapper = getTableMapper();
		R r = null;
		try { 
			r= function.apply(tableMapper);
			submit();
		} catch (Exception e) {
			rollBack();
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	public TableMapper getTableMapper(){
		return session.getMapper(TableMapper.class);
	}
	private void close(){
		session.close();
	}
	private void submit(){
		session.commit();
	}
	private void rollBack(){
		session.rollback();
	}
}
