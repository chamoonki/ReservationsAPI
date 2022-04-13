package com.dev.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.model.auth.Oauth;

public interface OauthRepository extends JpaRepository<Oauth, String> {

	@Query("select o from Oauth o where o.access_token = ?1")
	Oauth findByToken(String token);
}
