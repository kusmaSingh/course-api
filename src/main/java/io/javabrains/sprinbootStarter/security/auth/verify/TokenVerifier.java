package io.javabrains.sprinbootStarter.security.auth.verify;

/**
 * @author Kusma Singh
 * @time 5:17:51 PM
 * @date 06-Feb-2018
 */
public interface TokenVerifier {
	public boolean verify(String jti);

}

