/**
 * 
 */
package com.lecombattant.lemortier.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.domain.security.UserRole;
import com.lecombattant.lemortier.service.RoleService;
import com.lecombattant.lemortier.service.UserService;

/**
 * @author Lecombattant
 *
 */
@RestController
@RequestMapping("/api/user")
@Transactional
public class UserController {
	
	private static final String ROLE_USER = "ROLE_USER";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("authentificate")
	public User user(@AuthenticationPrincipal User pUser) {
		return pUser;
	}
	
	@PostMapping(path="/create")
	public ResponseEntity<User> create(@RequestBody User pUser){
		
		if(userService.checkIfUserNameExist(pUser.getUsername())){
			return new ResponseEntity<>(HttpStatus.FOUND);
		}else{
			Set<UserRole> vUserRoles = new HashSet<>();
			vUserRoles.add(new UserRole(pUser, roleService.findByName(ROLE_USER)));
            
			return new ResponseEntity<User>(userService.create(pUser, vUserRoles), HttpStatus.OK);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> listUsers() {
		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);			
	}

}
