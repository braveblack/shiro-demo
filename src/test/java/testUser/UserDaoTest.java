package testUser;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.dao.UserDao;
import com.dream.entity.User;

public class UserDaoTest {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
	UserDao userDao=(UserDao) applicationContext.getBean("userDao");	
	@Test
	public void testUpdate(){
		User user=new User();
		user.setId(1L);
		user.setUsername("All");
		userDao.updateUser(user);
	}
}
