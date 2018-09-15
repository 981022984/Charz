package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.loginService;
import com.service.loginServiceImpl;
import com.dao.ClassAndDept;
import com.model.Student;
import com.validator.studentValidator;



/**
 * @author Administrator
 * @time 2018年6月27日14:34:35
 * @version 1.0
 * 功能：注册处理
 */
@Controller
public class registerController {
	//注入一个loginServiceImpl对象
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;
	//注入一个ClassAndDept类型对象
	@Resource(name="classAndDept")   
	private ClassAndDept classAndDept;
	
	//注入校验器对象
	@Autowired         
	@Qualifier("studentValidator")
	private studentValidator stuV;
	
	//转到注册界面
	@RequestMapping(value = "/userRegister")
	public String userRegister(Model model) {
		ArrayList<String> clist = classAndDept.userGetAllClassName("1001");
		ArrayList<String> dlist = classAndDept.userGetAllDeptName();
		model.addAttribute("Class",clist);
		model.addAttribute("Dept",dlist);
		model.addAttribute("newUser",new Student());
		return "userRegister";
	}
	
	//检验注册信息，通过则跳转登录界面，没通过则跳回注册界面重新输入
	@RequestMapping(value = "/addNewUser")
	public String addNewUser(@ModelAttribute("newUser") Student student,Model model,
			HttpServletRequest request,Errors errors) {
		model.addAttribute("user_S",student);
		stuV.validate(student, errors);  //校验器调用
		if(errors.hasErrors()) {
			/*model.addAttribute("Class",clist);
			model.addAttribute("Dept",dlist);*/
			return "userRegister";        //校验没通过，停留在注册页面
		}
		String password = request.getParameter("userPassword2");
		if(loginservice.checkRegisterInformation(student, password)) {
			return "login";
		}
		return "";
	}
}
