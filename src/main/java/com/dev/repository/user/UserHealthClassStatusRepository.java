package com.dev.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.user.UserHealthClassStatus;

public interface UserHealthClassStatusRepository extends JpaRepository<UserHealthClassStatus, String> {

}
