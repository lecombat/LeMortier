/**
 * 
 */
package com.lecombattant.lemortier.service.mortierServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lecombattant.lemortier.dao.DepenseDao;
import com.lecombattant.lemortier.dao.MortierDao;
import com.lecombattant.lemortier.domain.Depense;
import com.lecombattant.lemortier.domain.Mortier;
import com.lecombattant.lemortier.domain.User;
import com.lecombattant.lemortier.service.MortierService;

/**
 * @author Lecombattant
 *
 */
@Service
@Transactional(rollbackFor=java.sql.SQLException.class)
public class MortierServiceImpl implements MortierService {

	@Autowired
	private MortierDao mortierDao;
	
	@Autowired
	private DepenseDao depenseDao;
	
	@Override
	public Mortier create(Mortier pMortier) {
		
		mortierDao.save(pMortier);
		
		return pMortier;
	}

	@Override
	public Mortier addDepenses(Mortier pMortier, List<Depense> pListDepenses) {
		
		pMortier.addDepenses(pListDepenses); //TODO Verifier que les depenses sont differente avant d'inserer
		
		depenseDao.save(pListDepenses);
		
		return pMortier;
	}

	@Override
	public Mortier addParticipant(Long pIdMortier, User pParticipant) {
		Mortier vMortier = mortierDao.findOne(pIdMortier);
		if(vMortier != null){
			vMortier.getUsers().add(pParticipant);
		}
		//TODO gestion d'exception
		return vMortier;
	}

	@Override
	public boolean checkIfMortierNameExist(String pName) {
		Mortier vMortier = mortierDao.findByNom(pName);
		
		return vMortier != null;
	}

	@Override
	public List<Mortier> getMortiersForUser(User pUser) {
		
		return (List<Mortier>) mortierDao.findByOwnerUserId(pUser.getId());
	}

	@Override
	public Mortier getMortier(Long pMortierId) {
		return mortierDao.findOne(pMortierId);
	}
		

}
