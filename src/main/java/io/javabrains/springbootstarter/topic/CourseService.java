/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kusma
 *
 * 19-Dec-2017
 */
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	/*private List<Topic> topics = new ArrayList(Arrays.asList(
			new Topic("spring", "Spring framework", "Spring framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description"),
			new Topic("angularjs", "Angularjs", "Angularjs Description"),
			new Topic("angular2/4", "Angular2/4", "Angular2/4 Description")
			));
	*/
	public List<Course> getAllCourses(){
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
		
	}
	
	public List<Course> getAllCourseByTopicId(String topicId){
		List<Course> courses =  new ArrayList<>();
		 courseRepository.findByTopicId(topicId)
		 .forEach(courses::add);
		return courses;
	} 
	
	public Course getCourse(String id){
		return courseRepository.findOne(id);
	}
	public void addCourse(Course course){
		System.out.println("------+++++----"+course);
		courseRepository.save(course);
	}
	public void updateCourse( Course course, String id){
	/*	for(int i=0 ; i<topics.size(); i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}*/
		courseRepository.save(course);

	}

	/**
	 * @param id
	 */
	public void deleteCourse(String id) {
	courseRepository.delete(id);;
		
	}
	
}
