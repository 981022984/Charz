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



//异步请求提交，局部刷新实现的后端控制器
/**
 * 功能：界面异步请求处理Controller
 * @author zuo
 * @time 2018年6月26日19:51:11
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/json")
public class localController {
	@Resource(name="loginservice")
    private loginServiceImpl loginservice;
	
	//注入一个ClassAndDept对象
	@Resource(name="classAndDept")
	private ClassAndDept classAndDept;
	
	
	@RequestMapping("/showCategory")
	@ResponseBody
	public void showCategory(Student student,HttpServletResponse response) 
			throws JsonGenerationException,JsonMappingException,IOException {
		ObjectMapper mapper = new ObjectMapper();
		Student stu = loginservice.getStudent(student.getId()); //通过异步请求传过来的JSON对象（与Student匹配了）的id获取用户对象
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(stu));
	}
	
	//根据选择的系修改对应班级选项
	@RequestMapping("/showDeptClass") 
	@ResponseBody
	public void showClass(HttpServletRequest request,HttpServletResponse response) 
			throws JsonGenerationException, JsonMappingException, IOException {
		String DeptName = request.getParameter("DeptName");
		ArrayList<String> clist = classAndDept.userGetAllClassName(classAndDept.userGetDeptNo(DeptName));//根据用户选择的系获取该系所有的班级名称
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=clist.size()-1;i++) {     //将查找到对应系的班级放在HashMap中，便于前端处理
			map.put(""+i, clist.get(i));
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
}
