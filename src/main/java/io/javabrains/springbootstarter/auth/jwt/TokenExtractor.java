package io.javabrains.springbootstarter.auth.jwt;

/**
 * @author Kusma Singh
 * @time 11:00:37 AM
 * @date 06-Feb-2018
 */
public interface TokenExtractor {
	 public String extract(String payload);
}

