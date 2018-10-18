package com.hrsystem.payment.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsystem.payment.entity.Payment;


public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>,JpaSpecificationExecutor<Payment>{

}
