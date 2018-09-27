package com.hrsystem.training.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.training.domain.Training;



@Repository
public interface TrainingRepository extends PagingAndSortingRepository<Training, Long>,JpaSpecificationExecutor<Training>{

}
