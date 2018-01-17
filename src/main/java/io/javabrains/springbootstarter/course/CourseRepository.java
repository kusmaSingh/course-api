/**
 * 
 */
package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.dto.CourseDTO;

/**
 * @author Kusma
 *
 * 19-Dec-2017
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	public List<Course> findByTopicId(Long topicId);
	@Query("Select NEW io.javabrains.springbootstarter.dto.CourseDTO(cr.id, cr.name, cr.description,topic.id)" 
			+ "FROM Course as cr " 
			+ "INNER JOIN cr.topic AS topic") 
	public List<Course> findAllByTopicId();
	//public List<Course> findAll();

}
