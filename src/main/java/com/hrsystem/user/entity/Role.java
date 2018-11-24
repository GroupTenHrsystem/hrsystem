package com.hrsystem.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="t_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String position;
	private Long limite;	
	private Boolean status = true;
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Department department;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)	//领导
	private Role role;
	
}
