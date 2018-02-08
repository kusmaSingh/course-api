package io.javabarins.sprinbootstarter.security.jwt.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;


/**
 * @author Kusma Singh
 * @time 4:14:38 PM
 * @date 05-Feb-2018
 */
/**
 * @author Kusma Singh
 *
 * @date 05-Feb-2018
 */
public class UserContext implements Serializable {
	private static final long serialVersionUID = -3127884832567690866L;
	private final String username;
    private final List<GrantedAuthority> authorities;
    
    private UserContext(String username, List<GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
    
    
    public static UserContext create(String username, List<GrantedAuthority> authorities) {
        if (StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank: " + username);
        return new UserContext(username, authorities);
    }
    public String getUsername() {
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

