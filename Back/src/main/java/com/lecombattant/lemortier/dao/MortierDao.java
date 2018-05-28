/**
 * 
 */
package com.lecombattant.lemortier.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lecombattant.lemortier.domain.Mortier;

/**
 * @author Lecombattant
 *
 */
@Repository
public interface MortierDao extends CrudRepository<Mortier, Long> {
	
	public Mortier findByNom(String pNom);
	
	public List<Mortier> findByOwnerUserId(Long pUserID);
}
