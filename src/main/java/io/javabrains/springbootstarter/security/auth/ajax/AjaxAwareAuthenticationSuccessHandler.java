package io.javabrains.springbootstarter.security.auth.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javabarins.sprinbootstarter.security.jwt.model.JwtTokenFactory;
import io.javabarins.sprinbootstarter.security.jwt.model.UserContext;
import io.javabrains.springbootstarter.jwt.extracter.JwtToken;

/**
 * @author Kusma Singh
 * @time 4:24:57 PM
 * @date 05-Feb-2018
 */

/*
 * AjaxAwareAuthenticationSuccessHandler class is our custom implementation of
 * AuthenticationSuccessHandler interface. Responsibility of this class is to
 * add JSON payload containing JWT Access and Refresh tokens into the HTTP
 * response body.
 */
@Component
public class AjaxAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private final ObjectMapper mapper;
	private final JwtTokenFactory jwtTokenFactory;

	@Autowired
	public AjaxAwareAuthenticationSuccessHandler(final ObjectMapper mapper, final JwtTokenFactory tokenFactory) {
		super();
		this.mapper = mapper;
		this.jwtTokenFactory = tokenFactory;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserContext userContext = (UserContext) authentication.getPrincipal();

		JwtToken accessToken = jwtTokenFactory.createAccessJwtToken(userContext);
		JwtToken refreshToken = jwtTokenFactory.createRefreshToken(userContext);

		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("token", accessToken.getToken());
		tokenMap.put("refreshToken", refreshToken.getToken());

		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		mapper.writeValue(response.getWriter(), tokenMap);

		clearAuthenticationAttributes(request);
	}

}