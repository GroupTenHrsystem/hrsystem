package com.hrsystem.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hrsystem.user.entity.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,JpaSpecificationExecutor<Role>{

}
