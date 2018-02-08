package io.javabrains.springbootstarter.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Kusma Singh
 * @time 10:34:41 AM
 * @date 06-Feb-2018
 */
public class InvalidJwtTokenException extends AuthenticationException {

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message.
	 *
	 * @param msg
	 *            the detail message
	 */
	public InvalidJwtTokenException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message and
	 * root cause.
	 *
	 * @param msg
	 *            the detail message
	 * @param t
	 *            root cause
	 */
	public InvalidJwtTokenException(String msg, Throwable t) {
		super(msg, t);
	}

}

