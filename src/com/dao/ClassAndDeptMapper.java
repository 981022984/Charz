package com.dao;

import java.util.ArrayList;


public interface ClassAndDeptMapper {
	//��ȡһ��ϵ���а༶����
	public ArrayList<String> getAllClassName(String DeptNo);
	
	//��ȡ���е�ϵDeptName
	public ArrayList<String> getAllDeptName();
	
	//��ȡ��Ӧ(DeptName)ϵ��DeptNo
	public String getDeptNo(String DeptName);
}
