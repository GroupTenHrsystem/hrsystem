package com.hrsystem.resume.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostRemove;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;

import lombok.Data;

@Data
@Entity
@Table(name="t_resume")
@SQLDelete(sql="update t_resume set is_deleted_= true where id=?",check = ResultCheckStyle.COUNT)
@SQLDeleteAll(sql="update t_resume set is_deleted_= true where id=?",check = ResultCheckStyle.COUNT)
@Where(clause="is_deleted_ != true")
public class Resume {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;  
	private String sex;  
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date birthday;   //出生年月
	private String nativePlace;   //籍贯
	private String major;   //专业
	private String politicsStatus;  //政治面貌
	private String graduateSchool;  //毕业学校
	private String email;    //邮箱
	private String picutre;   //照片
	private String phone;    //手机
	private String employBranch;  //求职意向
	private String experience;   //工作经历
	private String selfEvaluation;  //自我评价
	private boolean ifrefer;   //是否推荐
	private String referer;   //推荐人
	private String attachment;   //附件
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date applyTime;   
	
	//工作流
	@Enumerated(EnumType.STRING)
	private ProcessStatus processStatus; //流程状态
	private String userId;    //启动流程的用户ID
	private String processInstanceId;  //流程实例ID
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date completeTime;    //面试审批流程完成时间
	private Double penScore;   //笔试分数
	private Double firstAuditScore;  //一面分数
	private String firstBackReason;  //一面退回原因
	private Double lastAuditScore;  //二面分数
	private String lastBackReason;  //二面退回原因
	
	private String firstarr;  //一面面试官
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date firstTime;   //一面时间
	private String lastarr;   //二面面试官
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date lastTime;   //二面时间
	
	@Column(name="is_deleted_")
	private boolean isDeleted;    //  默认为false   true为已删除

	@PostRemove
	public void delete() {
		this.isDeleted = true;
	}
	
}
