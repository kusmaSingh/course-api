/**
 * 
 */
package io.javabrains.springbootstarter.dto;

/**
 * @author Kusma
 *
 * 28-Dec-2017
 */
public class CourseDTO {
	private Long id;
	
	private String stream; 
	
	private String name;
	private String description;
	private TopicDTO topicDTO;
	
	

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
	public CourseDTO(Long id, String name, String description, Long topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topicDTO = new TopicDTO(topicId);
	}
	
	public CourseDTO(Long id, String name, String description){
		this.id = id;
		this.name=name;
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
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}


	/**
	 * @return the topicDTO
	 */
	public TopicDTO getTopicDTO() {
		return topicDTO;
	}


	/**
	 * @param topicDTO the topicDTO to set
	 */
	public void setTopicDTO(TopicDTO topicDTO) {
		this.topicDTO = topicDTO;
	}
	
}
