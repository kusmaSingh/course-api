/**
 * 
 */
package io.javabrains.springbootstarter.dto;

import java.io.Serializable;

/**
 * @author Kusma
 *
 *         28-Dec-2017
 */

public class TopicDTO implements Serializable {

	private Long id;
	private String stream;
	private String name;
	private String description;

	private static final long serialVersionUID = 2517561974281512788L;

	/*
	 * Default Contructor
	 */
	public TopicDTO() {
	}

	public TopicDTO(Long id) {
		this.id = id;
	}

	public TopicDTO(Long id, String stream, String name, String description) {
		super();
		this.id = id;
		this.stream = stream;
		this.name = name;
		this.description = description;
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public TopicDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/*
	 * Getter and Setter
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
