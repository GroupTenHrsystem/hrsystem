package com.hrsystem.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.performance.entity.Performance;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.repository.RoleRepository;

@Service
public class RoleService implements RoleIService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findRoleById(Long id) {
		Optional<Role> role = roleRepository.findById(id);
	    if (!role.isPresent()) {
	        return null;
	    }
	    return role.get();
	}

	@Override
	public void insertRole(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idList =new<Long>ArrayList(Arrays.asList(ids));
		List<Role> check =(List<Role>) roleRepository.findAllById(idList);
		roleRepository.deleteAll(check);

	}

	@Override
	public Page<Role> findAll(Specification<Role> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return roleRepository.findAll(spec, pageable);
	}

//	@Override
//	public List<Role> getRoleByRoleTempletId(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
