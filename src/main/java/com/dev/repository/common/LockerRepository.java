package com.dev.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.common.Locker;

public interface LockerRepository extends JpaRepository<Locker, String> {

}
