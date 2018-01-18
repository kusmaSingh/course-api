/**
 * 
 */
package io.javabrains.springbootstarter.controller;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.dto.CustomStatusCode;
import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.dto.UserDTO;
import io.javabrains.springbootstarter.entity.User;
import io.javabrains.springbootstarter.repository.UserRepository;
import io.javabrains.springbootstarter.service.UserService;

/**
 * @author Kusma
 *
 *         12-Jan-2018
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseDTO registration(@RequestBody User user) {
		User userName = userService.findByUsername(user.getUsername());
		// String test = user.getUsername();
		if (userName != null) {
			return new ResponseDTO(HttpStatus.EXPECTATION_FAILED, CustomStatusCode.hTTPStatusMessage.FAILED.getValue());
		} else if (userName == null) {

			userService.save(user);
		}

		return new ResponseDTO(HttpStatus.OK, CustomStatusCode.customStatuscodes.OK.getStatuscode(),
				new UserDTO(user.getUsername(), user.getId()), CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public ResponseDTO login(@RequestBody UserDTO userDto) {
		User userName = userService.findByUsername(userDto.getUsername());
		if (null != userName) {
			/*User user = new User();
			user.setPassword(userDto.getPassword());
			user.setUsername(userDto.getUsername());
			userService.LoginUser(user);*/
			return new ResponseDTO(HttpStatus.OK, CustomStatusCode.customStatuscodes.OK.getStatuscode(),
					new UserDTO(userDto.getUsername(), userDto.getId()),
					CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
		}

		else {
			return new ResponseDTO(HttpStatus.EXPECTATION_FAILED, CustomStatusCode.hTTPStatusMessage.FAILED.getValue());
		}
	}

	
	@RequestMapping(value = "/testurl", method = RequestMethod.GET )
	public String login() {
		System.out.println("Test");
		return "KUSMA";
	}
}
