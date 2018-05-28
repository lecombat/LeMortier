/**
 * 
 */
package com.lecombattant.lemortier.service;

import com.lecombattant.lemortier.domain.security.Role;

/**
 * @author Lecombattant
 *
 */
public interface RoleService {
	public Role findByName(String pName);
}
