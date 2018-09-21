package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.example.demo.entity.User;
import com.example.demo.entity.DTO.UserQueryDTO;
import com.example.demo.entity.common.BeanUtils;
import com.example.demo.entity.common.ExtAjaxResponse;
import com.example.demo.entity.common.ExtjsPageRequest;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/user")
public class UserController {
	  @Autowired
	    private UserService userService;
	  
//	  @GetMapping(value = "find/{createTime}")
//	    public User findUserByCreateTime(@PathVariable("createTime") String createTime){
//		  User user = userService.findUserByName(createTime);
//	      return user;
//	    }
	  
	  @GetMapping
		public Page<User> getPage(UserQueryDTO userQueryDTO,ExtjsPageRequest pageRequest) 
		{
			return userService.findAll(UserQueryDTO.getWhereClause(userQueryDTO), pageRequest.getPageable());
		}
	  
	  
//	  @GetMapping(value = "{createTime}")
//		public Page<User> findUserByCreateTime(@PathVariable("createTime")@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8") Date createTime, ExtjsPageRequest pageRequest) 
//		{
//			return userService.findUserByCreateTime(createTime, pageRequest.getPageable());
//		}
	  
	  @PutMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
		public String update(@PathVariable("id") Long myId,@RequestBody User dto) 
		{
			try {
				User entity = userService.findUserById(myId).get();
				BeanUtils.copyProperties(dto, entity);//使用自定义的BeanUtils
				userService.insertUser(entity);
				return "success:true";
			} catch (Exception e) {
				return "success:false";
			}
	}
	  
	  @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
		public String save(@RequestBody User user) 
		{
			try {
				userService.insertUser(user);
				return "success:true";
			} catch (Exception e) {
				return "success:false";
			}
		}
	  
	  @DeleteMapping(value="{id}")
		public String delete(@PathVariable("id") Long id) 
		{
		try {
				userService.deleteUser(id);
				return "success:true";
			} catch (Exception e) {
				return "success:false";
			}
		}
	  @PostMapping("/deletes")
		public ExtAjaxResponse deleteRows(@RequestParam(name="ids") Long[] ids) 
		{
			try {
				if(ids!=null) {
					userService.deleteAll(ids);
				}
				return new ExtAjaxResponse(true,"批量删除成功！");
			} catch (Exception e) {
				return new ExtAjaxResponse(true,"批量删除失败！");
			}
		}
	  
	  @RequestMapping("/upload")
	  public String upload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
	     String filePath ="\\src\\main\\resources\\upload\\";
	     String relativelyPath=System.getProperty("user.dir"); 
	     File tempFile = new File(relativelyPath+filePath+file.getOriginalFilename());
	     System.out.println(relativelyPath);
	     if(!tempFile.exists()){
	        //先得到文件的上级目录，并创建上级目录，在创建文件
	        tempFile.getParentFile().mkdir();
	        try {
	           //创建文件
	           tempFile.createNewFile();
	           file.transferTo(tempFile);
	        } catch (IOException e) {
	           e.printStackTrace();
	        }
	     }

	     return "success:true";
	  }
}
