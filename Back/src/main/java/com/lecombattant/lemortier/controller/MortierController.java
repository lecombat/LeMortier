/**
 * 
 */
package com.lecombattant.lemortier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lecombattant.lemortier.domain.Mortier;
import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.service.MortierService;
import com.lecombattant.lemortier.service.UserService;

/**
 * @author Lecombattant
 *
 */
@RestController
@RequestMapping("/api/mortier")
public class MortierController {
	
	@Autowired
	private MortierService mortierService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Create Mortier
	 * @param pMortier
	 * @return
	 */
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Mortier> create(@RequestBody Mortier pMortier){
			
		if(mortierService.checkIfMortierNameExist(pMortier.getNom())){
			return new ResponseEntity<>(HttpStatus.FOUND);
		}else if (pMortier.getOwnerUserId() == null || userService.findUserById(pMortier.getOwnerUserId()) == null){ //TODO contrainte de clé secondaire
			return new ResponseEntity<Mortier>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Mortier>(mortierService.create(pMortier), HttpStatus.OK);
		}
		
	}
	
	/**
	 * Retrieve all mortier created by de user pUser
	 * @return
	 */
	@GetMapping(path = "/mortiersForUser/{user_id}", produces = "application/json")
	public ResponseEntity<List<Mortier>> getMortiersForUsers(@PathVariable("user_id") Long pUserId){	
		User vUser = userService.findUserById(pUserId);
		
		if(vUser != null) {
			return new ResponseEntity<List<Mortier>>(mortierService.getMortiersForUser(vUser), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
}
