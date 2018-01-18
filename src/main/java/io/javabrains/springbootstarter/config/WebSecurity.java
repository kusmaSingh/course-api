/**
 * 
 */
package io.javabrains.springbootstarter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Kusma
 *
 *         15-Jan-2018
 */
@Configuration
@EnableWebSecurity
/* @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) */
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(WebSecurity.class);
	public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	
	public static final String BY_PASS_URL[] = {"/user/resgistration", "/user/login"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(BY_PASS_URL).permitAll().and().logout().permitAll();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		logger.info("PasswordEncoder bean successfully initiated ");
		return new BCryptPasswordEncoder();
	}
}
