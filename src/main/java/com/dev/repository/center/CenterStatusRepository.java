package com.dev.repository.center;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.center.CenterStatus;

public interface CenterStatusRepository extends JpaRepository<CenterStatus, String> {

}
