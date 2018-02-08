package io.javabarins.sprinbootstarter.security.jwt.model;

/**
 * @author Kusma Singh
 * @time 5:13:08 PM
 * @date 05-Feb-2018
 */
public enum Scopes {
			REFRESH_TOKEN;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
