package com.dev.repository.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.lesson.HealthClassReserv;

public interface HealthClassReservRepository extends JpaRepository<HealthClassReserv, String> {

}
