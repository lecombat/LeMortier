/**
 * 
 */
package com.lecombattant.lemortier.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lecombattant.lemortier.domain.User;

/**
 * @author Lecombattant
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	public User findByUsername(String pUserName);

}
