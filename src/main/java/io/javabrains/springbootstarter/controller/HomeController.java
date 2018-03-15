package io.javabrains.springbootstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.javabarins.sprinbootstarter.security.jwt.model.UserContext;
import io.javabrains.springbootstarter.dto.CustomStatusCode;
import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.dto.UserDTO;
import io.javabrains.springbootstarter.service.UserService;
import io.javabrains.springbootstrater.util.ToolBoxUtil;

/**
 * @author Kusma Singh
 * @time 3:23:05 PM
 * @date 08-Feb-2018
 */
@RestController
@RequestMapping("/api/user")
public class HomeController extends BaseController  {
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String index() {
		return "API";
	}
	@RequestMapping("home")
	public ModelAndView home(ModelMap modal) {
		logger.info("index");
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("name", "Hello Home page");
		return modelAndView;
	}
	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	public ResponseDTO findOne(Authentication authentication) {
		UserDTO userDTO = null;
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.NO_CONTENT, userDTO);
		UserContext userContext = (UserContext) authentication.getPrincipal();
		if(!ToolBoxUtil.isObjectEmpty(userContext)){
			userDTO = userService.findOne(userContext.getUsername());
			responseDTO = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), userDTO,
					CustomStatusCode.hTTPStatusMessage.SUCCESS.getValue());
		}
		return responseDTO;
		
	}
}
