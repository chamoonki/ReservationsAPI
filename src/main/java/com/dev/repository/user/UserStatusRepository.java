package com.dev.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.user.UserStatus;

public interface UserStatusRepository extends JpaRepository<UserStatus, String> {

}
