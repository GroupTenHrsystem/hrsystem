package com.hrsystem.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	private String departmentName;
	private String introduce;
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Department superId;
	@OneToMany(cascade = CascadeType.REFRESH)
	private List<Department> upId =new ArrayList<Department>();
	@OneToMany(mappedBy="departmentId",cascade={CascadeType.REFRESH})
	private List<Role> positionId=new ArrayList<Role>();
     
}
