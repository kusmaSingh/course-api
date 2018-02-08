package io.javabrains.springbootstarter.auth.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.javabarins.sprinbootstarter.security.jwt.model.RawAccessJwtToken;
import io.javabarins.sprinbootstarter.security.jwt.model.UserContext;
import io.javabrains.springbootstarter.config.JwtSetting;
import io.javabrains.springbootstarter.exception.LogoutException;
import io.javabrains.springbootstarter.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * @author Kusma Singh
 * @time 11:47:20 AM
 * @date 06-Feb-2018
 */
/*
 * Verify the access token's signature & Extract identity and authorization claims
 * from Access token and use them to create UserContext
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

	private final JwtSetting jwtSettings;

	/*
	 * @Autowired private TokenService tokenService;
	 */
	@Autowired
	public JwtAuthenticationProvider(JwtSetting jwtSettings) {
		this.jwtSettings = jwtSettings;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();

		Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
		String subject = jwsClaims.getBody().getSubject();
		List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
		List<GrantedAuthority> authorities = scopes.stream().map(authority -> new SimpleGrantedAuthority(authority))
				.collect(Collectors.toList());

		UserContext context = UserContext.create(subject, authorities);

		return new JwtAuthenticationToken(context, context.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
