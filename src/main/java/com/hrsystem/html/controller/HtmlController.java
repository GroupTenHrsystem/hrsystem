package com.hrsystem.html.controller;
/**
*@项目名称: hrsystem
*@作者: HyperMuteki
*@文件名称: HtmlController.java
  *@Date: 2018年9月25日
*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
 
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HtmlController {

    @RequestMapping("/")
    public ModelAndView getThymeleaf() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
