package com.hrsystem.resume.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.activiti.domain.ProcessStatus;
import com.hrsystem.activiti.domain.WorkflowDTO;
import com.hrsystem.activiti.service.IWorkflowService;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.entity.ResumeDTO;
import com.hrsystem.resume.entity.ResumeIntoStaffDTO;
import com.hrsystem.resume.repository.ResumeRepository;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.StaffRepository;

@Service
@Transactional
public class ResumeService implements IResumeService{
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private IWorkflowService workflowService;


	@Override
	public Optional<Resume> findById(Long id) {
		Optional<Resume> resume = resumeRepository.findById(id);
		if(!resume.isPresent()) {
			return null;
		}
		return resumeRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		resumeRepository.deleteById(id);
	}

	@Override
	public void deleteAll(Long[] ids) {
		resumeRepository.deleteAll();
	}

	@Override
	public Page<Resume> findAll(Specification<Resume> spec, Pageable pageable) {
		return resumeRepository.findAll(spec, pageable);
	}

	@Override
	public void save(Resume resume) {
		resumeRepository.save(resume);
	}

	@Override
	@Transactional(readOnly=true)
	public Resume findOne(Long id) {
		return resumeRepository.findById(id).get();
	}
	
	/*----------------------------------------------流程业务--------------------------------------------*/
	/**
	 * 开始请假流程
	 *
	 * @param userId 用户ID
	 * @param pageable 分页条件
	 * @return
	 */
	@Override
	public void startWorkflow(String userId, Long resumeId, Map<String, Object> variables) {
		//1.声明流程实例
		ProcessInstance processInstance = null;
		//2.获取创建好的请假实例
		Resume resume = resumeRepository.findById(resumeId).get();
		if(resume!=null){
			try {
				processInstance = workflowService.startWorkflow(userId, "resume", resume.getId().toString(), variables);
				resume.setProcessStatus(ProcessStatus.APPROVAL);
				resume.setProcessInstanceId(processInstance.getId());
				resume.setApplyTime(new Date());
				resumeRepository.save(resume);
				//System.out.println(variables.get("hrClerk"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询待办任务
	 *
	 * @param userId 用户ID
	 * @param pageable 分页条件
	 * @return
	 */
	@Override
	public Page<ResumeDTO> findTodoTasks(String userId, Pageable pageable) {
		List<ResumeDTO> results = null;
		List<WorkflowDTO> workflowLists = workflowService.findTodoTasks(userId);
		// 根据流程的业务ID查询实体并关联
		if(null!=workflowLists) {
			results = new ArrayList<ResumeDTO>();
			for (WorkflowDTO workflow : workflowLists) {
				Long businessKey = new Long(workflow.getBusinessKey());
				if (workflow.getBusinessKey() == null) {
					continue;
				}
				Resume resume = resumeRepository.findById(businessKey).get();
				if(resume!=null){
					ResumeDTO resumeDTO = new ResumeDTO();
					BeanUtils.copyProperties(resume, resumeDTO);
					BeanUtils.copyProperties(workflow, resumeDTO);
					results.add(resumeDTO);
				}
			}
		}
		return new PageImpl<ResumeDTO> (results, pageable, null!=results?results.size():0);
	}

	/**
    * 签收流程任务
    *
    * @param taskId 任务ID
    * @param userId 签收人用户ID
    * @return
    */
	@Override
	public void claim(String taskId, String userId) {
		workflowService.claim(taskId, userId);
	}

	 /**
    * 完成流程任务
    *
    * @param taskId 任务ID
    * @param variables 流程变量
    * @return
    */
	@SuppressWarnings("deprecation")
	@Override
	public void complete(String taskId, Map<String, Object> variables, Long id) {
		Resume resume = resumeRepository.findById(id).get();
		if(variables.containsKey("firstAuditScore")) {
			resume.setFirstAuditScore(Double.parseDouble(String.valueOf(variables.get("firstAuditScore"))));
			resume.setFirstBackReason(String.valueOf(variables.get("firstBackReason")));
			if(variables.get("firstPass").equals(true)) {
				resume.setProcessStatus(ProcessStatus.FIRSTPASS);
			}else {
				resume.setProcessStatus(ProcessStatus.FIRSTAIL);
				resume.setCompleteTime(new Date());
			}
		}else if(variables.containsKey("penScore")){
			resume.setPenScore(Double.parseDouble(String.valueOf(variables.get("penScore"))));
			if(!variables.get("deptLeaderPass").equals(true)) {
				resume.setProcessStatus(ProcessStatus.PENFAIL);
				resume.setCompleteTime(new Date());
			}
		}else if(variables.containsKey("lastAuditScore")) {
			resume.setLastAuditScore(Double.parseDouble(String.valueOf(variables.get("lastAuditScore"))));
			resume.setLastBackReason(String.valueOf(variables.get("lastBackReason")));
			if(variables.get("lastPass").equals(true)) {
				resume.setProcessStatus(ProcessStatus.COMPLETE);
			}else {
				resume.setProcessStatus(ProcessStatus.LASTFAIL);
			}
			resume.setCompleteTime(new Date());
		}else if(variables.containsKey("firstarr")) {
			resume.setFirstarr(String.valueOf(variables.get("firstarr")));
			resume.setProcessStatus(ProcessStatus.FIRSTARRANGE);
			//System.out.println("123"+variables.get("firstTime"));
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date date = sdf.format(String.valueOf(variables.get("firstTime")));
			//resume.setFirstTime(date);
		}
		if(variables.containsKey("lastarr")) {
			resume.setLastarr(String.valueOf(variables.get("lastarr")));
			resume.setProcessStatus(ProcessStatus.LASTARRANGE);
			//SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//resume.setLastTime(f.parse(String.valueOf(variables.get("lastTime"))));
		}
		resumeRepository.save(resume);
		
		workflowService.complete(taskId, variables);
	}	

	@Override
	public Page<Resume> findResume(String userId, Pageable pageable) {
		return resumeRepository.findResume(userId, pageable);
	}

	@Override
	public void saveIntoUser(ResumeIntoStaffDTO resumeIntoStaffDTO) {
		Resume resume = resumeRepository.findById(resumeIntoStaffDTO.getId()).get();
		resume.setProcessStatus(ProcessStatus.ONFILE);
		Staff staff = new Staff();
		//Department department
		staff.setStaffName(resume.getName());
		staff.setPassword(resume.getName());
		staff.setEmail(resume.getEmail());
		staff.setNativePlace(resume.getNativePlace());
		staff.setStatus("实习");
		staff.setEmploymentDate(resumeIntoStaffDTO.getEmploymentDate());
		resume.setProcessStatus(ProcessStatus.ONFILE);
		staffRepository.save(staff);
		resumeRepository.save(resume);
		System.out.println("125");
	}

	@Override
	public Page<Resume> findAll(String processStatus, Specification<Resume> spec, Pageable pageable) {
		return resumeRepository.findAll(processStatus, spec, pageable);
	}

	@Override
	public long count(String major) {
		return resumeRepository.count(major);
	}


		
}
