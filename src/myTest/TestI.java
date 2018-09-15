package myTest;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.dao.StudentCRUD;

@Component(value="testI")
public class TestI {
	@Resource(name="studentCRUD")
	private StudentCRUD studentCRUD;
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	public void sys() {
		System.out.println("1--"+sqlSessionFactory);
	}
}
