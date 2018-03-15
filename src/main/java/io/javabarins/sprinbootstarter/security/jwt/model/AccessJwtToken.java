package io.javabarins.sprinbootstarter.security.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.javabrains.springbootstarter.jwt.extracter.JwtToken;
import io.jsonwebtoken.Claims;

/**
 * @author Kusma Singh
 * @time 4:58:37 PM
 * @date 05-Feb-2018
 */
public final class AccessJwtToken implements JwtToken {

	private final String rawToken;
	@JsonIgnore
	private Claims claims;

	public AccessJwtToken(String rawToken, Claims claims) {
		this.rawToken = rawToken;
		this.claims = claims;
		
	}

	
	public String getToken() {
		return this.rawToken;
	}
	
	public Claims getClaims() {
        return claims;
    }
}
