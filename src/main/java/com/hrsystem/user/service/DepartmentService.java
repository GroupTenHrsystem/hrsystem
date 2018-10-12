package com.hrsystem.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsystem.calendar.entity.Event;
import com.hrsystem.user.entity.Department;
import com.hrsystem.user.entity.Staff;
import com.hrsystem.user.repository.DepartmentRepository;
import com.hrsystem.user.repository.StaffRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private StaffRepository staffRepository;
	
	public Department findDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public void insertDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);

	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);

	}

	@Override
	public void deleteAll(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long>idList =new ArrayList<Long>(Arrays.asList(ids));
		List<Department>check=(List<Department>) departmentRepository.findAllById(idList);
		departmentRepository.deleteAll(check);
	}

	@Override
	public Page<Department> findAll(Specification<Department> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return departmentRepository.findAll(spec, pageable);
	}

	@Override
	public List<Department> getDepartmentList(Specification<Department> spec) {
		// TODO Auto-generated method stub
		return departmentRepository.findAll(spec);
	}
	
	//所有子部门
	@Override
	public List<Department> findAllSubChildrens(List<Department> lists,Long parentId) {
			
			if(lists==null) {
				lists = new ArrayList<Department>();  
			}
			      
	        //获取子单位   
	        List<Department> departments = departmentRepository.findChildrens(parentId);
	        //加入当前单位 的子节点（必须）
	        lists.addAll(departments);
	        
	        for (Department d : departments) {             
	             //递归子单位 
	        	findAllSubChildrens(lists, d.getId());
	        }
	        
	        //加入当前节点 （可选）
	        //Organization organization= organizationRepository.findOne(parentId);
	        //lists.add(organization);
	        //lists = new ArrayList<Organization>(new HashSet<Organization>(lists));//去重复
	        
			return lists;       
	}
	
	//所有子部门的ID
	@Override
	public List<Long> findAllSubChildrensIds(List<Long> idLists,Long parentId) {
			
			if(idLists==null) {
				idLists = new ArrayList<Long>();  
			}
			      
	        //获取子单位   
	        List<Long> childrensIds = departmentRepository.findChildrensIds(parentId);
	        //加入当前单位 的子节点（必须）
	        idLists.addAll(childrensIds);
	        
	        for (Long id : childrensIds) {             
	             //递归子单位 
	        	findAllSubChildrensIds(idLists, id);
	        }
	        //加入当前节点 （可选）      
	        //idLists.add(parentId);
	        //idLists = new ArrayList<Long>(new HashSet<Long>(idLists));//去重复       
			return idLists;       
		}
	
	//父部门和所有子部门的员工
	@Override
	public List<Staff> findAllSubChildrensStaffs(List<Long> idLists,Long parentId) {
			
			if(idLists==null) {
				idLists = new ArrayList<Long>();  
			}
			      
	        //获取子单位   
	        List<Long> childrensIds = departmentRepository.findChildrensIds(parentId);
	        //加入当前单位 的子节点（必须）
	        idLists.addAll(childrensIds);
	        
	        for (Long id : childrensIds) {             
	             //递归子单位 
	        	findAllSubChildrensIds(idLists, id);
	        }
	        //找出子部门和父部门的全部员工
	        List<Staff> staffList = new ArrayList<Staff>(); 
	        for (Long id : idLists) {             
	             //递归子单位 
	        	staffList.addAll(staffRepository.findByDepartmentId(id));
	        }      
			return staffList;       
		}
	
//	@Override
//	public List<Department> getDepartmentByDepartmentTempletId(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
