/**
 * 
 */
package io.javabrains.springbootstarter.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.dto.CourseDTO;
import io.javabrains.springbootstarter.dto.CustomStatusCode;
import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.entity.Course;
import io.javabrains.springbootstarter.repository.CourseRepository;

/**
 * @author Kusma
 *
 * 19-Dec-2017
 */
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		return courseRepository.findAllByTopicId();
		
	}
	
	public List<Course> getAllCourseByTopicId(Long topicId){
		List<Course> courses =  new ArrayList<>();
		 courseRepository.findByTopicId(topicId)
		 .forEach(courses::add);
		return courses;
	} 
	
	public Course getCourse(Long id){
		return courseRepository.findOne(id);
	}
	public void addCourse(Course course){
		System.out.println("------+++++----"+course);
		courseRepository.save(course);
	}
	public void updateCourse( Course course, Long id){
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
	public void deleteCourse(Long id) {
	courseRepository.delete(id);;
		
	}
	
}
