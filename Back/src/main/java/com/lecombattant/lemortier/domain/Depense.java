/**
 * 
 */
package com.lecombattant.lemortier.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Lecombattant
 *
 */
@Entity
public class Depense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="depenseId", nullable=false, updatable=false)
	private Long id;
	
	@Column(nullable=false)
	private String nom;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private User financeur; //TODO plus tard plusieurs personne pourront financer une seule depense
	
	@Column(nullable=false)
	private Double cout;
	
	@Column(nullable=false)
	private Date dateCreation = new Date();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mortier_id")
	@JsonIgnoreProperties("depenses")
	private Mortier mortier;

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the financeur
	 */
	public User getFinanceur() {
		return financeur;
	}

	/**
	 * @param financeur the financeur to set
	 */
	public void setFinanceur(User financeur) {
		this.financeur = financeur;
	}

	/**
	 * @return the cout
	 */
	public Double getCout() {
		return cout;
	}

	/**
	 * @param cout the cout to set
	 */
	public void setCout(Double cout) {
		this.cout = cout;
	}

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	/**
	 * @return the mortier
	 */
	public Mortier getMortier() {
		return mortier;
	}

	/**
	 * @param mortier the mortier to set
	 */
	public void setMortier(Mortier mortier) {
		this.mortier = mortier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depense other = (Depense) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
