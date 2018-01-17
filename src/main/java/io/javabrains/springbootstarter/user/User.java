/**
 * 
 */
package io.javabrains.springbootstarter.user;

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
 * 10-Jan-2018
 */
@Entity 
@Table(name = "user")
public class User {
private Long id;
private String username;
private String password;
private String passwordConfirm;
private Set<Roles> roles;

/*Default Constructor*/
public User() {
	super();
}

/**
 * @param id
 * @param username
 * @param password
 * @param passwordConfirm
 */
public User(Long id, String username, String password, String passwordConfirm) {
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
public User(Long id, String username, String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
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
