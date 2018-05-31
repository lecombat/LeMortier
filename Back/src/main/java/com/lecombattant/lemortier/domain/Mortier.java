/**
 * 
 */
package com.lecombattant.lemortier.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lecombattant.lemortier.constantes.Constantes;

/**
 * @author Lecombattant
 *
 */
@Entity
public class Mortier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mortier_id", nullable=false, updatable=false)
	private Long id;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private String statut = Constantes.STATUT_CREATE;
	
	@Column
	private Double cout = 0.0;
	
	@Column
	private Date dateCloture;
	
	@Column
	private Date dateCreation = new Date();
	
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinTable(
			name="mortier_users", 
			joinColumns={@JoinColumn(name="mortier_id")}, 
			inverseJoinColumns={@JoinColumn(name="user_id")})
	@JsonIgnoreProperties("mortiers")
	private List<User> users; 
	//TODO transformer les LIST en SET pour les annotations @ManyToMany
	//TODO ajouter les contraintes de cles
	
	@OneToMany(mappedBy="mortier", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Depense> depenses;
	
	/**
	 * Createur du mortier
	 */
	private Long ownerUserId;
	
	public Mortier() {
	}

	public Mortier(String pName) {
		this.nom = pName;
		this.dateCreation = new Date();
		this.depenses = new LinkedList<Depense>();
		this.users = new LinkedList<User>();
		this.statut = Constantes.STATUT_CREATE;
		this.cout = new Double(0);
	}
	
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
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
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
	 * @return the dateCloture
	 */
	public Date getDateCloture() {
		return dateCloture;
	}

	/**
	 * @param dateCloture the dateCloture to set
	 */
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
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
	 * @return the participants
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setUsers(List<User> pUsers) {
		this.users = pUsers;
	}

	/**
	 * @return the depenses
	 */
	public List<Depense> getDepenses() {
		return depenses;
	}

	/**
	 * @param depenses the depenses to set
	 */
	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}

	/**
	 * @return the ownerUserId
	 */
	public Long getOwnerUserId() {
		return ownerUserId;
	}

	/**
	 * @param ownerUserId the ownerUserId to set
	 */
	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cout == null) ? 0 : cout.hashCode());
		result = prime * result + ((dateCloture == null) ? 0 : dateCloture.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((depenses == null) ? 0 : depenses.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
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
		Mortier other = (Mortier) obj;
		if (cout == null) {
			if (other.cout != null)
				return false;
		} else if (!cout.equals(other.cout))
			return false;
		if (dateCloture == null) {
			if (other.dateCloture != null)
				return false;
		} else if (!dateCloture.equals(other.dateCloture))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (depenses == null) {
			if (other.depenses != null)
				return false;
		} else if (!depenses.equals(other.depenses))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		return true;
	}
}
