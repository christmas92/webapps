package com.chenyf.template.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
	    String contextPath = request.getContextPath();
	    String url = requestUri.substring(contextPath.length());
	    System.out.println("requestUri:" + requestUri);
	    System.out.println("contextPath:" + contextPath);
	    System.out.println("url:" + url);
	    Object obj = request.getSession().getAttribute("user");
	    if(obj == null){
	    	System.out.println("forward : /login ");
	    	request.getRequestDispatcher("/login").forward(request, response);;
	    	System.out.println("forward ok!");
	    	return false;
	    }else {
			return true;
		}
	}
	
}
