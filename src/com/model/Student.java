package com.model;

import java.io.Serializable;
import java.util.Date;

public class Student extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ClassName;
	private String  DeptName;
	//构造函数1
	public Student() {
	}
	
	//构造函数2，通过id,密码，姓名，班级，系别创建学生对象
	public Student(String id,String password,String name,String ClassName,String DeptName) {
		super(id,password,name);
		this.ClassName = ClassName;
		this.DeptName = DeptName;
	}
	
	//构造函数2，通过id,密码，姓名，专业，身份，出生日期创建新对象
	public Student(String id,String password,String name,Date birthday,String ClassName,String DeptName) {
		super(id,password,name,birthday);
		this.ClassName = ClassName;
		this.DeptName = DeptName;
	}
	
	//构造函数3，根据id，密码，出生日期创建新的对象
	public Student(String id,String password,Date birthday) {
		super(id,password,birthday);
	}
	
	public String getDeptName() {
		return DeptName;
	}
	
	public void setDeptName(String DeptName) {
		this.DeptName = DeptName;
	}
	
	public String getClassName() {
		return ClassName;
	}
	
	public void setClassName(String ClassName) {
		this.ClassName = ClassName;
	}
}