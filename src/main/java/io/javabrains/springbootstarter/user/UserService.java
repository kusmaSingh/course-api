/**
 * 
 */
package io.javabrains.springbootstarter.user;


/**
 * @author Kusma
 *
 *         12-Jan-2018
 */

public interface UserService {
	void save(User user);

	public User findByUsername(String username);
	public User LoginUser(User user);
	

}
