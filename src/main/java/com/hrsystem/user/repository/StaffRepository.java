package com.hrsystem.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Staff;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff, Long>,JpaSpecificationExecutor<Staff>{

}
