/**
 * 
 */
package com.lecombattant.lemortier.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lecombattant.lemortier.domain.Depense;
import com.lecombattant.lemortier.domain.Mortier;

/**
 * @author Lecombattant
 *
 */
@Repository
public interface DepenseDao extends CrudRepository<Depense, Long> {
	
	public Depense findByNom(String pNom);
	
	public List<Mortier> findByMortier(Mortier pMortier);
}
