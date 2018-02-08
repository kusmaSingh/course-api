/**
 * 
 */
package io.javabrains.springbootstarter.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;


import io.javabrains.springbootstarter.auth.jwt.JwtAuthenticationProvider;
import io.javabrains.springbootstarter.auth.jwt.JwtTokenAuthenticationProcessingFilter;
import io.javabrains.springbootstarter.auth.jwt.SkipPathRequestMatcher;
import io.javabrains.springbootstarter.auth.jwt.TokenExtractor;
import io.javabrains.springbootstarter.security.auth.ajax.AjaxAuthenticationProvider;
import io.javabrains.springbootstarter.security.auth.ajax.AjaxAwareAuthenticationFailureHandler;
import io.javabrains.springbootstarter.security.auth.ajax.AjaxAwareAuthenticationSuccessHandler;
import io.javabrains.springbootstarter.security.auth.ajax.AjaxLoginProcessingFilter;
import io.javabrains.springbootstarter.security.auth.ajax.RestAuthenticationEntryPoint;

/**
 * @author Kusma
 *
 *         15-Jan-2018
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(WebSecurity.class);
	public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	public static final String FORM_BASED_LOGIN_ENTRY_POINT = "api/auth/login";
	public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
	public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";
	public static final String FORM_BASED_REGISTRATION_ENTRY_POINT = "/api/auth/registration";

	private static final String[] BY_PASS_SECURITY_PERMITALL_URLS = { "/", "/resources/**",
			FORM_BASED_REGISTRATION_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT, TOKEN_REFRESH_ENTRY_POINT };

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private AjaxAuthenticationProvider ajaxAuthenticationProvider;

	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;

	@Autowired
	private TokenExtractor tokenExtractor;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AjaxAwareAuthenticationFailureHandler ajaxAwareAuthenticationFailureHandler;

	@Autowired
	private AjaxAwareAuthenticationSuccessHandler ajaxAwareAuthenticationSuccessHandler;

	

	protected AjaxLoginProcessingFilter buildAjaxLoginProcessingFilter() throws Exception {
		AjaxLoginProcessingFilter filter = new AjaxLoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT,
				ajaxAwareAuthenticationSuccessHandler, ajaxAwareAuthenticationFailureHandler, objectMapper);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception {
		List<String> pathsToSkip = Arrays.asList(FORM_BASED_LOGIN_ENTRY_POINT, TOKEN_REFRESH_ENTRY_POINT);
		SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, TOKEN_BASED_AUTH_ENTRY_POINT);
		JwtTokenAuthenticationProcessingFilter filter = new JwtTokenAuthenticationProcessingFilter(
				ajaxAwareAuthenticationFailureHandler, tokenExtractor, matcher);
		filter.setAuthenticationManager(this.authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(ajaxAuthenticationProvider);
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(BY_PASS_SECURITY_PERMITALL_URLS).permitAll()
				.antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll().and().exceptionHandling()
				.authenticationEntryPoint(this.authenticationEntryPoint)

				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				.and().authorizeRequests().antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected
																										// API
																										// End-points
				.and().addFilterBefore(buildAjaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(),
						UsernamePasswordAuthenticationFilter.class);
	}
	

/*	@Bean
	public HazelcastInstance hazelCast() {
		Config config = new Config();
		config.setInstanceName("course-hazelcast");
		NetworkConfig networkConfig = new NetworkConfig().setPort(5701).setPortAutoIncrement(false);
		networkConfig.setJoin(new JoinConfig().setMulticastConfig(new MulticastConfig().setEnabled(false)));
		config.setNetworkConfig(networkConfig);
		config.addMapConfig(new MapConfig().setName("blacklistToken"));
		return Hazelcast.newHazelcastInstance(config);
		
		 * config.setInstanceName("blacklistToken");
		 * System.out.println("hazel cast ::::::: "+config.getInstanceName());
		 * return Hazelcast.newHazelcastInstance(config);
		 
	}*/

	
}
