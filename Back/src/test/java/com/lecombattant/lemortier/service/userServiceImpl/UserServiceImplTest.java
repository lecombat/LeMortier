/**
 * 
 */
package com.lecombattant.lemortier.service.userServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lecombattant.lemortier.dao.MortierDao;
import com.lecombattant.lemortier.dao.UserDao;
import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.domain.security.Role;
import com.lecombattant.lemortier.domain.security.UserRole;
import com.lecombattant.lemortier.service.MortierService;
import com.lecombattant.lemortier.service.UserService;

/**
 * @author ltsobgni
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes= {MortierService.class, MortierDao.class})
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserDao userDao;
	
	
	@Test
	public void createUser() {
		String vName = "lecombattant";
		boolean vUserExist = userService.checkIfUserNameExist(vName);
		
		if(!vUserExist){
			User vUser = new User(vName);
			Set<UserRole> vUserRoles = new HashSet<>();
			vUserRoles.add(new UserRole(vUser, new Role("USER")));
	
			vUser = userService.create(vUser, vUserRoles);
			User vUserRetrive = userDao.findOne(vUser.getId());
			Assert.assertNotNull(vUser.equals(vUserRetrive));
		}else{
			Assert.assertTrue("Le user existe déja en BDD", vUserExist);
		}
	}
}
