package io.javabrains.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;

import io.javabarins.sprinbootstarter.security.jwt.model.UserContext;
import io.javabrains.springbootstarter.entity.User;
import io.javabrains.springbootstarter.service.UserService;



/**
 * @author Kusma Singh
 * @time 1:30:46 PM
 * @date 06-Feb-2018
 */
public class BaseController {
	@Autowired
	private UserService userService;

	public User getUserObj(UserContext userCtx) {
		return userService.findByUsername(userCtx.getUsername());
	}
}

