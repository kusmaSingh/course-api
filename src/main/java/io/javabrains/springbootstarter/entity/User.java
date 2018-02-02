/**
 * 
 */
package io.javabrains.springbootstarter.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Kusma
 *
 *         10-Jan-2018
 */
/**
 * @author insonix
 *
 */
@Entity
@Table(name = "user")
public class User {

	private Long id;
	private String firstname;
	private String username;
	private String password;
	private String lastname;
	private Long phonenumber;

	private Set<Roles> roles;

	/* Default Constructor */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 */
	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(Long id, String firstname, String username, String password, String lastname, Long phonenumber,
			Set<Roles> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.roles = roles;
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
	 * @param id
	 *            the id to set
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
	 * @param username
	 *            the username to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
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
