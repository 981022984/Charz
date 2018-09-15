package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentCRUD;
import com.model.Manager;
import com.model.Student;


/**
 * @author zuo
 * @time 2018��6��26��20:00:02
 * @version 1.0
 * �û����е�½���޸����룬ע�ᣬ�鿴��Ϣ�Ȳ�����ҵ���߼�
 */
public class loginServiceImpl implements loginService{
	private List<Manager> managers;
	
	//ע��StudentCRUD������ѧ����CRUD����
	@Resource(name="studentCRUD")        
	private StudentCRUD studentCRUD;
	
	//ѧ����¼��Ϣ���˺����룩�Ƿ�ƥ��
	public void sys() {
		System.out.println(studentCRUD);
	}
	
	@Override
	public boolean login_SV(String id, String password) {
		if(studentCRUD.checkLoginStudent(id, password)) {
			return true;
		}
		else
			return false;
	}
	
	//����Ա��¼��Ϣ(�˺�����)�Ƿ�ƥ�����
	@Override
	public boolean login_MV(Manager manager) {
		for(Manager v_manager:managers) {
			if(manager.getId().equals(v_manager.getId()) && 
			   manager.getPassword().equals(v_manager.getPassword()))
				return true;
		}
		return false;
	}
	
	//����ID��ȡѧ���û�
	@Override
	public Student getStudent(String id) {
		return studentCRUD.getOneStudent(id);
	}
	
	
	
	//ͨ��ID��ȡ����Ա�û�
	@Override
	public Manager getManager(String id) {
		for(Manager v_manager:managers) {
			if(id.equals(v_manager.getId()))
				return v_manager;
		}
		return null;
	}
	
	//�û��޸�������飬ԭ����Ҫ��ȷ������������Ҫƥ��
	@Override
	public String modifyPassword(String id,String oldPassword,String newPassword1,
			String newPassword2) {
		Student stu = studentCRUD.getOneStudent(id);
		if(newPassword1.equals("")) {
			return "�����������룡";
		}
		if(!stu.getPassword().equals(oldPassword)) {
			return "ԭ����������������룡";
		}	
		if(!newPassword1.equals(newPassword2)) {
			return "ǰ���������벻ƥ�䣬���������룡";
		}	
		if(stu.getPassword().equals(oldPassword) && newPassword1.equals(newPassword2) &&
				studentCRUD.userUpdatePassword(id, newPassword1)){
			return "�޸�����ɹ���";	
		}
		return "";
	}
	
	
	//�û�ע�����
	//����Ҫע����û������ȷ������
	@Override
	public boolean checkRegisterInformation(Student student,String password) {
		//�ж�Ԥע��id�Ƿ��Ѿ����ڣ�֮���ж����������Ƿ�ƥ��
		if(student.getPassword().equals(password) &&
				studentCRUD.userCheckStudentNo(student.getId())) {
			studentCRUD.userAddNewStudent(student);
			return true;
		}
		else 
			return false;
	}
}





