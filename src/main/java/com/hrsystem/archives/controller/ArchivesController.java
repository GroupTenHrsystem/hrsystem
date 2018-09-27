package com.hrsystem.archives.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hrsystem.archives.domain.Archives;
import com.hrsystem.archives.domain.ArchivesQueryDTO;
import com.hrsystem.archives.service.IArchivesService;
import com.hrsystem.common.BeanUtils;
import com.hrsystem.common.ExtAjaxResponse;
import com.hrsystem.common.ExtjsPageRequest;

@RestController
@RequestMapping("/archives")
public class ArchivesController {
	@Autowired
	private IArchivesService archivesService;
	@GetMapping
	public Page<Archives> getPage(ArchivesQueryDTO archivesQueryDTO , ExtjsPageRequest pageRequest) 
	{
		return archivesService.findAll(ArchivesQueryDTO.getWhereClause(archivesQueryDTO), pageRequest.getPageable());
	}
	
	@GetMapping(value="{id}")
	public Archives getOne(@PathVariable("id") Long id) 
	{
		return archivesService.findById(id).get();
	}

	@DeleteMapping(value="{id}")
	public ExtAjaxResponse delete(@PathVariable("id") Long id) 
	{
		try {
			if(id!=null) {
				archivesService.deleteById(id);
			}
			return new ExtAjaxResponse(true,"删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"删除失败！");
		}
	}
	
	@PostMapping("/deletes")
	public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
	{
		try {
			if(ids!=null) {
				archivesService.deleteAll(ids);
			}
			return new ExtAjaxResponse(true,"批量删除成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"批量删除失败！");
		}
	}
	
	
	@PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse update(@PathVariable("id") Long myId,@RequestBody Archives dto) 
	{
		try {
			Archives entity = archivesService.findById(myId).get();
			if(entity!=null) {
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				archivesService.save(entity);
			}
			return new ExtAjaxResponse(true,"更新成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"更新失败！");
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ExtAjaxResponse save(@RequestBody Archives archives) 
	{
		try {
			archivesService.save(archives);
			return new ExtAjaxResponse(true,"保存成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(true,"保存失败！");
		}
	}
	
	

	@RequestMapping("/datatest")
	public String testData() {
		try {
			Archives a1 = new Archives();
			a1.setSsCard("00001");
			a1.setBankCard("00001");
			a1.setEducation("大学");
			a1.setMajor("环境工程");
			a1.setGraduateSchool("东莞理工学院");
			a1.setRecord("无");
			a1.setFamily("无");
			a1.setRemark("无");
			a1.setAttach("无");
			a1.setArstatus("1");
			Archives a2 = new Archives();
			a2.setSsCard("00002");
			a2.setBankCard("00002");
			a2.setEducation("大学");
			a2.setMajor("城乡建设");
			a2.setGraduateSchool("华南理工");
			a2.setRecord("无");
			a2.setFamily("无");
			a2.setRemark("无");
			a2.setAttach("无");
			a2.setArstatus("0");
			archivesService.save(a1);
			archivesService.save(a2);
			return "success:true";
		} catch (Exception e) {
			return "success:false";
		}
	}
	

	
	
}
