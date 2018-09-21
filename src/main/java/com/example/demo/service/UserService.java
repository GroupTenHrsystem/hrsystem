package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    
    public Optional<User> findUserById(Long id) {
    	return  userRepository.findById(id);
    }
    
    public void insertUser(User user) {
        userRepository.save(user);     
    }    
   
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    public Page<User> findAll(Specification<User> spec, Pageable pageable) {		
		return userRepository.findAll(spec, pageable);
	}
    
	@Override
	public void deleteAll(Long[] ids) {
		List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));
		
		List<User> users = (List<User>) userRepository.findAllById(idLists);
			userRepository.deleteAll(users);
		}
	
}
