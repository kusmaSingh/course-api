/**
 * 
 */
package io.javabrains.springbootstarter.service;

import java.util.List;

import io.javabrains.springbootstarter.dto.RoleDTO;
import io.javabrains.springbootstarter.dto.UserDTO;
import io.javabrains.springbootstarter.entity.User;

/**
 * @author Kusma
 *
 *         12-Jan-2018
 */

public interface UserService {
	void save(User user);

	public User findByUsername(String username);
	public User LoginUser(User user);
	/**
	 * This function is return information of DTO from User entity.
	 * @param email
	 * @return
	 */
	public UserDTO findOne(String username);
	List<RoleDTO> findRoleByUserId(Long id);


}
