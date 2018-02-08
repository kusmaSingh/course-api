package io.javabrains.springbootstarter.security.auth.ajax;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Model intended to be used for AJAX based authentication.
 * 
 * @author Kusma Singh
 * @Date 06/02/2018
 */

public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 1596882929179226170L;
	private String username;
	private String password;
	
	@JsonCreator
    public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
