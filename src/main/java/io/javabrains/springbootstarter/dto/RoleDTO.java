package io.javabrains.springbootstarter.dto;

import java.io.Serializable;

/**
 * @author Kusma Singh
 * @time 11:15:58 AM
 * @date 09-Feb-2018
 */
public class RoleDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8122842138622870413L;

	private Long id;

	private String name;
	
	

	public RoleDTO() {

	}

	
	
	/**
	 * @param id
	 * @param roleName
	 */
	public RoleDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public RoleDTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String roleName) {
		this.name = roleName;
	}

	
}

