/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Kusma
 *
 */
@Entity
public class Course {
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
	public Course() {	
	}
	
	
	/**
	 * Parameterised Contructor
	 * @param id
	 * @param name
	 * @param description
	 */
	public Course(String id, String name, String description, String topicid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicid, "","");
	}
	public Course(String id, String name, String description, Topic topic) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = topic;
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
