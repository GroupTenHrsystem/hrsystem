package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.entity.User;

public interface IUserService {

	 public Optional<User> findUserById(Long id);
	 
	 public void insertUser(User user) ;
	 
	 public void deleteUser(Long id) ;
	 
	 public void deleteAll(Long[] ids);
	 
	 public Page<User> findAll(Specification<User> spec, Pageable pageable);
}
