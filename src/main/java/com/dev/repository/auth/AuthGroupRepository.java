package com.dev.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.auth.AuthGroup;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, String> {

}
