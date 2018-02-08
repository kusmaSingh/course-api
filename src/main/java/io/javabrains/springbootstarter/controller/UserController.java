/**
 * 
 */
package io.javabrains.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
 * @date  12-Jan-2018
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

/*	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseDTO registration(@RequestBody User user) {
		User userName = userService.findByUsername(user.getUsername());
		/*Roles role = new Roles();
		role.setId(id);*/
		// String test = user.getUsername();
		if (userName != null) {
			return new ResponseDTO(HttpStatus.CONFLICT, CustomStatusCode.hTTPStatusMessage.CONFLICT.getValue());
		} else {

			userService.save(user);
		}

		return new ResponseDTO(HttpStatus.OK, CustomStatusCode.customStatuscodes.OK.getStatuscode(),
				new UserDTO(user.getUsername(), user.getId()), CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseDTO login(@RequestBody UserDTO userDto) {
		boolean isPasswordMatch = false;
		User user = userService.findByUsername(userDto.getUsername());
		System.out.println(bCryptPasswordEncoder);
		if (null != user) {
			isPasswordMatch = bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword());
			if (isPasswordMatch == true) {
				return new ResponseDTO(HttpStatus.OK, CustomStatusCode.customStatuscodes.OK.getStatuscode(),
						new UserDTO(user.getUsername(), user.getId()),
						CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
			} else if (isPasswordMatch == false) {
				String meesage = "Invalid Username and Password ";
				return new ResponseDTO(HttpStatus.EXPECTATION_FAILED,
						CustomStatusCode.customStatuscodes.FAIL.getStatuscode(),
						CustomStatusCode.hTTPStatusMessage.INVALID.getValue());
			}
		}
		return new ResponseDTO(HttpStatus.EXPECTATION_FAILED,CustomStatusCode.customStatuscodes.FAIL.getStatuscode(),
				CustomStatusCode.hTTPStatusMessage.INVALID.getValue());

	}
*/
	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	public String login() {
		System.out.println("Test");
		return "KUSMA";
	}
}
