package com.hrsystem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.user.entity.Role;

public interface RoleIService {

	public Role findRoleById(Long id);
	 
	 public void insertRole(Role role) ;
	 
	 public void deleteRole(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Role> findAll(Specification<Role> spec, Pageable pageable);
	 
//	 public List<Role> getRoleByRoleTempletId(Long id);
}
