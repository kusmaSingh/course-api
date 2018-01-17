/**
 * 
 */
package io.javabrains.springbootstarter.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.dto.TopicDTO;

/**
 * @author Kusma
 *
 */
@Repository
public interface TopicRepository  extends JpaRepository<Topic, Long>{

	
}
