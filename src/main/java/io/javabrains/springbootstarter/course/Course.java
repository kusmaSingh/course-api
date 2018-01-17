/**
 * 
 */
package io.javabrains.springbootstarter.course;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.javabrains.springbootstarter.topic.Topic;

/**
 * @author Kusma
 *
 */
@Entity
public class Course {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String stream;

	private String name;

	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/*
	 * Default Contructor
	 */
	public Course() {
	}

	/**
	 * @return the id
	 */
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
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}

	/**
	 * @param stream
	 *            the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course(Long id, String stream, String name, String description, Topic topic) {
		this.id = id;
		this.stream = stream;
		this.name = name;
		this.description = description;
		this.topic = topic;
	}
	public Course(Long id, String stream, String name, String description, Long topicId) {
		super();
		this.id = id;
		this.stream = stream;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId);
	}
}
