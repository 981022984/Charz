package com.dao;


import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.model.Student;

//ѧ������ɾ���
//ʵ���˵���ģʽ����SqlSessionFactory(?)
public class StudentCRUD {
	//ע�����ԣ�Ϊһ��SqlSessionFactory���������ļ�������idΪsqlSessionFactory
	@Resource(name="sqlSessionFactory")     
	private SqlSessionFactory sqlSessionFactory;
 	
 	//ͨ���˺�������֤��¼�û��Ƿ�Ϸ�
 	public boolean checkLoginStudent(String id, String password) {
 		HashMap<String, Object> map = new HashMap<String, Object>();
 		map.put("id", id);
 		map.put("password", password);
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			if(mapper.selectLoginStudent(map)!=null)    //��Ӧѧ�š������ѧ�����ڣ����Ե�¼
 				return true;
 			else 
 				return false;
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//��ȡ����ѧ��
 	public List<Student> getAllStudent(){
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);	
 			return mapper.selectAllStudent();      //��������ѧ���ļ���
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//����ѧ�Ż�ȡĳһ��ѧ��
 	public Student getOneStudent(String id) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			return mapper.selectStudent(id);     //���ض�Ӧѧ�ŵ�ѧ��
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//����ѧ�����������޸�����
 	public boolean userUpdatePassword(String id, String password) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		HashMap<String, Object> map = new HashMap<String, Object>();
 		map.put("id", id);
 		map.put("password", password);
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			if(mapper.updatePassword(map) == 0) {             //�޸�ʧ��
 				return false;
 			}	
 			else if(mapper.updatePassword(map) == 1) {        //�޸ĳɹ� 
 				return true;	
 			}					
 			else 
 				return false;
 		}finally {
 			sqlSession.commit();
 			sqlSession.close();
 		}
 	}
 	
 	//�ж�ѧ���Ƿ����
 	public boolean userCheckStudentNo(String id) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 		try {
 			if(mapper.checkStudentNo(id)!=null)     //ѧ���Ѵ��ڲ���ע��
 				return false;
 			else 
 				return true;
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//�������û���Ϣ
 	public boolean userAddNewStudent(Student student) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 		try {
 			if(mapper.addNewStudent(student) == 1)
 				return true;
 			else 
 				return false;
 		}finally {
 			sqlSession.commit();
 			sqlSession.close();
 		}
 	}
}
