package testUser;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.dao.UserDao;
import com.dream.entity.User;
import com.dream.vo.UserVo;

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
	@Test
	public void testfindByUsername(){
		User user=userDao.findByUsername("admin");
		System.out.println(user.getId());
	}
	@Test
	public void testSplit(){
		String[] s="1".split(",");
	}
	@Test
	public void testFindAll(){
		List<UserVo> userVos=userDao.findAll();
		System.out.println(userVos.size());
	}
}
