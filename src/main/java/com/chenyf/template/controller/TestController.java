package com.chenyf.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenyf.template.model.Operator;
import com.chenyf.template.service.intf.OperatorService;
import com.chenyf.template.util.PageManager;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private OperatorService operatorservice;
	
	@RequestMapping("")
	public String test(){
		return "redirect:test/page/1";
	}
	
	@RequestMapping("/page/{currpage}")
	public String getList(ModelMap model,@PathVariable("currpage") String currpage){
		PageManager<Operator> page = new PageManager<>();
		page.setCurrentPage(Integer.parseInt(currpage));
		this.operatorservice.getList(model, page);
		return "test";
	}
}
