package Tools;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.guice.MyBatisModule;

import myDemo.database.ibatis.service.MybaticService;

public class TestClass{
	public static void main(String[] args) {
		int res = new MybaticService<Integer>(o->{
			return o.countAll();
		}).run();
		System.out.println(res);
		SqlSession session = MybaticService.getSession();
		session.selectList("");
		
	}
}