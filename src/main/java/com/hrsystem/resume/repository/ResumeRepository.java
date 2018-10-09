package com.hrsystem.resume.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.resume.entity.Resume;

@Repository
public interface ResumeRepository extends PagingAndSortingRepository<Resume, Long>,JpaSpecificationExecutor<Resume>{

}
