/**
* 
*/
package io.javabrains.springbootstarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.dto.RoleDTO;
import io.javabrains.springbootstarter.dto.UserDTO;
import io.javabrains.springbootstarter.entity.User;

/**
 * @author Kusma
 *
 *         12-Jan-2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	@Query("SELECT NEW io.javabrains.springbootstarter.dto.RoleDTO(r.id, r.name) FROM User AS u "
			+ " INNER JOIN u.userRoles AS ur " + " INNER JOIN ur.role AS r " + " WHERE u.id =:userId")
	public List<RoleDTO> findRolesById(@Param("userId") Long userId);

	/**
	 * This function is user return DTO from User entity.
	 * 
	 * @param username
	 * @return
	 */
	@Query("SELECT NEW io.javabrains.springbootstarter.dto.UserDTO"  
	 		+ "(us.id , "
	 		+ "us.firstname ,"
	 		+ "us.lastname ,"
	 		+ "us.username ,"
	 		+ "us.phonenumber)"
	 		+ "FROM User AS us "
	 		+ "WHERE us.username=:username")
	public UserDTO findOne(@Param("username") String username);
	
}
