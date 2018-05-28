/**
 * 
 */
package com.lecombattant.lemortier.service;

import java.util.List;

import com.lecombattant.lemortier.domain.Depense;
import com.lecombattant.lemortier.domain.Mortier;
import com.lecombattant.lemortier.domain.User;

/**
 * @author Lecombattant
 *
 */

public interface MortierService {

	public Mortier create(Mortier pName);
	
	public Mortier addDepense(Long pIdMortier, Depense pDepense);
	
	public Mortier addParticipant(Long pIdMortier, User pParticipant);
	
	public boolean checkIfMortierNameExist(String pName);

	public List<Mortier> getMortiersForUser(User pUser);
}
