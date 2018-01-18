/**
 * 
 */
package io.javabrains.springbootstarter.dto;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import io.javabrains.springbootstarter.entity.Roles;

/**
 * @author Kusma
 *
 * 12-Jan-2018
 */
public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private String passwordConfirm;
	private Set<Roles> roles;

	/*Default Constructor*/
	public UserDTO() {
		super();
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 */
	public UserDTO(Long id, String username, String password, String passwordConfirm) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public UserDTO(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/**
	 * @param username2
	 * @param id2
	 */
	public UserDTO(String username, Long id) {
		this.username =username;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Roles> getRoles() {
	    return roles;
	}

	public void setRoles(Set<Roles> roles) {
	    this.roles = roles;
	}

}
