package com.model;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component(value="user")
public class User {
	private String id;
	private String password;
	private String name;
	private Date birthday;
	
	public User() {
		
	}
	
	public User(String id,String password,String name,Date birthday) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
	}
	
	public User(String id,String password,Date birthday) {
		this.id = id;
		this.password = password;
	}
	
	public User(String id,String password,String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	} 
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void add() {
		System.out.println("SpringIoC");
	}
}
