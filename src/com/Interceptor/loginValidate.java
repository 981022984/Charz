package com.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author zuo
 * @time 2018年6月26日20:05:11
 * @version 1.0
 * 拦截器，拦截未登陆的用户访问非初始界面
 */
public class loginValidate implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler) throws Exception{
		
		System.out.println("URI--"+request.getRequestURI());
		System.out.println("userID--"+request.getParameter("userID"));
		if(request.getRequestURI().indexOf("/json") >= 0) {       //异步请求放行
			return true;
		}
		if(request.getRequestURI().indexOf("/language") >= 0) {   //语言请求放行
			return true;
		}
		if(request.getRequestURI().indexOf("/userRegister") >= 0 ||
				request.getRequestURI().indexOf("/addNewUser") >= 0) {   //注册，放行
			return true;
		}
		
		if(request.getRequestURI().indexOf("/firstLogin") >= 0 || 
				request.getRequestURI().indexOf("/back") >= 0) {
			System.out.println("登录页面，放行");
			return true;
		}
		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		if(session.getAttribute(userID)!=null) {
			System.out.println("已登录用户，放行");
			return true;
		}
		System.out.println("请先登录");
		request.getRequestDispatcher("/firstLogin").forward(request,response);
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler,ModelAndView modelandview) throws Exception{
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, 
			Object handler, Exception ex)  throws Exception {    
          
    }  
}
