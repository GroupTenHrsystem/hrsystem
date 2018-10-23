package com.hrsystem;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hrsystem.navigationTree.entity.NavigationTree;
import com.hrsystem.navigationTree.service.INavigationTreeService;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: FinanceNavigationTreeBean.java
  *@Date: 2018年10月23日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
/*
 * 
 * 财务员工
 * 
 * 
 * */
//@Component
public class FinanceNavigationTreeBean {
	@Bean
	InitializingBean FinanceNavigationTreeInitializer(final INavigationTreeService navigationTreeService) {
		 return new InitializingBean() {
	         public void afterPropertiesSet() throws Exception {

	        	 NavigationTree navigationTree2 = new NavigationTree();
	        	 navigationTree2.setText("系统管理模块");
	        	 navigationTree2.setStatus(1);
	        	 navigationTree2.setIconCls("x-fa fa-address-card");
	        	 navigationTree2.setSelectable(false);
	        	 navigationTree2.setExpanded(false);
			        	 
			        	 NavigationTree navigationTree4 = new NavigationTree();
			        	 navigationTree4.setText("个人信息管理");
			        	 navigationTree4.setIconCls("x-fa fa-address-card");
			        	 navigationTree4.setLeaf(true);
			        	 navigationTree4.setViewType("person");
			        	 navigationTree4.setSuperNode(navigationTree2);
	        	 
	        	 NavigationTree navigationTree11 = new NavigationTree();
	        	 navigationTree11.setText("招聘管理模块");
	        	 navigationTree11.setStatus(1);
	        	 navigationTree11.setIconCls("x-fa fa-address-card");
	        	 navigationTree11.setSelectable(false);
	        	 navigationTree11.setExpanded(false);
	        	 
			        	 NavigationTree navigationTree12 = new NavigationTree();
			        	 navigationTree12.setText("招聘信息发布");
			        	 navigationTree12.setIconCls("x-fa fa-address-card");
			        	 navigationTree12.setLeaf(true);
			        	 navigationTree12.setViewType("recruit");
			        	 navigationTree12.setSuperNode(navigationTree11);	 
	        	 
	        	 NavigationTree navigationTree17 = new NavigationTree();
	        	 navigationTree17.setText("培训管理模块");
	        	 navigationTree17.setStatus(1);
	        	 navigationTree17.setIconCls("x-fa fa-address-card");
	        	 navigationTree17.setSelectable(false);
	        	 navigationTree17.setExpanded(false);
	        	 
			        	 
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
	        	 navigationTree22.setStatus(1);
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
	        	 navigationTree28.setStatus(1);
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
	        	 navigationTree34.setStatus(1);
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
	        	 navigationTree38.setStatus(1);
	        	 navigationTree38.setIconCls("fa fa-table");
	        	 navigationTree38.setLeaf(true);
	        	 navigationTree38.setViewType("scheduling");
	        	 
	        	 NavigationTree navigationTree39 = new NavigationTree();
	        	 navigationTree39.setText("工作汇报");
	        	 navigationTree39.setStatus(1);
	        	 navigationTree39.setIconCls("fa fa-cab");
	        	 navigationTree39.setSelectable(false);
	        	 navigationTree39.setExpanded(false);
	        	 
			        	 NavigationTree navigationTree40 = new NavigationTree();
			        	 navigationTree40.setText("工作汇报");
			        	 navigationTree40.setIconCls("fa fa-car");
			        	 navigationTree40.setLeaf(true);
			        	 navigationTree40.setViewType("report");
			        	 navigationTree40.setSuperNode(navigationTree39);
	 
	        	 NavigationTree navigationTree42 = new NavigationTree();
	        	 navigationTree42.setText("登出");
	        	 navigationTree42.setStatus(1);
	        	 navigationTree42.setIconCls("fa fa-rocket");
	        	 navigationTree42.setLeaf(true);
	        	 navigationTree42.setViewType("login");
	        	 navigationTree42.setVisible(false);
	        	 
	        	 NavigationTree navigationTree43 = new NavigationTree();
	        	 navigationTree43.setText("数据分析");
	        	 navigationTree43.setStatus(1);
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
	        	 	
			     
			      navigationTreeService.save(navigationTree2);
			      navigationTreeService.save(navigationTree4);
			      navigationTreeService.save(navigationTree11);
			      navigationTreeService.save(navigationTree12);
			      navigationTreeService.save(navigationTree17);
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
			      navigationTreeService.save(navigationTree43);
			      navigationTreeService.save(navigationTree44);
			      navigationTreeService.save(navigationTree45);
			      navigationTreeService.save(navigationTree46);
			      navigationTreeService.save(navigationTree42);
	         }
        };
	}
}
