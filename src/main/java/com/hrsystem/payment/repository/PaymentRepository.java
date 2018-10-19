package com.hrsystem.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsystem.payment.entity.Payment;


public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>,JpaSpecificationExecutor<Payment>{

	@Modifying
	@Query(value="UPDATE hrsystem.t_payment SET status = false WHERE id IN ?1 AND process_status != 1",nativeQuery=true) 
	public void updateAll(List<Long> ids);
	
}
