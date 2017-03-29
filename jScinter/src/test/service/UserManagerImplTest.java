package test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scinter.www.dao.UserMapper;

public class UserManagerImplTest {
	
	private ApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		System.out.println("===start===");
		ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("===end===");
	}

	@Test
	public void testSelectByPrimaryKey() {
		UserMapper obj = (UserMapper)ac.getBean("userMapperImpl");
		System.out.println(obj.selectByPrimaryKey(585).getNickName());
	}

}