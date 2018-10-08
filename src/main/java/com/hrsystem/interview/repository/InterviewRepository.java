package com.hrsystem.interview.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.interview.entity.Interview;


@Repository
public interface InterviewRepository extends PagingAndSortingRepository<Interview, Long>,JpaSpecificationExecutor<Interview>{

}
