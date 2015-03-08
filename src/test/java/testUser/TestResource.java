package testUser;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.dao.RoleDao;
import com.dream.entity.Resource;
import com.dream.vo.RoleVo;

public class TestResource {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
	RoleDao roleDao=(RoleDao) applicationContext.getBean("roleDao");	
	@Test
	public void testfindPermissions(){
		RoleVo roleVo=roleDao.findOne(1L);
		System.out.println(roleVo.getListResources().size());
	}
	
}
