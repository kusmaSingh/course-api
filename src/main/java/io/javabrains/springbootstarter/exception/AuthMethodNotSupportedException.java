package io.javabrains.springbootstarter.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @author Kusma Singh
 * @time 6:21:45 PM
 * @date 05-Feb-2018
 */
public class AuthMethodNotSupportedException  extends AuthenticationServiceException{
	private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}

