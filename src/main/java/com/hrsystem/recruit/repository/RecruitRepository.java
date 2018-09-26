package com.hrsystem.recruit.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.recruit.entity.Recruit;

@Repository
public interface RecruitRepository extends PagingAndSortingRepository<Recruit, Long>,JpaSpecificationExecutor<Recruit>{

}
