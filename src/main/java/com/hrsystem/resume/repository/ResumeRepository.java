package com.hrsystem.resume.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.resume.entity.Resume;

@Repository
public interface ResumeRepository extends PagingAndSortingRepository<Resume, Long>,JpaSpecificationExecutor<Resume>{

	@Query("from Resume resume where resume.userId = ?1")
	public Page<Resume> findResume(String userId,Pageable pageable);
}
