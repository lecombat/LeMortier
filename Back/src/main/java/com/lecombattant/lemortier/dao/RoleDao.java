/**
 * 
 */
package com.lecombattant.lemortier.dao;

import org.springframework.data.repository.CrudRepository;

import com.lecombattant.lemortier.domain.security.Role;

/**
 * @author Lecombattant
 *
 */
public interface RoleDao extends CrudRepository<Role, Long> {
	public Role findByName(String pName);
}
