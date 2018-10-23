package com.hrsystem.resume.controller;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.DeploymentBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrsystem.common.ExtAjaxResponse;

@RestController
@RequestMapping("/resuemupload")
public class ResumeUploadController {

	  @PostMapping
	    public @ResponseBody ExtAjaxResponse deploy(@RequestParam(value = "file", required = true) MultipartFile file) {
	        // 获取上传的文件名
	        String fileName = file.getOriginalFilename();
	        System.out.println("fileName:"+fileName);
	        try {
	            // 得到输入流（字节流）对象
	            InputStream fileInputStream = file.getInputStream();
	            // 文件的扩展名
	            String extension = FilenameUtils.getExtension(fileName);
	            // zip或者bar类型的文件用ZipInputStream方式部署
	            //DeploymentBuilder deployment = repositoryService.createDeployment();
	            return new ExtAjaxResponse(true,"上传成功!");
	        } catch (Exception e) {
	            
	            return new ExtAjaxResponse(false,"上传失败!");
	        }
	    }
}
