/**
 * 
 */
package com.lecombattant.lemortier.service.roleserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecombattant.lemortier.dao.RoleDao;
import com.lecombattant.lemortier.domain.security.Role;
import com.lecombattant.lemortier.service.RoleService;

/**
 * @author Lecombattant
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Role findByName(String pName) {
		return roleDao.findByName(pName);
	}

}
