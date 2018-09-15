package com.dao;

import java.util.HashMap;
import java.util.List;

import com.model.Student;

public interface StudentMapper {
	//��ѧ�Ų���ѧ��
	public Student selectStudent(String id);
	
	//�������е�ѧ����Ϣ
	public List<Student> selectAllStudent();
	
	//�����˺������ѯ��¼�û��Ƿ����
	public Student selectLoginStudent(HashMap<String, Object> map);
	
	//�����˺ţ��������޸�����
	public int updatePassword(HashMap<String, Object> map);
	
	//�ж�ѧ���Ƿ����
	public String checkStudentNo(String id);
	
	//ѧ��ע�ᣬ�����û�
	public int addNewStudent(Student student);
}
