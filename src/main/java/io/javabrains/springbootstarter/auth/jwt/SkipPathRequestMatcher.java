package io.javabrains.springbootstarter.auth.jwt;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

/**
 * @author Kusma Singh
 * @time 12:36:38 PM
 * @date 06-Feb-2018
 */
/*
 * This class is to skip following endpoints: /api/auth/login and
 * /api/auth/token.
 */
public class SkipPathRequestMatcher implements RequestMatcher {
	private OrRequestMatcher matchers;
	private RequestMatcher processingMatcher;

	public SkipPathRequestMatcher(List<String> pathsToSkip, String processingPath) {
		Assert.notNull(pathsToSkip, "Skip path cannot be null");
		List<RequestMatcher> m = pathsToSkip.stream().map(path -> new AntPathRequestMatcher(path))
				.collect(Collectors.toList());
		matchers = new OrRequestMatcher(m);
		processingMatcher = new AntPathRequestMatcher(processingPath);
	}

	@Override
	public boolean matches(HttpServletRequest request) {
		if (matchers.matches(request)) {
			return false;
		}
		return processingMatcher.matches(request) ? true : false;
	}

}
