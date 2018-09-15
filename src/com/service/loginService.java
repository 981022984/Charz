package com.service;

import com.model.Student;


import com.model.Manager;

public interface loginService {
	boolean login_SV(String id,String password); //学生登录账号密码匹配判断
	boolean login_MV(Manager manager);           //管理员登录账号密码匹配判断
	Student getStudent(String id);               //获取用户-学生
	Manager getManager(String id);               //获取用户-管理员
	String modifyPassword(String id,String oldPassword,
			String newPassword1,String newPassword2); 				//修改密码
	boolean checkRegisterInformation(Student student,String password);            	//注册信息检查
}
