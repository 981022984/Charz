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
 * @time 2018��6��27��14:34:35
 * @version 1.0
 * ���ܣ�ע�ᴦ��
 */
@Controller
public class registerController {
	//ע��һ��loginServiceImpl����
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;
	//ע��һ��ClassAndDept���Ͷ���
	@Resource(name="classAndDept")   
	private ClassAndDept classAndDept;
	
	//ע��У��������
	@Autowired         
	@Qualifier("studentValidator")
	private studentValidator stuV;
	
	//ת��ע�����
	@RequestMapping(value = "/userRegister")
	public String userRegister(Model model) {
		ArrayList<String> clist = classAndDept.userGetAllClassName("1001");
		ArrayList<String> dlist = classAndDept.userGetAllDeptName();
		model.addAttribute("Class",clist);
		model.addAttribute("Dept",dlist);
		model.addAttribute("newUser",new Student());
		return "userRegister";
	}
	
	//����ע����Ϣ��ͨ������ת��¼���棬ûͨ��������ע�������������
	@RequestMapping(value = "/addNewUser")
	public String addNewUser(@ModelAttribute("newUser") Student student,Model model,
			HttpServletRequest request,Errors errors) {
		model.addAttribute("user_S",student);
		stuV.validate(student, errors);  //У��������
		if(errors.hasErrors()) {
			/*model.addAttribute("Class",clist);
			model.addAttribute("Dept",dlist);*/
			return "userRegister";        //У��ûͨ����ͣ����ע��ҳ��
		}
		String password = request.getParameter("userPassword2");
		if(loginservice.checkRegisterInformation(student, password)) {
			return "login";
		}
		return "";
	}
}
