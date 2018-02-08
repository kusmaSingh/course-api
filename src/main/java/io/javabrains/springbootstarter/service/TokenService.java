package io.javabrains.springbootstarter.service;



import com.hazelcast.core.IMap;

import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.entity.Token;

/**
 * @author Kusma Singh
 * @time 11:57:13 AM
 * @date 06-Feb-2018
 */
public interface TokenService  extends BaseService <Token, Long>{
	/**
	 * This function is uses for insert token in Token Table.
	 * @param email
	 */
	public ResponseDTO createToken(String email,String contextUrl,String resetUrl);

	/**
	 * This function is using for validates token of user when we sent token to the user email at the time of forgot password.
	 * @param token
	 * @return
	 */
	public ResponseDTO tokenValidate(String token);
	/**
	 * This function is used to verify the black list token.
	 */
	public void tokenVerification();

	/**
	 * Hazelcast map is used for token blacklist
	 * @return
	 */
	public IMap<Object, Object> getImap();
}

