/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kusma
 *
 */
@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	/*private List<Topic> topics = new ArrayList(Arrays.asList(
			new Topic("spring", "Spring framework", "Spring framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description"),
			new Topic("angularjs", "Angularjs", "Angularjs Description"),
			new Topic("angular2/4", "Angular2/4", "Angular2/4 Description")
			));
	*/
	public List<Topic> getAllTopics(){
		List<Topic> topics =  new ArrayList<>();
		 topicRepository.findAll().forEach(topics::add);
		return topics;
	} 
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	public void addTopic(Topic topic){
		System.out.println("------+++++----"+topic);
		topicRepository.save(topic);
	}
	public void updateTopic( Topic topic, String id){
	/*	for(int i=0 ; i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		topicRepository.save(topic);

	}

	/**
	 * @param id
	 */
	public void deleteTopic(String id) {
	topicRepository.delete(id);;
		
	}
}






















