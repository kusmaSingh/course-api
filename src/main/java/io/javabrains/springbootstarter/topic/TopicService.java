/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.dto.CustomStatusCode;
import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.dto.TopicDTO;

/**
 * @author Kusma
 *
 */
@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	private Logger logger = LoggerFactory.getLogger(TopicService.class);


	public List<Topic> getAllTopics() {
		List<Topic> topic = new ArrayList<>();
		topicRepository.findAll().forEach(topic::add);
		return topic;
	}

	public Topic getTopic(Long id) {
		return topicRepository.findOne(id);
	}

	public ResponseDTO addTopic(Topic topic) {
		// System.out.println("------+++++----"+topic);
		topicRepository.save(topic);
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, CustomStatusCode.customStatuscodes.OK.getStatuscode(),
				new Topic(topic.getId(), topic.getName()), CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
		return responseDTO;
	}

	public void updateTopic(Topic topic, Long id) {
		/*
		 * for(int i=0 ; i<topics.size(); i++){ Topic t = topics.get(i);
		 * if(t.getId().equals(id)){ topics.set(i, topic); return; } }
		 */
		topicRepository.save(topic);

	}

	/**
	 * @param id
	 */
	public void deleteTopic(Long id) {
		topicRepository.delete(id);
		;

	}
}
