package io.javabrains.springbootstarter.security.auth.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.javabarins.sprinbootstarter.security.jwt.model.UserContext;
import io.javabrains.springbootstarter.dto.RoleDTO;
import io.javabrains.springbootstarter.entity.User;
import io.javabrains.springbootstarter.service.UserService;

/**
 * @author Kusma Singh
 * @time 3:29:25 PM
 * @date 05-Feb-2018
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
	
	private final BCryptPasswordEncoder encoder;
	
	private final UserService userService;

	@Autowired
	public AjaxAuthenticationProvider(final UserService userService,final  BCryptPasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.notNull(authentication, "No authentication data provided");
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		User user = userService.findByUsername(username);
		if (user == null || !encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
		}
		List<RoleDTO> roles = userService.findRoleByUserId(user.getId());

		List<GrantedAuthority> authorities = roles.stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());

		UserContext userContext = UserContext.create(user.getUsername(), authorities);

		return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
