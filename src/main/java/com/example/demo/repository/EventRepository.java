package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.calendar.*;;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>,JpaSpecificationExecutor<Event>{

}
