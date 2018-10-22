package com.hrsystem;

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

import com.hrsystem.navigationTree.entity.NavigationTree;
import com.hrsystem.navigationTree.service.INavigationTreeService;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.recruit.entity.Recruit;
import com.hrsystem.resume.entity.Resume;
import com.hrsystem.salary.entity.SalaryStandard;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTreeBean.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
/*
 * 
 * 最高权限
 * 
 * 
 * */
//@Component
public class NavigationTreeBean {
	@Bean
	InitializingBean NavigationTreeInitializer(final INavigationTreeService navigationTreeService) {
	     return new InitializingBean() {
		         public void afterPropertiesSet() throws Exception {
		        	 NavigationTree navigationTree1 = new NavigationTree();
		        	 navigationTree1.setText("流程定义模块");
		        	 navigationTree1.setIconCls("fa fa-files-o");
		        	 navigationTree1.setLeaf(true);
		        	 navigationTree1.setViewType("processDefinitionCenterPanel");
		        	 
		        	 NavigationTree navigationTree2 = new NavigationTree();
		        	 navigationTree2.setText("系统管理模块");
		        	 navigationTree2.setIconCls("x-fa fa-address-card");
		        	 navigationTree2.setSelectable(false);
		        	 navigationTree2.setExpanded(false);
				        	 
				        	 NavigationTree navigationTree3 = new NavigationTree();
				        	 navigationTree3.setText("用户管理");
				        	 navigationTree3.setIconCls("x-fa fa-address-card");
				        	 navigationTree3.setLeaf(true);
				        	 navigationTree3.setViewType("user");
				        	 navigationTree3.setSuperNode(navigationTree2);
				        	 
				        	 NavigationTree navigationTree4 = new NavigationTree();
				        	 navigationTree4.setText("个人信息管理");
				        	 navigationTree4.setIconCls("x-fa fa-address-card");
				        	 navigationTree4.setLeaf(true);
				        	 navigationTree4.setViewType("person");
				        	 navigationTree4.setSuperNode(navigationTree2);
				        	 
				        	 NavigationTree navigationTree5 = new NavigationTree();
				        	 navigationTree5.setText("组织架构管理");
				        	 navigationTree5.setIconCls("x-fa fa-exclamation-triangle");
				        	 navigationTree5.setLeaf(true);
				        	 navigationTree5.setViewType("department");
				        	 navigationTree5.setSuperNode(navigationTree2);
				        	 
				        	 NavigationTree navigationTree6 = new NavigationTree();
				        	 navigationTree6.setText("职位管理");
				        	 navigationTree6.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree6.setLeaf(true);
				        	 navigationTree6.setViewType("role");
				        	 navigationTree6.setSuperNode(navigationTree2);
				        	 
		        	 NavigationTree navigationTree7 = new NavigationTree();
		        	 navigationTree7.setText("人事管理模块");
		        	 navigationTree7.setIconCls("x-fa fa-address-card");
		        	 navigationTree7.setSelectable(false);
		        	 navigationTree7.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree8 = new NavigationTree();
				        	 navigationTree8.setText("档案登记与变更");
				        	 navigationTree8.setIconCls("x-fa fa-address-card");
				        	 navigationTree8.setLeaf(true);
				        	 navigationTree8.setViewType("archives");
				        	 navigationTree8.setSuperNode(navigationTree7);
				        	 
				        	 NavigationTree navigationTree9 = new NavigationTree();
				        	 navigationTree9.setText("人事档案复核");
				        	 navigationTree9.setIconCls("x-fa fa-address-card");
				        	 navigationTree9.setLeaf(true);
				        	 navigationTree9.setViewType("archives");
				        	 navigationTree9.setSuperNode(navigationTree7);
				        	 
				        	 NavigationTree navigationTree10 = new NavigationTree();
				        	 navigationTree10.setText("人事档案查询");
				        	 navigationTree10.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree10.setLeaf(true);
				        	 navigationTree10.setViewType("archivesAll");
				        	 navigationTree10.setSuperNode(navigationTree7);
		        	 
		        	 NavigationTree navigationTree11 = new NavigationTree();
		        	 navigationTree11.setText("招聘管理模块");
		        	 navigationTree11.setIconCls("x-fa fa-address-card");
		        	 navigationTree11.setSelectable(false);
		        	 navigationTree11.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree12 = new NavigationTree();
				        	 navigationTree12.setText("招聘信息发布");
				        	 navigationTree12.setIconCls("x-fa fa-address-card");
				        	 navigationTree12.setLeaf(true);
				        	 navigationTree12.setViewType("recruit");
				        	 navigationTree12.setSuperNode(navigationTree11);
				        	 
				        	 NavigationTree navigationTree13 = new NavigationTree();
				        	 navigationTree13.setText("简历管理");
				        	 navigationTree13.setIconCls("x-fa fa-exclamation-triangle");
				        	 navigationTree13.setLeaf(true);
				        	 navigationTree13.setViewType("resume");
				        	 navigationTree13.setSuperNode(navigationTree11);
				        	 
				        	 NavigationTree navigationTree14 = new NavigationTree();
				        	 navigationTree14.setText("面试安排");
				        	 navigationTree14.setIconCls("x-fa fa-exclamation-triangle");
				        	 navigationTree14.setLeaf(true);
				        	 navigationTree14.setViewType("resumeArrangePanel");
				        	 navigationTree14.setSuperNode(navigationTree11);
				        	 
				        	 NavigationTree navigationTree15 = new NavigationTree();
				        	 navigationTree15.setText("面试结果审核录入");
				        	 navigationTree15.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree15.setLeaf(true);
				        	 navigationTree15.setViewType("resumeApprovePanel");
				        	 navigationTree15.setSuperNode(navigationTree11);
				        	 
				        	 NavigationTree navigationTree16 = new NavigationTree();
				        	 navigationTree16.setText("录用管理");
				        	 navigationTree16.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree16.setLeaf(true);
				        	 navigationTree16.setViewType("employ");
				        	 navigationTree16.setSuperNode(navigationTree11);
		        	 
		        	 NavigationTree navigationTree17 = new NavigationTree();
		        	 navigationTree17.setText("培训管理模块");
		        	 navigationTree17.setIconCls("x-fa fa-address-card");
		        	 navigationTree17.setSelectable(false);
		        	 navigationTree17.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree18 = new NavigationTree();
				        	 navigationTree18.setText("培训计划录入");
				        	 navigationTree18.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree18.setLeaf(true);
				        	 navigationTree18.setViewType("training");
				        	 navigationTree18.setSuperNode(navigationTree17);
				        	 
				        	 NavigationTree navigationTree19 = new NavigationTree();
				        	 navigationTree19.setText("培训人员报名");
				        	 navigationTree19.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree19.setLeaf(true);
				        	 navigationTree19.setViewType("enroll");
				        	 navigationTree19.setSuperNode(navigationTree17);
				        	 
				        	 NavigationTree navigationTree19_5 = new NavigationTree();
				        	 navigationTree19_5.setText("培训复核");
				        	 navigationTree19_5.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree19_5.setLeaf(true);
				        	 navigationTree19_5.setViewType("trainingAll");
				        	 navigationTree19_5.setSuperNode(navigationTree17);
				        	 
				        	 NavigationTree navigationTree20 = new NavigationTree();
				        	 navigationTree20.setText("报名复核");
				        	 navigationTree20.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree20.setLeaf(true);
				        	 navigationTree20.setViewType("enrollAll");
				        	 navigationTree20.setSuperNode(navigationTree17);
				        	 
				        	 NavigationTree navigationTree21 = new NavigationTree();
				        	 navigationTree21.setText("培训反馈表");
				        	 navigationTree21.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree21.setLeaf(true);
				        	 navigationTree21.setViewType("feedback");
				        	 navigationTree21.setSuperNode(navigationTree17);
		        	 
		        	 NavigationTree navigationTree22 = new NavigationTree();
		        	 navigationTree22.setText("考勤管理模块");
		        	 navigationTree22.setIconCls("x-fa fa-address-card");
		        	 navigationTree22.setSelectable(false);
		        	 navigationTree22.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree23 = new NavigationTree();
				        	 navigationTree23.setText("签到签退");
				        	 navigationTree23.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree23.setLeaf(true);
				        	 navigationTree23.setViewType("sign");
				        	 navigationTree23.setSuperNode(navigationTree22);
				        	 
				        	 NavigationTree navigationTree24 = new NavigationTree();
				        	 navigationTree24.setText("请假管理");
				        	 navigationTree24.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree24.setLeaf(true);
				        	 navigationTree24.setViewType("leaveCenterPanel");
				        	 navigationTree24.setSuperNode(navigationTree22);
				        	 
				        	 NavigationTree navigationTree25 = new NavigationTree();
				        	 navigationTree25.setText("请假审批");
				        	 navigationTree25.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree25.setLeaf(true);
				        	 navigationTree25.setViewType("leaveApproveCenterPanel");
				        	 navigationTree25.setSuperNode(navigationTree22);
				        	 
				        	 NavigationTree navigationTree26 = new NavigationTree();
				        	 navigationTree26.setText("请假统计");
				        	 navigationTree26.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree26.setLeaf(true);
				        	 navigationTree26.setSuperNode(navigationTree22);
				        	 //navigationTree21.setViewType("feedback");
				        	 
				        	 NavigationTree navigationTree27 = new NavigationTree();
				        	 navigationTree27.setText("考勤情况查看");
				        	 navigationTree27.setIconCls("x-fa fa-lightbulb-o");
				        	 navigationTree27.setLeaf(true);
				        	 navigationTree27.setViewType("attendance");
				        	 navigationTree27.setSuperNode(navigationTree22);
		        	 
		        	 NavigationTree navigationTree28 = new NavigationTree();
		        	 navigationTree28.setText("资金管理模块");
		        	 navigationTree28.setIconCls("fa fa-cc-visa");
		        	 navigationTree28.setSelectable(false);
		        	 navigationTree28.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree29 = new NavigationTree();
				        	 navigationTree29.setText("薪资标准管理");
				        	 navigationTree29.setIconCls("fa fa-cc-paypal");
				        	 navigationTree29.setLeaf(true);
				        	 navigationTree29.setViewType("salaryStandard");
				        	 navigationTree29.setSuperNode(navigationTree28);
				        	 
				        	 NavigationTree navigationTree30 = new NavigationTree();
				        	 navigationTree30.setText("薪资查询");
				        	 navigationTree30.setIconCls("fa fa-cc-jcb");
				        	 navigationTree30.setLeaf(true);
				        	 navigationTree30.setViewType("salary");
				        	 navigationTree30.setSuperNode(navigationTree28);
				        	 
				        	 NavigationTree navigationTree31 = new NavigationTree();
				        	 navigationTree31.setText("薪资分析");
				        	 navigationTree31.setIconCls("fa fa-paypal");
				        	 navigationTree31.setLeaf(true);
				        	 navigationTree31.setViewType("salaryAnalysis");
				        	 navigationTree31.setSuperNode(navigationTree28);
				        	 
				        	 NavigationTree navigationTree32 = new NavigationTree();
				        	 navigationTree32.setText("报销管理");
				        	 navigationTree32.setIconCls("fa fa-dollar");
				        	 navigationTree32.setLeaf(true);
				        	 navigationTree32.setViewType("paymentCenterPanel");
				        	 navigationTree32.setSuperNode(navigationTree28);
				        	 
				        	 NavigationTree navigationTree33 = new NavigationTree();
				        	 navigationTree33.setText("报销审批");
				        	 navigationTree33.setIconCls("fa fa-money");
				        	 navigationTree33.setLeaf(true);
				        	 navigationTree33.setViewType("paymentApproveCenterPanel");
				        	 navigationTree33.setSuperNode(navigationTree28);
		        	 
		        	 NavigationTree navigationTree34 = new NavigationTree();
		        	 navigationTree34.setText("绩效管理模块");
		        	 navigationTree34.setIconCls("fa fa-area-chart");
		        	 navigationTree34.setSelectable(false);
		        	 navigationTree34.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree35 = new NavigationTree();
				        	 navigationTree35.setText("绩效模板");
				        	 navigationTree35.setIconCls("fa fa-bar-chart");
				        	 navigationTree35.setLeaf(true);
				        	 navigationTree35.setViewType("performanceTemplet");
				        	 navigationTree35.setSuperNode(navigationTree34);
				        	 
				        	 NavigationTree navigationTree36 = new NavigationTree();
				        	 navigationTree36.setText("绩效考核");
				        	 navigationTree36.setIconCls("fa fa-line-chart");
				        	 navigationTree36.setLeaf(true);
				        	 navigationTree36.setViewType("performance");
				        	 navigationTree36.setSuperNode(navigationTree34);
				        	 
				        	 NavigationTree navigationTree37 = new NavigationTree();
				        	 navigationTree37.setText("待考核");
				        	 navigationTree37.setIconCls("fa fa-pie-chart");
				        	 navigationTree37.setLeaf(true);
				        	 navigationTree37.setViewType("performanceApproveCenterPanel");
				        	 navigationTree37.setSuperNode(navigationTree34);
		        	 
		        	 NavigationTree navigationTree38 = new NavigationTree();
		        	 navigationTree38.setText("日程安排模块");
		        	 navigationTree38.setIconCls("fa fa-table");
		        	 navigationTree38.setLeaf(true);
		        	 navigationTree38.setViewType("scheduling");
		        	 
		        	 NavigationTree navigationTree39 = new NavigationTree();
		        	 navigationTree39.setText("工作汇报");
		        	 navigationTree39.setIconCls("fa fa-cab");
		        	 navigationTree39.setSelectable(false);
		        	 navigationTree39.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree40 = new NavigationTree();
				        	 navigationTree40.setText("工作汇报");
				        	 navigationTree40.setIconCls("fa fa-car");
				        	 navigationTree40.setLeaf(true);
				        	 navigationTree40.setViewType("report");
				        	 navigationTree40.setSuperNode(navigationTree39);
				        	 
				        	 NavigationTree navigationTree41 = new NavigationTree();
				        	 navigationTree41.setText("查询全部");
				        	 navigationTree41.setIconCls("fa fa-ship");
				        	 navigationTree41.setLeaf(true);
				        	 navigationTree41.setViewType("reportAll");
				        	 navigationTree41.setSuperNode(navigationTree39);
				        	 
		        	 NavigationTree navigationTree42 = new NavigationTree();
		        	 navigationTree42.setText("Login");
		        	 navigationTree42.setIconCls("fa fa-rocket");
		        	 navigationTree42.setLeaf(true);
		        	 navigationTree42.setViewType("login");
		        	 navigationTree42.setVisible(false);
		        	 
		        	 NavigationTree navigationTree43 = new NavigationTree();
		        	 navigationTree43.setText("数据分析");
		        	 navigationTree43.setIconCls("fa fa-rocket");
		        	 navigationTree43.setSelectable(false);
		        	 navigationTree43.setExpanded(false);
		        	 
				        	 NavigationTree navigationTree44 = new NavigationTree();
				        	 navigationTree44.setText("用户信息分析");
				        	 navigationTree44.setIconCls("fa fa-rocket");
				        	 navigationTree44.setLeaf(true);
				        	 navigationTree44.setViewType("user");
				        	 navigationTree44.setSuperNode(navigationTree43);
				        	 
				        	 NavigationTree navigationTree45 = new NavigationTree();
				        	 navigationTree45.setText("人资分析");
				        	 navigationTree45.setIconCls("fa fa-rocket");
				        	 navigationTree45.setLeaf(true);
				        	 navigationTree45.setViewType("pieChart");
				        	 navigationTree45.setSuperNode(navigationTree43);
				        	 
				        	 NavigationTree navigationTree46 = new NavigationTree();
				        	 navigationTree46.setText("工资分析");
				        	 navigationTree46.setIconCls("fa fa-rocket");
				        	 navigationTree46.setLeaf(true);
				        	 navigationTree46.setViewType("lineChart");
				        	 navigationTree46.setSuperNode(navigationTree43);
		        	 	
				      navigationTreeService.save(navigationTree1);
				      navigationTreeService.save(navigationTree2);
				      navigationTreeService.save(navigationTree3);
				      navigationTreeService.save(navigationTree4);
				      navigationTreeService.save(navigationTree5);
				      navigationTreeService.save(navigationTree6);
				      navigationTreeService.save(navigationTree7);
				      navigationTreeService.save(navigationTree8);
				      navigationTreeService.save(navigationTree9);
				      navigationTreeService.save(navigationTree10);
				      navigationTreeService.save(navigationTree11);
				      navigationTreeService.save(navigationTree12);
				      navigationTreeService.save(navigationTree13);
				      navigationTreeService.save(navigationTree14);
				      navigationTreeService.save(navigationTree15);
				      navigationTreeService.save(navigationTree16);
				      navigationTreeService.save(navigationTree17);
				      navigationTreeService.save(navigationTree18);
				      navigationTreeService.save(navigationTree19);
				      navigationTreeService.save(navigationTree19_5);
				      navigationTreeService.save(navigationTree20);
				      navigationTreeService.save(navigationTree21);
				      navigationTreeService.save(navigationTree22);
				      navigationTreeService.save(navigationTree23);
				      navigationTreeService.save(navigationTree24);
				      navigationTreeService.save(navigationTree25);
				      navigationTreeService.save(navigationTree26);
				      navigationTreeService.save(navigationTree27);
				      navigationTreeService.save(navigationTree28);
				      navigationTreeService.save(navigationTree29);
				      navigationTreeService.save(navigationTree30);
				      navigationTreeService.save(navigationTree31);
				      navigationTreeService.save(navigationTree32);
				      navigationTreeService.save(navigationTree33);
				      navigationTreeService.save(navigationTree34);
				      navigationTreeService.save(navigationTree35);
				      navigationTreeService.save(navigationTree36);
				      navigationTreeService.save(navigationTree37);
				      navigationTreeService.save(navigationTree38);
				      navigationTreeService.save(navigationTree39);
				      navigationTreeService.save(navigationTree40);
				      navigationTreeService.save(navigationTree41);
				      navigationTreeService.save(navigationTree42);
				      navigationTreeService.save(navigationTree43);
				      navigationTreeService.save(navigationTree44);
				      navigationTreeService.save(navigationTree45);
				      navigationTreeService.save(navigationTree46);
		         }
	        };
	}
	     
}
