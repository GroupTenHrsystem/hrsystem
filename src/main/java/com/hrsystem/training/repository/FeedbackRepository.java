package com.hrsystem.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.Feedback;



public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Long>,JpaSpecificationExecutor<Feedback>{
	@Query(value = "select * from t_enroll where audit_status ='报名通过'and employee_id=?1 order by employee_id", nativeQuery = true)	
	public Page<Feedback> findFeedbackByEnroll(Specification<Feedback> spec, Pageable pageable);
}
