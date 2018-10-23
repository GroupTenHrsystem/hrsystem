package com.hrsystem.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsystem.training.domain.Enroll;




public interface EnrollRepository extends PagingAndSortingRepository<Enroll, Long>,JpaSpecificationExecutor<Enroll>{
	@Query(value = "select * from t_enroll where audit_status ='报名通过'", nativeQuery = true)	
	public Page<Enroll> findEnrollByArstatusPass(Specification<Enroll> spec, Pageable pageable);
	@Query(value = "select * from t_enroll where audit_status ='报名通过' and course_id=?1 order by course_id", nativeQuery = true)	
	public Page<Enroll> findEnrollByArstatusEmployeeId(Long courseId,Specification<Enroll> spec, Pageable pageable);
}
