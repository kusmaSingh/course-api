/**
 * 
 */
package io.javabrains.springbootstarter.dto;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.springbootstarter.topic.Topic;

/**
 * @author Kusma
 *
 * 28-Dec-2017
 */
public class CourseDTO {
	@Id
	private String id;
	
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	/*
	 *Default Contructor
	 */
	public CourseDTO() {	
	}
	
	
	/**
	 * Parameterised Contructor
	 * @param id
	 * @param name
	 * @param description
	 */
	public CourseDTO(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "","");
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
}
