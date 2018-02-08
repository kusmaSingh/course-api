	package io.javabrains.springbootstarter.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.IMap;

import io.javabrains.springbootstarter.dto.ResponseDTO;
import io.javabrains.springbootstarter.entity.Token;
import io.javabrains.springbootstarter.repository.TokenRepository;
import io.javabrains.springbootstarter.service.TokenService;
import io.javabrains.springbootstarter.service.UserService;


/**
 * @author Kusma Singh
 * @time 1:29:49 PM
 * @date 06-Feb-2018
 */
@Service("tokenService")
public class TokenServiceImpl extends BaseServiceImpl<Token, Long> implements TokenService {
	public static final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class.getName());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenRepository tokenRepository;
	

	/*@Autowired
	private HazelcastInstance hazelcastInstance;*/
	
	
	/*public IMap<Object, Object> getImap() {
=======
/*	@Autowired
	private HazelcastInstance hazelcastInstance;
	*/
	
	public IMap<Object, Object> getImap() {
		//return hazelcastInstance.getMap("blacklistToken");

		return null;
	}


	@Override
	public ResponseDTO createToken(String email, String contextUrl, String resetUrl) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseDTO tokenValidate(String token) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void tokenVerification() {
		// TODO Auto-generated method stub
		
	}


	
}

