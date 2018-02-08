package io.javabrains.springbootstarter.security.auth.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javabrains.springbootstarter.dto.CustomStatusCode;
import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.exception.AuthMethodNotSupportedException;
import io.javabrains.springbootstarter.exception.InvalidJwtTokenException;
import io.javabrains.springbootstarter.exception.JwtExpiredTokenException;
import io.javabrains.springbootstarter.exception.LogoutException;

/**
 * @author Kusma Singh
 * @time 5:56:32 PM
 * @date 05-Feb-2018
 */
@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private final ObjectMapper mapper;

	@Autowired
	public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper) {

		this.mapper = mapper;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ResponseDTO responseDTO = null;
		if (e instanceof BadCredentialsException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.BAD_CREDENTIALS.getStatusCode(), "Invalid username or password");
			mapper.writeValue(response.getWriter(), responseDTO);
		} else if (e instanceof JwtExpiredTokenException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.JWT_TOKEN_EXPIRED.getStatusCode(), "Token has expired");
			mapper.writeValue(response.getWriter(), responseDTO);
		} else if (e instanceof InvalidJwtTokenException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.INVALID_JWT_TOKEN.getStatusCode(), "Invalid Jwt token.");
			mapper.writeValue(response.getWriter(), responseDTO);
		} else if (e instanceof LogoutException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.JWT_TOKEN_EXPIRED.getStatusCode(), "Token has expired.");
			mapper.writeValue(response.getWriter(), responseDTO);
		} else if (e instanceof AuthMethodNotSupportedException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.AUTH_METHOD_NOT_SUPPORTED.getStatusCode(), "Authentication failed");
			mapper.writeValue(response.getWriter(), responseDTO);
		} else if (e instanceof AuthenticationServiceException) {
			responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
					CustomStatusCode.Authentication.AUTHENTICATION_CREDENTIALS_NOT_PROVIDED.getStatusCode(),
					"Username or Password not provided");
			mapper.writeValue(response.getWriter(), responseDTO);
		}
		responseDTO = new ResponseDTO(HttpStatus.UNAUTHORIZED,
				CustomStatusCode.Authentication.AUTHENTICATION_FAILED.getStatusCode(), "Authentication failed");
		mapper.writeValue(response.getWriter(), responseDTO);

	}

}
