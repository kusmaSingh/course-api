package io.javabarins.sprinbootstarter.security.jwt.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.javabrains.springbootstarter.config.JwtSetting;
import io.javabrains.springbootstarter.jwt.extracter.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Kusma Singh
 * @time 4:50:13 PM
 * @date 05-Feb-2018
 */
@Component
public class JwtTokenFactory {
	private final JwtSetting settings;

	@Autowired
	public JwtTokenFactory(JwtSetting settings) {
		this.settings = settings;
	}

	/**
	 * Factory method for issuing new JWT Tokens.
	 * 
	 * @param username
	 * @param roles
	 * @return
	 */
	public AccessJwtToken createAccessJwtToken(UserContext userContext) {
		if (StringUtils.isBlank(userContext.getUsername()))
			throw new IllegalArgumentException("Cannot create JWT Token without username");

		if (userContext.getAuthorities() == null || userContext.getAuthorities().isEmpty())
			throw new IllegalArgumentException("User doesn't have any privileges");

		Claims claims = Jwts.claims().setSubject(userContext.getUsername());
		claims.put("scopes", userContext.getAuthorities().stream().map(s -> s.toString()).collect(Collectors.toList()));

		LocalDateTime currentTime = LocalDateTime.now();

		String token = Jwts.builder().setClaims(claims).setIssuer(settings.getTokenIssuer())
				.setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
				.setExpiration(Date.from(currentTime.plusMinutes(settings.getTokenExpirationTime())
						.atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey()).compact();

		return new AccessJwtToken(token, claims);
	}

	public JwtToken createRefreshToken(UserContext userContext) {
		if (StringUtils.isBlank(userContext.getUsername())) {
			throw new IllegalArgumentException("Cannot create JWT Token without username");
		}

		LocalDateTime currentTime = LocalDateTime.now();

		Claims claims = Jwts.claims().setSubject(userContext.getUsername());
		claims.put("scopes", Arrays.asList(Scopes.REFRESH_TOKEN.authority()));

		String token = Jwts.builder().setClaims(claims).setIssuer(settings.getTokenIssuer())
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
				.setExpiration(Date.from(currentTime.plusMinutes(settings.getRefreshTokenExpTime())
						.atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey()).compact();

		return new AccessJwtToken(token, claims);
	}
}
