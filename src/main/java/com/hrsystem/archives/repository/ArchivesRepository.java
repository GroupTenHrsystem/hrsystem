package com.hrsystem.archives.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.archives.domain.Archives;



@Repository
public interface ArchivesRepository extends PagingAndSortingRepository<Archives, Long>,JpaSpecificationExecutor<Archives>{

}
