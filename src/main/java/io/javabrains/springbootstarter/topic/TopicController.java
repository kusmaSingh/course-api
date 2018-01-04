package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.dto.ResponseDTO;



/**
 * @author Kusma
 *
 */
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopicByid(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public ResponseDTO addTopic(@RequestBody Topic topic) {
		//topicService.addTopic(topic);
		return topicService.addTopic(topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.POST)
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return "done";
	}

	@RequestMapping(value = "/topics/remove/{id}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "remove";
	}

}
