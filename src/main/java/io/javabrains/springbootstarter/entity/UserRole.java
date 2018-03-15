package io.javabrains.springbootstarter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @author Kusma Singh
 * @time 1:35:50 PM
 * @date 09-Feb-2018
 */
@Entity
@Table(name = "USER_ROLE", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "USER_ID", "ROLE_ID" }, name = "UNQ_USER_ID_ROLE_ID"), })
public class UserRole {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7528746778697068908L;

	
	private Long id;
	
	
	private User user;
	
	
	private Roles role;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ROLE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@JsonIgnore
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="USER_ID" ,foreignKey = @ForeignKey(name = "FK_USER_ROLE_ID_U"), nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	@ManyToOne(targetEntity = Roles.class)
	@JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_USER_ROLE_ID_R"), nullable = false)
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
}

