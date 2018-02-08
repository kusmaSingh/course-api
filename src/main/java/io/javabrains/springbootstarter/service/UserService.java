/**
 * 
 */
package io.javabrains.springbootstarter.service;

import java.util.List;

import io.javabrains.springbootstarter.entity.Roles;
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

	List<Roles> findRoleByUserId(Long id);


}
