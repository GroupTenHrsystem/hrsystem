package com.hrsystem.archives.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrsystem.archives.domain.Archives;



@Repository
public interface ArchivesRepository extends PagingAndSortingRepository<Archives, Long>,JpaSpecificationExecutor<Archives>{
	//@Query("select * from t_archives where arstatus ='待审核'")
	@Query(value = "select * from t_archives where arstatus ='待审核' and archives_id=?1 order by archives_id", nativeQuery = true)
	public Page<Archives> findArchivesByArstatus(Long archivesId, Specification<Archives> spec, Pageable pageable);
	
	@Query(value = "select * from t_archives where arstatus ='审核通过'", nativeQuery = true)	
	public Page<Archives> findArchivesByArstatusPass(Specification<Archives> spec, Pageable pageable);
	
	@Query(value = "select * from t_archives where arstatus ='待审核'", nativeQuery = true)	
	public Page<Archives> findArchivesByArstatusFirst(Specification<Archives> spec, Pageable pageable);
}
