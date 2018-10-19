package com.hrsystem.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsystem.training.domain.Training;



@Repository
public interface TrainingRepository extends PagingAndSortingRepository<Training, Long>,JpaSpecificationExecutor<Training>{
	@Query(value = "select * from t_training where course_audit_status ='审核通过'", nativeQuery = true)	
	public Page<Training> findTrainingByArstatusPass(Specification<Training> spec, Pageable pageable);
}
