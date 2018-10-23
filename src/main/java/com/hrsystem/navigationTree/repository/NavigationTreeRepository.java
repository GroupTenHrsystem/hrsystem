package com.hrsystem.navigationTree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.navigationTree.entity.NavigationTree;

/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: NavigationTreeRepository.java
  *@Date: 2018年10月22日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
@Repository
public interface NavigationTreeRepository extends PagingAndSortingRepository<NavigationTree, Long>,JpaSpecificationExecutor<NavigationTree>{
	@Query(value="SELECT * FROM hrsystem.t_navigation_tree WHERE super_node_id is NULL AND  status = ?1",nativeQuery=true)
	public List<NavigationTree> findNoParent(Integer status);
}
