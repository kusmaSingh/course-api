/**
 * 
 */
package io.javabrains.springbootstarter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kusma
 *
 *         12-Jan-2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
