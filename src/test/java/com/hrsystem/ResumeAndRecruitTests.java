package com.hrsystem;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hrsystem.interview.entity.Interview;
import com.hrsystem.recruit.entity.Recruit;
import com.hrsystem.recruit.service.IRecruitService;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.resume.service.IResumeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ResumeAndRecruitTests {
	
	@Autowired
	private IRecruitService recruitService;
	@Autowired
	private IResumeService resumeService;
	
	@Test
	public void testInterview() {
		try {
			for (int i = 0; i < 3; i++) {
				Interview interview = new Interview();
     			interview.setInterviewer("mo"+i);
     			interview.setFaceResult("pass");
     			interview.setEstimate("优秀");
     			interview.setFaceDate(new Date());
     			interview.setInterviewStatus("一面");
     			
     			Resume resume = new Resume();
    			resume.setName("kk"+i);
    			resume.setSex("女");
    			resume.setEmail("819934639@qq.com");
    			resume.setReferer("Jony jk");
    			
    			resume.setInterview(interview);
    			resumeService.save(resume);
			}
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testRecruit() {
		try {
			for (int i = 0; i < 5; i++) {
				Recruit recruit = new Recruit();
				recruit.setDepartmentname("人事部");
				recruit.setPosition("经理");
				recruit.setPlanNum(3L);
				recruit.setStartTime(new Date());
				recruit.setEditName("Mi"+i);
				recruit.setContact("电话：13652653652  邮箱：15486526@163.com");
				
				recruitService.save(recruit);
			}

		} catch (Exception e) {
		}
	}

}
