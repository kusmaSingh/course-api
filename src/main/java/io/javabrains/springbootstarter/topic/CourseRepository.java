/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kusma
 *
 * 19-Dec-2017
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String>{
	public List<Course> findByTopicId(String topicId);
	public List<Course> findAll();

}
