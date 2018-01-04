/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kusma
 *
 * 19-Dec-2017
 */
@Repository("course")
public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);
/*	@Query("Select NEW io.javabrains.springbootstarter.dto.CourseDTO(cr.id, cr.name, cr.description)"
			+ "FROM Course as cr INNER JOIN Topic as tp"
			+ "tp.id =cr.topic_id")*/
	public List<Course> findAll();

}
