package io.javabrains.springbootstarter.repository;

import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.entity.Token;

/**
 * @author Kusma Singh
 * @time 1:46:14 PM
 * @date 06-Feb-2018
 */
@Repository("tokenRepository")
public interface TokenRepository extends BaseRepository<Token, Long>  {

}

