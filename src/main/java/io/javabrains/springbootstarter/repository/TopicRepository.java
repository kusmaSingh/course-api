/**
 * 
 */
package io.javabrains.springbootstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.dto.TopicDTO;
import io.javabrains.springbootstarter.entity.Topic;

/**
 * @author Kusma
 *
 */
@Repository
public interface TopicRepository  extends JpaRepository<Topic, Long>{

	
}
