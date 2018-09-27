package com.hrsystem.user.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private Long employeNum;
	private String staffName;
	private Boolean sex;
	private String idcard;
	private String password;
	private String email;
	private String phone;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date birthday;
	private String address;
	private String nativePlace;
	private String status;
	private String employmentDate;
	private String leaveDate;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "positionId")
	private Role positionId;
}
