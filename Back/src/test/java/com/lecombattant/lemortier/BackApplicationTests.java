package com.lecombattant.lemortier;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lecombattant.lemortier.dao.MortierDao;
import com.lecombattant.lemortier.dao.UserDao;
import com.lecombattant.lemortier.domain.Mortier;
import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.domain.security.Role;
import com.lecombattant.lemortier.domain.security.UserRole;
import com.lecombattant.lemortier.service.MortierService;
import com.lecombattant.lemortier.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MortierService mortierService;
	
	
	@Autowired
	private MortierDao mortierDao;
	
	@Autowired
	private UserDao userDao;
	
	@Before
	public void setUp(){
		
	}
	
	
	@Test
	public void createMortier() {
		String vName = "First Mortier";
		Mortier vMortier = mortierService.create(new Mortier(vName));
		
		Mortier vMortierRetrieve = mortierDao.findOne(vMortier.getId());
		
		Assert.assertNotNull(vMortier.equals(vMortierRetrieve));
	}
	
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
	
	@Test
	public void checkUserNameExist(){
		String vName = "lecombattant";
		User vUser = new User(vName);
		Set<UserRole> vUserRoles = new HashSet<>();
		vUserRoles.add(new UserRole(vUser, new Role("USER")));

		vUser = userService.create(vUser, vUserRoles);
		boolean vResult = userService.checkIfUserNameExist(vName);
		userDao.delete(vUser.getId());
		
		Assert.assertTrue("Le user "+vName+" existe en BDD", vResult);
	}
	
	@Test
	public void checkUserNameNotExist(){
		String vName = "lecombattant";
		boolean vResult = userService.checkIfUserNameExist(vName);
		
		Assert.assertFalse("Le user "+vName+" n'existe pas encore en base", vResult);
	}

	@Test
	public void contextLoads() {
	}

}
