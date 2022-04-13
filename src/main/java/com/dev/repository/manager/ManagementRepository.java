package com.dev.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.manager.Management;

public interface ManagementRepository extends JpaRepository<Management, String> {

}
