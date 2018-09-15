package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


import com.model.Student;
import com.service.loginService;
import com.service.loginServiceImpl;

/**
 * @author zuo
 * @time 2018年6月26日19:51:31
 * @version 1.0
 * 登录等一系列的请求的Controller
 */
@Controller
public class loginController {
	
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;  								 //依赖注入？(不是)
	
	private static final Log logger = LogFactory.getLog(loginController.class);
	
	
	//国际化语言选择
	@RequestMapping(value="/language")       //语言设置
	public String setLanguage(HttpServletRequest request,Model model) {
		String request_locale = request.getParameter("request_locale");
		System.out.println("language--"+request_locale);
		Locale locale1 = new Locale("zh", "CN");
		Locale locale2 = new Locale("en", "US");
		if(request_locale.equals("zh_CN")){  
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);   
        }  
        else if(request_locale.equals("en_US")){     
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale2);  
        }
        else{  
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale1);  
        } 
		model.addAttribute("user_S",new Student());
		return "login";
	}
	
	//为初始化界面准备
	@RequestMapping(value = "/firstLogin") 								//登录界面
	public String login(Model model) {
		logger.info("login"); 											//日志打印？
		model.addAttribute("user_S",new Student());
		return "/login";
	}
	
	@RequestMapping(value = "/firstLogin_V")          					   //登录验证
	public String login_V(@ModelAttribute("user_S") Student student,
			HttpSession session,Model model) { //获取已登录用户，并将其放入model中，键值为user_S
		logger.info("login_V"); 									   //日志打印？
		if(loginservice.login_SV(student.getId(), student.getPassword())) {     			//判断输入的账号密码是否匹配
			Student stu = loginservice.getStudent(student.getId());    //获取登录成功的学生对象
			session.setAttribute(stu.getId(), stu);                    //保存登录成功的学生对象
			model.addAttribute("userID",stu.getId());                  //将登录成功的学生的ID传入前端，供获取，获取后通过ID获得登录成功的对象
			model.addAttribute("user_S",stu);
			return "redirect:loginSuccese";   						   //转登录成功界面
		}
		else {
			session.setAttribute(student.getId(), student);            //将登录失败的用户保存
			student.setPassword("");                                   //将密码重置
			model.addAttribute("userID",student.getId());        	   //将失败的ID传入前端
			return "redirect:loginFail";           					   //转登录失败界面
		}	
	}
	
	@RequestMapping(value = "/loginSuccese")       //登录成功
	public String login_seccse(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) { //@ModelAttribute获取页面中userID
		logger.info("login_succese"); //日志打印？
		Student stu = (Student)session.getAttribute(userID);     //通过userID获得登录成功的学生对象
		model.addAttribute("user_S",stu);                        //将登录成功的学生传入前端
		return "login_succese";
	}
	
	@RequestMapping(value = "/loginFail")         //登录失败
	public String login_fail(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) {
		logger.info("login_fail"); //日志打印？
		Student stu = (Student)session.getAttribute(userID);
		model.addAttribute("user_S",stu);
		return "login_fail";
	}
	
	@RequestMapping(value = "/show_information")      //查看信息
	public String show_information(@ModelAttribute("userID")String userID,
			Model model) {//超链接方式，通过URL占符位获取登录用户的ID，从而获取登录的用户
		logger.info("show_information"); 				   //日志打印？
		Student student = loginservice.getStudent(userID);
		model.addAttribute("user_S",student);                       		//将登录成功的学生传入前端
		model.addAttribute("userID",userID);
		return "myInformation";
	}
	
	@RequestMapping(value = "/backLoginSuccese/{id}")   //返回登录成功界面
	public ModelAndView backLoginSuccese(@PathVariable("id")String userID,
			HttpSession session,Model model,HttpServletRequest request) {
		Student stu = (Student)session.getAttribute(userID);     //通过userID获得登录成功的学生对象
		model.addAttribute("user_S",stu);                        //将登录成功的学生传入前端
		model.addAttribute("userID",userID);
		return new ModelAndView("redirect:/loginSuccese");
	}
	
	
	@RequestMapping(value = "/modify_password")     //修改密码
	public String modifyPassword(@ModelAttribute("userID")String userID,
			Model model,HttpSession session) {//超链接方式，通过URL占符位获取登录用户的ID，从而获取登录的用户
		logger.info("modify_password"); 				//日志打印？
		Student student = loginservice.getStudent(userID);
		model.addAttribute("user",student); 			//将登录成功的学生传入前端
		model.addAttribute("userID",userID);
		return "modifyPassword";                     	//修改密码界面
	}
	
	@RequestMapping(value = "/confirm")         //修改密码
	public void completeModify(Model model,HttpServletRequest request,
			HttpSession session,HttpServletResponse response) {
		logger.info("confirm"); //日志打印？
		String userID = request.getParameter("userID");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String news = loginservice.modifyPassword(userID, oldPassword, newPassword1, newPassword2);
		response.setContentType("text/html;charset=UTF-8");
		if(news.equals("修改密码成功！")){   //修改成功，返回登录成功界面
			try { 
				PrintWriter out = response.getWriter();
				out.print("<html><body><script type='text/javascript'>"
						+ "alert('"+news+"');"
						+ "window.history.back();"
						+ "window.history.back();"
						+ "</script></body></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {   //修改密码不成功，提示错误信息，返回修改界面
			try {
				PrintWriter out = response.getWriter();
				out.print("<html><body><script type='text/javascript'>"
						+ "alert('"+news+"');"
						+ "window.history.back();"
						+ "</script></body></html>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Student stu = loginservice.getStudent(userID);    //获取修改密码后的用户
		session.setAttribute(userID, stu);
		model.addAttribute("userID",userID);
	}
	
	@RequestMapping(value = "/exit")
	public String exit(@ModelAttribute("userID")String userID,
			Model model,HttpSession session){
		logger.info("exit"); //日志打印？
		System.out.println("exit-"+userID);
		session.setAttribute(userID,"");
		return "redirect:firstLogin";
	}
}












