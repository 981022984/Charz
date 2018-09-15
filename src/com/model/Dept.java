package com.model;

public class Dept {
	private String DeptNo;
	private String DeptName;
	
	public Dept() {
	}
	
	public Dept(String DeptNo, String DeptName) {
		this.DeptNo = DeptNo;
		this.DeptName = DeptName;
	}
	
	public String getDeptNo() {
		return DeptNo;
	}
	
	public void setDeptNo(String DeptNo) {
		this.DeptNo = DeptNo;
	}
	
	public String getDeptName() {
		return DeptName;
	}
	
	public void setDeptName(String DeptName) {
		this.DeptName = DeptName;
	}
}
