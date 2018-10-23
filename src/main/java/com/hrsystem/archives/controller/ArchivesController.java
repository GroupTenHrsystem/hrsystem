package com.hrsystem.archives.controller;




import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrsystem.archives.domain.Archives;
import com.hrsystem.archives.domain.ArchivesDTO;
import com.hrsystem.archives.domain.ArchivesQueryDTO;
import com.hrsystem.archives.service.IArchivesService;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;
import com.hrsystem.performance.entity.Performance;
import com.hrsystem.performance.entity.PerformanceTemplet;
import com.hrsystem.performance.entity.DTO.PerformanceTempletQueryDTO;
import com.hrsystem.training.domain.Enroll;
import com.hrsystem.training.domain.EnrollQueryDTO;


@RestController
@RequestMapping("/archives")
public class ArchivesController {
	@Autowired
	private IArchivesService archivesService;
	@Autowired
    private RepositoryService repositoryService;
	/**
	 * 1、查
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Archives getArchivesById(@PathVariable Long id) {
		return archivesService.findArchivesById(id);
	}
	/**
	 * 2、增
	 * @param Performance
	 * @return
	 */
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertArchives(@RequestBody Archives archives) {		
		try {
			archivesService.insertArchives(archives);
				return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}





	
	 @PostMapping("/upload")
	    public @ResponseBody ExtAjaxResponse deploy(@RequestParam(value = "attach", required = true) MultipartFile file) {
	        // 获取上传的文件名
	        String fileName = file.getOriginalFilename();
	        String picPath = "C:\\fakepath\\";
	        File tempFile = new File(picPath+fileName);
			if(!tempFile.exists()){
				tempFile.getParentFile().mkdir();
				try {
					tempFile.createNewFile();
					file.transferTo(tempFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
	        System.out.println("fileName:"+fileName);
	        try {
	            // 得到输入流（字节流）对象
	            InputStream fileInputStream = file.getInputStream();
	            // 文件的扩展名
	            String extension = FilenameUtils.getExtension(fileName);
	            // zip或者bar类型的文件用ZipInputStream方式部署
	            DeploymentBuilder deployment = repositoryService.createDeployment();
	            if (extension.equals("zip") || extension.equals("bar")) {
	                ZipInputStream zip = new ZipInputStream(fileInputStream);
	                deployment.addZipInputStream(zip);
	            } else {
	                // 其他类型的文件直接部署  bpmn/bpmn20.xml
	                deployment.addInputStream(fileName, fileInputStream);
	            }
	            deployment.deploy();
	            return new ExtAjaxResponse(true,"部署成功!");
	        } catch (Exception e) {
	            
	            return new ExtAjaxResponse(false,"部署失败!");
	        }
	    }
	 
	 
	 
	@PostMapping("/checkbbbb")
	public String insertArchives1(Archives archives) {		
		try {
			
				archivesService.insertArchives(archives);
				return "success:添加成功";
		} catch (Exception e) {
			return "success:添加失败";
		}
	}
	
	@PutMapping("/checklalala")
	public ExtAjaxResponse update1(@Param("id") Long myId,Archives archives) 
	{								
		Archives entity = archivesService.findArchivesById(archives.getId());
		System.out.println(entity.getArstatus());
		if(entity.getArstatus().equals("待审核")) {
		entity.setArstatus("审核通过");
		BeanUtils.copyProperties(archives, entity);//使用自定义的BeanUtils			
		archivesService.insertArchives(entity);
		return new ExtAjaxResponse(true,"操作成功");
		}
		else {
			return new ExtAjaxResponse(true,"只能审核待审核档案");
		}
		 
	}
	@PutMapping("/checknopass")
	public ExtAjaxResponse update2(@Param("id") Long myId,Archives archives) 
	{	
		
		
			Archives entity = archivesService.findArchivesById(archives.getId());
			if(entity.getArstatus().equals("待审核")) {
			entity.setArstatus("审核不通过");
			BeanUtils.copyProperties(archives, entity);//使用自定义的BeanUtils			
			archivesService.insertArchives(entity);
			return new ExtAjaxResponse(true,"操作成功！");
			}
			else {
				return new ExtAjaxResponse(true,"只能审核待审核档案");
			}
	}
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String update(@PathVariable("id") Long myId,@RequestBody Archives dto) 
	{
		try {
			Archives entity = archivesService.findArchivesById(myId);
			BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
			archivesService.insertArchives(entity);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
	
	
	/**
	 * 3、删
	 * @param id
	 * @return
	 */
/*
	 @PostMapping("/deletes")
		public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
		{
			try {
				if(ids!=null) {
					Archives entity = archivesService.findArchivesById(ids[0]);
					System.out.println(entity.getArstatus());
					if(entity.getArstatus().equals("作废")) {
						System.out.println(entity.getArstatus());
						archivesService.deleteAll(ids);
					}
				}
				return new ExtAjaxResponse(true,"批量删除成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
		*/
	 @PostMapping("/deletes")
		public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
		{	 
			
					for (Long id : ids) {
						Archives entity = archivesService.findArchivesById(id);
						if(entity.getArstatus().equals("作废")) {
							//archivesService.deleteById(id);
							continue;
						} else {
							return new ExtAjaxResponse(true,"只能删除作废档案");
						}
					}
					archivesService.deleteAll(ids);
					return new ExtAjaxResponse(true,"操作成功！");
					
	
				

		}
	 
	 
	 
	@GetMapping
	public Page<Archives> getPage(ArchivesQueryDTO archivesQueryDTO,ExtjsPageRequest pageRequest) 
	{
		System.out.println("炸了啊1111");
		return archivesService.findAll(ArchivesQueryDTO.getWhereClause(archivesQueryDTO), pageRequest.getPageable());
	}
	@GetMapping("/checkfirst")
	public Page<Archives> getArchivesByArstatusFirst(ArchivesQueryDTO archivesQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊123");
		System.out.println(archivesQueryDTO.getArchivesId());
		return archivesService.findArchivesByArstatusFirst(ArchivesQueryDTO.getWhereClause(archivesQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping("/check")
	public Page<Archives> getArchivesByArstatus(ArchivesQueryDTO archivesQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊12344");
		System.out.println(archivesQueryDTO.getArchivesId());
		return archivesService.findArchivesByArstatus(archivesQueryDTO.getArchivesId(), ArchivesQueryDTO.getWhereClause(archivesQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping("/pass")
	public Page<Archives> getArchivesByArstatusPass(ArchivesQueryDTO archivesQueryDTO,ExtjsPageRequest pageRequest) {
		System.out.println("炸了啊");
		return archivesService.findArchivesByArstatusPass(ArchivesQueryDTO.getWhereClause(archivesQueryDTO), pageRequest.getPageable());
	}
	
	
	
	
	/*上传*/
	
}
