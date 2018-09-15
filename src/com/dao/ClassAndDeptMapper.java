package com.dao;

import java.util.ArrayList;


public interface ClassAndDeptMapper {
	//获取一个系所有班级名称
	public ArrayList<String> getAllClassName(String DeptNo);
	
	//获取所有的系DeptName
	public ArrayList<String> getAllDeptName();
	
	//获取对应(DeptName)系的DeptNo
	public String getDeptNo(String DeptName);
}
