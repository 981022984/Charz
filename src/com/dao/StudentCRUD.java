package com.dao;


import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.model.Student;

//学生的增删查改
//实现了单例模式管理SqlSessionFactory(?)
public class StudentCRUD {
	//注入属性，为一个SqlSessionFactory，由配置文件创建，id为sqlSessionFactory
	@Resource(name="sqlSessionFactory")     
	private SqlSessionFactory sqlSessionFactory;
 	
 	//通过账号密码验证登录用户是否合法
 	public boolean checkLoginStudent(String id, String password) {
 		HashMap<String, Object> map = new HashMap<String, Object>();
 		map.put("id", id);
 		map.put("password", password);
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			if(mapper.selectLoginStudent(map)!=null)    //对应学号、密码的学生存在，可以登录
 				return true;
 			else 
 				return false;
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//获取所有学生
 	public List<Student> getAllStudent(){
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);	
 			return mapper.selectAllStudent();      //返回所有学生的集合
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//根据学号获取某一个学生
 	public Student getOneStudent(String id) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			return mapper.selectStudent(id);     //返回对应学号的学生
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//根据学号与新密码修改密码
 	public boolean userUpdatePassword(String id, String password) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		HashMap<String, Object> map = new HashMap<String, Object>();
 		map.put("id", id);
 		map.put("password", password);
 		try {
 			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 			if(mapper.updatePassword(map) == 0) {             //修改失败
 				return false;
 			}	
 			else if(mapper.updatePassword(map) == 1) {        //修改成功 
 				return true;	
 			}					
 			else 
 				return false;
 		}finally {
 			sqlSession.commit();
 			sqlSession.close();
 		}
 	}
 	
 	//判断学号是否存在
 	public boolean userCheckStudentNo(String id) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 		try {
 			if(mapper.checkStudentNo(id)!=null)     //学号已存在不能注册
 				return false;
 			else 
 				return true;
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//插入新用户信息
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
