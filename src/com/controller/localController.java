package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.model.Student;
import com.dao.ClassAndDept;
import com.service.loginServiceImpl;



//�첽�����ύ���ֲ�ˢ��ʵ�ֵĺ�˿�����
/**
 * ���ܣ������첽������Controller
 * @author zuo
 * @time 2018��6��26��19:51:11
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/json")
public class localController {
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;
	
	//ע��һ��ClassAndDept����
	@Resource(name="classAndDept")
	private ClassAndDept classAndDept;
	
	
	@RequestMapping("/showCategory")
	@ResponseBody
	public void showCategory(Student student,HttpServletResponse response) 
			throws JsonGenerationException,JsonMappingException,IOException {
		ObjectMapper mapper = new ObjectMapper();
		Student stu = loginservice.getStudent(student.getId()); //ͨ���첽���󴫹�����JSON������Studentƥ���ˣ���id��ȡ�û�����
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(stu));
	}
	
	//����ѡ���ϵ�޸Ķ�Ӧ�༶ѡ��
	@RequestMapping("/showDeptClass") 
	@ResponseBody
	public void showClass(HttpServletRequest request,HttpServletResponse response) 
			throws JsonGenerationException, JsonMappingException, IOException {
		String DeptName = request.getParameter("DeptName");
		ArrayList<String> clist = classAndDept.userGetAllClassName(classAndDept.userGetDeptNo(DeptName));//�����û�ѡ���ϵ��ȡ��ϵ���еİ༶����
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=clist.size()-1;i++) {     //�����ҵ���Ӧϵ�İ༶����HashMap�У�����ǰ�˴���
			map.put(""+i, clist.get(i));
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
}
