package com.hrsystem.user.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="t_staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeNum;
	private String staffName;
	private String sex;
	private String idcard;
	private String password;
	private String email;
	private String phone;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date birthday;
	private String address;
	private String nativePlace;
	private String status;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date employmentDate;
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date leaveDate;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "positionId")
	private Role role;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Department department;
}
