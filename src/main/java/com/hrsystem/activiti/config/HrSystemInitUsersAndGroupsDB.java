package com.hrsystem.activiti.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hrsystem.interview.entity.Interview;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.service.IPerformanceTempletService;
import com.hrsystem.recruit.entity.Recruit;
import com.hrsystem.recruit.service.IRecruitService;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.service.IResumeService;
import com.hrsystem.salary.entity.Salary;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.salary.service.ISalaryService;
import com.hrsystem.salary.service.ISalaryStandardService;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.service.IDepartmentService;
import com.hrsystem.user.service.IRoleService;
import com.hrsystem.user.service.IStaffService;
/**
*@项目名称: hrsystem
*@作者: 
*@文件名称: HrSystemInitUsersAndGroupsDB.java
  *@Date: 2018年10月09日
*@Copyright: 2018 https://github.com/ Inc. All rights reserved. 
*/
//@Component
public class HrSystemInitUsersAndGroupsDB {
		@Autowired
		private IStaffService staffService;
		@Autowired
		private ISalaryService salaryService;
		@Autowired
		private IPerformanceTempletService performanceTempletService;	
		@Autowired
		private IResumeService resumeService;
		@Autowired
		private IRecruitService recruitService;
		@Autowired 
		private IDepartmentService departmentService;
		@Autowired 
		private ISalaryStandardService salaryStandardService;
		@Autowired
		private IRoleService roleService;
		 @Bean
		    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
		        return new InitializingBean() {
		            public void afterPropertiesSet() throws Exception {
		            	
		            	Date now = new Date();
		    			LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    			Date newDate=java.sql.Date.valueOf(localDate);
		            	
		    			Calendar rightNow = Calendar.getInstance();
		    	        rightNow.setTime(newDate);		    	 
		    	        rightNow.add(Calendar.MONTH,3);//日期加3个月
		    	        rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
		    	        Date newDateEnd=rightNow.getTime();
		    	        
		    	        Calendar rightNow1 = Calendar.getInstance();
		    	        rightNow1.setTime(newDate);
		    	        rightNow1.add(Calendar.MONTH,1);//日期加1个月
		    	        Date DateEnd=rightNow1.getTime();
		    	        
		        		Group group =identityService.newGroup("admin"); // 实例化组实体
		        		Role role = new Role();
		        		role.setPosition("admin");
		        		group.setType("security-role");
		        		group.setName("管理员");
		        		
		        		Group group2 =identityService.newGroup("generalManager"); // 实例化组实体
		        		Role role2 = new Role();
		        		role2.setPosition("generalManager");
		        		group2.setName("总经理");
		        		
		        		Group group3 =identityService.newGroup("secretary"); // 实例化组实体
		        		Role role3 = new Role();
		        		role3.setPosition("secretary");
		        		role3.setRole(role2); //领导是generalManager
		        		group3.setName("总经理秘书");

		        		Group group4 =identityService.newGroup("hrManager"); // 实例化组实体
		        		Role role4 = new Role();
		        		role4.setPosition("hrManager");
		        		role4.setRole(role2);//领导是generalManager
		        		group4.setName("人事经理");
		        		
		        		Group group5 =identityService.newGroup("hrClerk"); // 实例化组实体
		        		Role role5 = new Role();
		        		role5.setPosition("hrClerk");
		        		role5.setRole(role4);//领导是hrManager
		        		group5.setName("人事文员");

		        		Group group6 =identityService.newGroup("marketingManager"); // 实例化组实体
		        		Role role6 = new Role();
		        		role6.setPosition("marketingManager");
		        		role6.setRole(role2);//领导是generalManager
		        		group6.setName("市场经理");
		        		
		        		Group group7 =identityService.newGroup("marketingClerk"); // 实例化组实体
		        		Role role7 = new Role();
		        		role7.setPosition("marketingClerk");
		        		role7.setRole(role6);//领导是marketingManager
		        		group7.setName("市场文员");

		        		Group group8 =identityService.newGroup("financeManager"); // 实例化组实体
		        		Role role8 = new Role();
		        		role8.setPosition("financeManager");
		        		role8.setRole(role2);//领导是marketingManage
		        		group8.setName("财务经理");
		        		
		        		Group group9 =identityService.newGroup("financeClerk"); // 实例化组实体
		        		Role role9 = new Role();
		        		role9.setPosition("financeClerk");
		        		role9.setRole(role8);//领导是financeManager
		        		group9.setName("财务文员");

		        		identityService.saveGroup(group);
		        		identityService.saveGroup(group2);
		        		identityService.saveGroup(group3);
		        		identityService.saveGroup(group4);
		        		identityService.saveGroup(group5);
		        		identityService.saveGroup(group6);
		        		identityService.saveGroup(group7);
		        		identityService.saveGroup(group8);
		        		identityService.saveGroup(group9);
		        		
		        		roleService.insertRole(role);
		        		roleService.insertRole(role2);
		        		roleService.insertRole(role3);
		        		roleService.insertRole(role4);
		        		roleService.insertRole(role5);
		        		roleService.insertRole(role6);
		        		roleService.insertRole(role7);
		        		roleService.insertRole(role8);
		        		roleService.insertRole(role9);
		        		
		        		//创建部门，建立部门与部门的关联
		        		Department department0 = new Department();
		    			department0.setDepartmentName("总部");
		    			
		        		Department department1 = new Department();
		    			department1.setDepartmentName("财务部");
		    			
		    			
		    			Department department2 = new Department();
		    			department2.setDepartmentName("java开发部");
		    			
		    			
		    			Department department3 = new Department();
		    			department3.setDepartmentName("算法研发部");
		    			department3.setSuperId(department2);
		    			
		    			
		    			Department department4 = new Department();
		    			department4.setDepartmentName("测试部");
		    			department4.setSuperId(department2);
		    			
		    			department0.getChildren().add(department1);
		    			department2.getChildren().add(department3);
		    			department2.getChildren().add(department4);
		    			department0.getChildren().add(department2);
		    			
		    			departmentService.insertDepartment(department0);
		    			departmentService.insertDepartment(department1);
		    			departmentService.insertDepartment(department2);
		    			departmentService.insertDepartment(department3);
		    			departmentService.insertDepartment(department4);
		    			
		    			//插入工资模板
		        		 for (int i = 1; i <=8; i++) {
		        			 	SalaryStandard salaryStandard = new SalaryStandard();
		        			 	salaryStandard.setName("薪资标准"+i);
		        			 	salaryStandard.setBasis(3000D*i);			//基本工资
		        			 	salaryStandard.setCreateTime(newDate);		//创建时间
		        			 	salaryStandard.setSubsidy(300D);			//补贴
		        			 	salaryStandard.setOvertime(50D);			//加班费
		        			 	salaryStandard.setPensionBenefits(0.08);		//养老保险比例
		        			 	salaryStandard.setMedicareBenefits(0.02);			//医疗保险比例
		        			 	salaryStandard.setUnemploymentBenefits(0.01);		//失业保险比例
		        			 	salaryStandard.setInjuryBenefits(0.0);			//工伤保险比例
		        			 	salaryStandard.setMaternityBenefits(0.0);			//生育保险比例
		        			 	salaryStandard.setHouseFund(0.07);					//住房公积金比例
		        			 	salaryStandard.setKpi(i*10D); 						//kpi
		        			 	salaryStandardService.insertSalaryStandard(salaryStandard);
			        	}
		        		 
		    			//插入用户
		        		User admin = identityService.newUser("admin");
		        		Staff adminStaff = new Staff();
		        		adminStaff.setStaffName("admin");
		        		adminStaff.setRole(role);
		        		staffService.insertStaff(adminStaff);
		        		admin.setPassword("admin");
		                identityService.saveUser(admin);
		              
		                for (int i = 1; i <=4; i++) {
		                	 User user = identityService.newUser("user"+i);
		                	 user.setPassword("user"+i);
		                	 Staff staff = new Staff();
		                	 staff.setStaffName("user"+i);
		                	 staff.setDepartment(department1);
		                	 if(i == 1)
		                		 staff.setRole(role2);
		                	 else
		                		 staff.setRole(role3);
		                	 staffService.insertStaff(staff);
		                     identityService.saveUser(user);

		        		}
		                for (int i = 5; i <=10; i++) {
		                	 User user = identityService.newUser("user"+i);
		                	 user.setPassword("user"+i);
		                	 Staff staff = new Staff();
		                	 staff.setStaffName("user"+i);
		                	 staff.setDepartment(department2);
		                	 if(i == 5)
		                		 staff.setRole(role4);
		                	 else
		                		 staff.setRole(role5);
		                	 staffService.insertStaff(staff);
		                     identityService.saveUser(user);

		        		}
		                for (int i = 11; i <=13; i++) {
		                	 User user = identityService.newUser("user"+i);
		                	 user.setPassword("user"+i);
		                	 Staff staff = new Staff();
		                	 staff.setStaffName("user"+i);
		                	 staff.setDepartment(department3);
		                	 if(i == 11)
		                		 staff.setRole(role6);
		                	 else
		                		 staff.setRole(role7);
		                	 staffService.insertStaff(staff);
		                     identityService.saveUser(user);
		                     

		        		}
		                for (int i = 14; i <=16; i++) {
		                	 User user = identityService.newUser("user"+i);
		                	 user.setPassword("user"+i);
		                	 Staff staff = new Staff();
		                	 staff.setStaffName("user"+i);
		                	 staff.setDepartment(department4);
		                	 if(i == 14)
		                		 staff.setRole(role8);
		                	 else
		                		 staff.setRole(role8);
		                	 staffService.insertStaff(staff);
		                     identityService.saveUser(user);

		        		}
		        		identityService.createMembership("admin", "admin");
		        		identityService.createMembership("user1", "generalManager");
		        		identityService.createMembership("user2", "secretary");
		        		identityService.createMembership("user3", "secretary");
		        		identityService.createMembership("user4", "secretary");
		        		
		        		identityService.createMembership("user5", "hrManager");
		        		identityService.createMembership("user6", "hrClerk");
		        		identityService.createMembership("user7", "hrClerk");
		        		identityService.createMembership("user8", "hrClerk");
		        		identityService.createMembership("user9", "hrClerk");
		        		identityService.createMembership("user10", "hrClerk");

		        		identityService.createMembership("user11", "marketingManager");
		        		identityService.createMembership("user12", "marketingClerk");
		        		identityService.createMembership("user13", "marketingClerk");
		        		
		        		identityService.createMembership("user14", "financeManager");
		        		identityService.createMembership("user15", "financeClerk");
		        		identityService.createMembership("user16", "financeClerk");
		        		
//		        		//插入工资
//		        		 for (int i = 1; i <=16; i++) {
//		        			 Salary salary = new Salary();
//		        			 salary.setSalarySum(i*20.0);
//		        			 salary.setSalaryStarTime(newDate);
//		        			 salary.setSalaryEndTime(DateEnd);
//		        			 salary.setCreateTime(newDate);
//		        			 salaryService.insertSalary(salary);
//		        		}
		        		 
		        		 //插入绩效模板
		        		 for (int i = 1; i <=8; i++) {
			        			PerformanceTemplet performanceTemplet = new PerformanceTemplet();
			        			performanceTemplet.setStartTime(newDate);
			        			performanceTemplet.setEndTime(newDateEnd);
			        			performanceTemplet.setKind("种类");
			        			performanceTemplet.setName("考核模板"+i);
			        			performanceTemplet.setPerformanceIndex("工作量");
			        			performanceTemplet.setSelfWeighting(0.3);
			        			performanceTemplet.setDeptLeaderWeighting(0.7);
			        			performanceTemplet.setStatus(true);
			        			performanceTempletService.insertPerformanceTemplet(performanceTemplet);
			        	}
		        	
		        		 
		        		//招聘模块
		     			Resume resume = new Resume();
		    			resume.setName("miette");
		    			resume.setSex("女");
		    			resume.setEmail("819934639@qq.com");
		    			resume.setNativePlace("茂名");
		    			resume.setGraduateSchool("东莞理工");
		    			resume.setEmployBranch("技术部");
		    			resume.setExperience("2年");
		    			resume.setReferer("Jony jk");
		    			resumeService.save(resume);
		     			
		     			Resume resume2 = new Resume();
		    			resume2.setName("Avichk");
		    			resume2.setSex("男");
		    			resume2.setEmail("15651869456@163.com");
		    			resume2.setNativePlace("东莞");
		    			resume2.setGraduateSchool("华南理工");
		    			resume2.setEmployBranch("宣传部");
		    			resume2.setExperience("1年的ps工作");
		    			resumeService.save(resume2);
		    			
		    			//招聘信息
		    			Recruit recruit = new Recruit();
		    			recruit.setDepartmentname("人事部");
		    			recruit.setPosition("经理");
		    			recruit.setPlanNum(3L);
		    			recruit.setStartTime(new Date());
		    			recruit.setEditName("Miette");
		    			
		    			recruitService.save(recruit);
		    			
		            }
		        };
		    }
}
