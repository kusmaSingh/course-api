/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kusma
 *
 *         19-Dec-2017
 */
@RestController
public class CourseController {
	public static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/courses")
	public List<Course> getAllCourses(){
		logger.info("get all course ");
		return courseService.getAllCourses();
		
	}
	
	
	@RequestMapping("/topics/{id}/course")
	public List<Course> getAllCourseByTopicId(@PathVariable String id) {
		logger.info("get all course ");
		return courseService.getAllCourseByTopicId(id);
	}

	@RequestMapping("/topics/{topicId}/course/{id}")
	public Course getCourse(@PathVariable String id) {
		logger.info("get all course via topic id ");
		return courseService.getCourse(id);
	}

	@RequestMapping(value = "/topics/{topicId}/course/{id}", method = RequestMethod.POST)
	public String addCourse(@RequestBody Course course, @PathVariable String topicId) {
		logger.info("add new Course ");
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return "done";
	}

/*	@RequestMapping(value = "/topics/{topicId}/course/{id}", method = RequestMethod.POST)
	public String updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course, id);
		return "update done";
	}*/

	@RequestMapping(value = "/topics/{topicId}/course/{id}", method = RequestMethod.DELETE)
	public String deleteCourse(@PathVariable String id) {
		logger.info("delete Course");
		courseService.deleteCourse(id);
		return "remove";
	}

}
