/**
 * 
 */
package io.javabrains.springbootstarter.dto;

import javax.persistence.Id;

/**
 * @author Kusma
 *
 * 28-Dec-2017
 */
public class TopicDTO {
	
	private String id;
	
	private String name;
	private String description;

	/*@OneToMany(mappedBy="topic",cascade=CascadeType.ALL)
	List<Course> courses;*/
	/*
	 *Default Contructor
	 */
	public TopicDTO() {	
	}
	
	
	/**
	 * Parameterized Constructor
	 * @param id
	 * @param name
	 * @param description
	 */
	public TopicDTO(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/*
	 * Getter and Setter
	 */ 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*
	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}*/


}
