/**
 * 
 */
package io.javabrains.springbootstarter.serviceImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.dto.RoleDTO;
import io.javabrains.springbootstarter.dto.UserDTO;
import io.javabrains.springbootstarter.entity.Roles;
import io.javabrains.springbootstarter.entity.User;
import io.javabrains.springbootstarter.repository.RolesRepository;
import io.javabrains.springbootstarter.repository.UserRepository;
import io.javabrains.springbootstarter.service.UserService;



/**
 * @author Kusma
 *
 * 12-Jan-2018
 */
@Service
public class UserServiceImpl implements UserService {
	
		@Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RolesRepository rolesRepository;
	   
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	/* (non-Javadoc)
	 * @see io.javabrains.springbootstarter.user.UserService#save(io.javabrains.springbootstarter.user.User)
	 */
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//user.setRoles(new HashSet<>(rolesRepository.findAll()));
		 userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see io.javabrains.springbootstarter.user.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		  return userRepository.findByUsername(username);
	}

	/* (non-Javadoc)
	 * @see io.javabrains.springbootstarter.user.UserService#LoginUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User LoginUser(User user) {
		
		return userRepository.findByUsername(user.getUsername());
	}

	@Override
	public List<RoleDTO> findRoleByUserId(Long id) {
		return  userRepository.findRolesById(id);
	}

	@Override
	public UserDTO findOne(String username) {
		return userRepository.findOne(username);
	}

}
