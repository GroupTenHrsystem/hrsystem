package com.hrsystem.training.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsystem.training.domain.Feedback;



public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Long>,JpaSpecificationExecutor<Feedback>{

}
