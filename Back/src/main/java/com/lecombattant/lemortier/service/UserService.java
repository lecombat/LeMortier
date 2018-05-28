/**
 * 
 */
package com.lecombattant.lemortier.service;

import java.util.List;
import java.util.Set;

import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.domain.security.UserRole;

/**
 * @author Lecombattant
 *
 */
public interface UserService {
	
	public User create(User pUser, Set<UserRole> pUserRoles);
	
	public boolean checkIfUserNameExist(String pName);
	
	public User findUserById(Long pId);
	
	public User findUserByName(String pUserName);
	
	public List<User> findAllUsers();
}
