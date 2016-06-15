package com.chenyf.template.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/auth")
	@ResponseBody
	public Map<String, Object> auth(@RequestParam("name") String name, @RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.setAttribute("user", name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		System.out.println(name);
		System.out.println(session.getAttribute("user"));
		return map;
	}
	
	
	@RequestMapping("")
	public String index(){
		return "login";
	}
}
