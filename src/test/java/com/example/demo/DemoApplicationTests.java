package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserService userservice;

//	@Test
//	public void findUserTest() throws Exception {
//		User user = userservice.findUserByName("各");
//		System.out.println(user.getName());
//	}
	
	
	@Test
	public void insertUserTest() throws Exception {
		User user = new User();
		for(Long i = 3L; i < 100L; ++i) {
			user.setId(i);
			user.setCreateTime(new Date());
			user.setName("地方"+i);
			userservice.insertUser(user);
		}
		
		//System.out.println(userservice.findUserById(1L));
		
	}
	
	@Test
	public void findByName() throws Exception {
		User user = new User();
		for(Long i = 3L; i < 100L; ++i) {
			user.setId(i);
			user.setCreateTime(new Date());
			user.setName("地方"+i);
			userservice.insertUser(user);
		}
		
		//System.out.println(userservice.findUserById(1L));
		
	}
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	//日志测试类
    public static void main(String[] args) {
        logger.debug("------the server is running------");
    }
}
