package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentCRUD;
import com.model.Manager;
import com.model.Student;


/**
 * @author zuo
 * @time 2018年6月26日20:00:02
 * @version 1.0
 * 用户进行登陆，修改密码，注册，查看信息等操作的业务逻辑
 */
public class loginServiceImpl implements loginService{
	private List<Manager> managers;
	
	//注入StudentCRUD来调用学生的CRUD操作
	@Resource(name="studentCRUD")        
	private StudentCRUD studentCRUD;
	
	//学生登录信息（账号密码）是否匹配
	public void sys() {
		System.out.println(studentCRUD);
	}
	
	@Override
	public boolean login_SV(String id, String password) {
		if(studentCRUD.checkLoginStudent(id, password)) {
			return true;
		}
		else
			return false;
	}
	
	//管理员登录信息(账号密码)是否匹配检验
	@Override
	public boolean login_MV(Manager manager) {
		for(Manager v_manager:managers) {
			if(manager.getId().equals(v_manager.getId()) && 
			   manager.getPassword().equals(v_manager.getPassword()))
				return true;
		}
		return false;
	}
	
	//根据ID获取学生用户
	@Override
	public Student getStudent(String id) {
		return studentCRUD.getOneStudent(id);
	}
	
	
	
	//通过ID获取管理员用户
	@Override
	public Manager getManager(String id) {
		for(Manager v_manager:managers) {
			if(id.equals(v_manager.getId()))
				return v_manager;
		}
		return null;
	}
	
	//用户修改密码检验，原密码要正确，两次新密码要匹配
	@Override
	public String modifyPassword(String id,String oldPassword,String newPassword1,
			String newPassword2) {
		Student stu = studentCRUD.getOneStudent(id);
		if(newPassword1.equals("")) {
			return "请输入新密码！";
		}
		if(!stu.getPassword().equals(oldPassword)) {
			return "原密码错误，请重新输入！";
		}	
		if(!newPassword1.equals(newPassword2)) {
			return "前后两次密码不匹配，请重新输入！";
		}	
		if(stu.getPassword().equals(oldPassword) && newPassword1.equals(newPassword2) &&
				studentCRUD.userUpdatePassword(id, newPassword1)){
			return "修改密码成功！";	
		}
		return "";
	}
	
	
	//用户注册检验
	//传入要注册的用户对象和确认密码
	@Override
	public boolean checkRegisterInformation(Student student,String password) {
		//判断预注册id是否已经存在，之后判断两次密码是否匹配
		if(student.getPassword().equals(password) &&
				studentCRUD.userCheckStudentNo(student.getId())) {
			studentCRUD.userAddNewStudent(student);
			return true;
		}
		else 
			return false;
	}
}





