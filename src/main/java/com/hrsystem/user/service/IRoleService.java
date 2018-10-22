package com.hrsystem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.entity.DTO.RoleDTO;

public interface IRoleService {

	public Role findRoleById(Long id);
	 
	 public void insertRole(Role role) ;
	 
	 public void deleteRole(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<Role> findAll(Specification<Role> spec, Pageable pageable);
	 
	 public List<Long> findByPosition(String position);
	 
//	 public List<Role> getRoleByRoleTempletId(Long id);
//	 public List<Staff> findStaffByRole(Long positionId);
}
