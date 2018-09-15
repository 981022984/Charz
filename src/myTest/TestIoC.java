package myTest;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import com.controller.localController;
import com.dao.ClassAndDept;
import com.dao.StudentCRUD;
import com.model.Student;
import com.model.User;
import com.service.loginServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-dao.xml"})//装配Spring
public class TestIoC {
	/**
	 * Spring IoC测试
	 */
	
	@Resource(name="loginservice")
	private loginServiceImpl loginservice;
	/*@Resource(name="user")
	private User user;*/
	
	@Test
	public void test() {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		User user = (User) context.getBean("user");*/
		//加载配置文件
		/*System.out.println(user)*/;
		String str = loginservice.modifyPassword("1415241", "123456", "654321", "654321");
		System.out.println("testGit");
		System.out.println("123---"+loginservice);
		System.out.println("456"+str);
	}
}





