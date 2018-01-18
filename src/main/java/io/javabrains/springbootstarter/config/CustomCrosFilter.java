/**
 * 
 */
package io.javabrains.springbootstarter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Kusma
 *
 * 22-Dec-2017
 */
@Configuration
public class CustomCrosFilter {
	private static final Logger logger = LoggerFactory.getLogger(CustomCrosFilter.class);
	@Autowired
	private Environment env;
	@Bean
	public CorsFilter corsFilter() {
		logger.info("app server context : " + env.getProperty("client.app.url"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedOrigin(env.getProperty("client.app.context"));
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		//config.setMaxAge(100L);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}


}
