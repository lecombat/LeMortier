/**
 * 
 */
package com.lecombattant.lemortier.service.mortierServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lecombattant.lemortier.dao.MortierDao;
import com.lecombattant.lemortier.domain.Mortier;
import com.lecombattant.lemortier.service.MortierService;

/**
 * @author ltsobgni
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes= {MortierService.class, MortierDao.class})
public class MortierServiceImplTest {
	
	@Autowired
	private MortierService mortierService;
	
	
	@Autowired
	private MortierDao mortierDao;
	
	
	@Test
	public void createMortier() {
		String vName = "lecombattant";
		boolean vMortierExist = mortierService.checkIfMortierNameExist(vName);
		
		if(!vMortierExist){
			Mortier vMortier = new Mortier(vName);
	
			vMortier = mortierService.create(vMortier);
			Mortier vMortierRetrive = mortierDao.findOne(vMortier.getId());
			Assert.assertNotNull(vMortier.equals(vMortierRetrive));
		}else{
			Assert.assertTrue("Le user existe déja en BDD", vMortierExist);
		}
	}
}
