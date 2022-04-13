package com.dev.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.user.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment, String> {

}
