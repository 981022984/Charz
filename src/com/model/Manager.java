package com.model;

import java.io.Serializable;
import java.util.Date;

public class Manager extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Manager() {
	}
	
	public Manager(String id,String password,String name) {
		super(id,password,name);
		
	}
	
	public Manager(String id,String password,String name,Date birthday) {
		super(id,password,name,birthday);
		
	}
}




