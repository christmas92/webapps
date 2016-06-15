package com.chenyf.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyf.template.service.intf.OperatorService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private OperatorService operatorservice;
	
	@RequestMapping("")
	public String test(ModelMap model){
		model.addAttribute("user", operatorservice.getOperator("admin"));
		return "test";
	}
}
