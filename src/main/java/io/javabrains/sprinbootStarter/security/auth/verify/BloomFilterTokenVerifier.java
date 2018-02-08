package io.javabrains.sprinbootStarter.security.auth.verify;

import org.springframework.stereotype.Component;


/**
 * @author Kusma Singh
 * @time 5:17:00 PM
 * @date 06-Feb-2018
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
	@Override
    public boolean verify(String jti) {
        return true;
    }
}

