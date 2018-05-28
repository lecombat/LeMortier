/**
 * 
 */
package com.lecombattant.lemortier.domain.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lecombattant.lemortier.domain.User;

/**
 * @author Lecombattant
 *
 */
@Entity
@Table(name="user_role")
public class UserRole {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {}

	/**
	 * @return the userRoleId
	 */
	public long getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
