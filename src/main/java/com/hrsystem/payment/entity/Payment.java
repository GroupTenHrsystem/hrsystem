package com.hrsystem.payment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.activiti.domain.ProcessStatus;

import lombok.Data;

@Data
@Entity
@Table(name="t_payment")
public class Payment {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	
	private String reason;
	private Double price;
	private String backReason;
	
	private ProcessStatus processStatus;
    private String userId;
    private String processInstanceId;
    
    private Boolean status = true;
	
}
