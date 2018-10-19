package com.hrsystem.resume.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsystem.resume.entity.ResumeDTO;
import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.resume.entity.Resume;

public interface IResumeService {

	public void save(Resume resume);
	public Resume findOne(Long id);
	public Optional<Resume> findById(Long id);
	public void deleteById(Long id);
	public void deleteAll(Long[] ids);
	
	public void saveIntoUser(Resume resume);
	
	public Page<Resume> findAll(Specification<Resume> spec,Pageable pageable);
	public Page<Resume> findAll(String processStatus ,Pageable pageable);
	public Page<Resume> findResume(String userId,Pageable pageable);
	
	//流程业务
	//1.启动流程
	public void startWorkflow(String userId,Long resumeId, Map<String, Object> variables);//findOne(Long id);
	//2.查询流程任务
	public Page<ResumeDTO> findTodoTasks(String userId, Pageable pageable);
	//3.签收流程任务
	public void claim(String taskId,String userId);
	//4.完成流程任务
	public void complete(String taskId, Map<String, Object> variable,Long id); 	
}
