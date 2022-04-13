package com.dev.repository.center;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.center.CenterPayment;

public interface CenterPaymentRepository extends JpaRepository<CenterPayment, String> {

}
