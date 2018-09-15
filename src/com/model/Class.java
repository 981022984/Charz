package com.model;

public class Class {
	private String ClassNo;
	private String DeptNo;
	private String ClassName;
	
	public Class() {
	}
	
	public Class(String ClassNo, String DeptNo, String ClassName) {
		this.ClassNo = ClassNo;
		this.ClassName = ClassName;
		this.DeptNo = DeptNo;
	}
	
	public String getClassNo() {
		return ClassNo;
	}
	
	public void setClassNo(String ClassNo) {
		this.ClassNo = ClassNo;
	}
	
	public String getClassName() {
		return ClassName;
	}
	
	public void setClassName(String ClassName) {
		this.ClassName = ClassName;
	}
	
	public String getDeptNo() {
		return DeptNo;
	}
	
	public void setDeptNo(String DeptNo) {
		this.DeptNo = DeptNo;
	}
}
