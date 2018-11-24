package com.hrsystem.user.entity.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.sign.GreaterThanEqual;
import com.hrsystem.common.sign.LessThanEqual;
import com.hrsystem.common.sign.Like;
import com.hrsystem.common.sign.Name;
import com.hrsystem.user.entity.Role;
import com.hrsystem.user.entity.Staff;

import lombok.Data;


@Data
public class StaffDTO {
	private Long id;
	private Long employeNum;
	private String staffName;
	
	private String sex;
	private String idcard;
	private String email;
	private String phone;
	private String password;
	 @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date birthday;
	private String address;
	private String nativePlace;
	private String status;
	

	 @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date employmentDate;
	 @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date leaveDate;
	
	private Long roleId;
	private String roleName;
	
	
	public static Page<StaffDTO> toStaffDTO(Page<Staff> page, Pageable pageable) {
		List<StaffDTO> results = new ArrayList<StaffDTO>();
		Iterator iter = page.iterator();
	      while(iter.hasNext()){
	    	  StaffDTO staffDTO1 = new StaffDTO();
	    	  Staff staff=(Staff)iter.next();
	         BeanUtils.copyProperties(staff,staffDTO1);
	         staffDTO1.setRoleId(staff.getRole().getId());
	         staffDTO1.setRoleName(staff.getRole().getPosition());

	         
	         results.add(staffDTO1);
	      }
	      return new PageImpl<StaffDTO> (results, pageable, null!=results?page.getTotalElements():0);
	}
}
