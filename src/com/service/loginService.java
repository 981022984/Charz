package com.service;

import com.model.Student;


import com.model.Manager;

public interface loginService {
	boolean login_SV(String id,String password); //ѧ����¼�˺�����ƥ���ж�
	boolean login_MV(Manager manager);           //����Ա��¼�˺�����ƥ���ж�
	Student getStudent(String id);               //��ȡ�û�-ѧ��
	Manager getManager(String id);               //��ȡ�û�-����Ա
	String modifyPassword(String id,String oldPassword,
			String newPassword1,String newPassword2); 				//�޸�����
	boolean checkRegisterInformation(Student student,String password);            	//ע����Ϣ���
}
