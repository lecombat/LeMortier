/**
 * 
 */
package com.lecombattant.lemortier.service.userServiceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lecombattant.lemortier.dao.RoleDao;
import com.lecombattant.lemortier.dao.UserDao;
import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.domain.security.UserRole;
import com.lecombattant.lemortier.service.UserService;

/**
 * @author Lecombattant
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserDao userDao;
	
	@Autowired
	public RoleDao roleDao;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User create(User pUser, Set<UserRole> pUserRoles) {
		String encryptedPassword = passwordEncoder.encode(pUser.getPassword());
		pUser.setPassword(encryptedPassword);

        for (UserRole ur : pUserRoles) {
            roleDao.save(ur.getRole());
        }

        pUser.getUserRoles().addAll(pUserRoles);
		
		userDao.save(pUser);
		
		return pUser;
	}

	@Override
	public boolean checkIfUserNameExist(String pUserName) {
		User vUser = userDao.findByUsername(pUserName);
		
		return vUser != null;
	}

	@Override
	public User findUserById(Long pId) {
		return userDao.findOne(pId);
	}

	@Override
	public User findUserByName(String pUserName) {
		return userDao.findByUsername(pUserName);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userDao.findAll();
	}

}
