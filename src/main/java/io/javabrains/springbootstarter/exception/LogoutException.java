package io.javabrains.springbootstarter.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Kusma Singh
 * @time 10:36:08 AM
 * @date 06-Feb-2018
 */
public class LogoutException extends AuthenticationException {

	private static final long serialVersionUID = 1790064226549670771L;

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message.
	 *
	 * @param msg
	 *            the detail message
	 */
	public LogoutException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message
	 * and root cause.
	 *
	 * @param msg
	 *            the detail message
	 * @param t
	 *            root cause
	 */
	public LogoutException(String msg, Throwable t) {
		super(msg, t);
	}
}
