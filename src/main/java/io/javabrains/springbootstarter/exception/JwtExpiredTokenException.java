package io.javabrains.springbootstarter.exception;

import org.springframework.security.core.AuthenticationException;

import io.javabrains.springbootstarter.jwt.extracter.JwtToken;


/**
 * @author Kusma Singh
 * @time 6:22:44 PM
 * @date 05-Feb-2018
 */
public class JwtExpiredTokenException extends AuthenticationException  {
	
	  private static final long serialVersionUID = -5959543783324224864L;
	    
	    private JwtToken token;

	    public JwtExpiredTokenException(String msg) {
	        super(msg);
	    }

	    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
	        super(msg, t);
	        this.token = token;
	    }

	    public String token() {
	        return this.token.getToken();
	    }
}

