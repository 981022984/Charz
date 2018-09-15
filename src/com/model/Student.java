package com.model;

import java.io.Serializable;
import java.util.Date;

public class Student extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ClassName;
	private String  DeptName;
	//���캯��1
	public Student() {
	}
	
	//���캯��2��ͨ��id,���룬�������༶��ϵ�𴴽�ѧ������
	public Student(String id,String password,String name,String ClassName,String DeptName) {
		super(id,password,name);
		this.ClassName = ClassName;
		this.DeptName = DeptName;
	}
	
	//���캯��2��ͨ��id,���룬������רҵ����ݣ��������ڴ����¶���
	public Student(String id,String password,String name,Date birthday,String ClassName,String DeptName) {
		super(id,password,name,birthday);
		this.ClassName = ClassName;
		this.DeptName = DeptName;
	}
	
	//���캯��3������id�����룬�������ڴ����µĶ���
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