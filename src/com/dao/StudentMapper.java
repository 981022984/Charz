package com.dao;

import java.util.HashMap;
import java.util.List;

import com.model.Student;

public interface StudentMapper {
	//按学号查找学生
	public Student selectStudent(String id);
	
	//查找所有的学生信息
	public List<Student> selectAllStudent();
	
	//根据账号密码查询登录用户是否存在
	public Student selectLoginStudent(HashMap<String, Object> map);
	
	//根据账号，新密码修改密码
	public int updatePassword(HashMap<String, Object> map);
	
	//判断学号是否存在
	public String checkStudentNo(String id);
	
	//学生注册，新增用户
	public int addNewStudent(Student student);
}
