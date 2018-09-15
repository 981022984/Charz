package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ClassAndDept{
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
 	
 	
	
	//��ȡ���еİ༶
 	public ArrayList<String> userGetAllClassName(String DeptNo) {
 		
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		ClassAndDeptMapper mapper = sqlSession.getMapper(ClassAndDeptMapper.class);
 		try {
 			return mapper.getAllClassName(DeptNo);
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//��ȡ���е�ϵ����Ϣ
 	public ArrayList<String> userGetAllDeptName(){
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		ClassAndDeptMapper mapper = sqlSession.getMapper(ClassAndDeptMapper.class);
 		try {
 			return mapper.getAllDeptName();
 		}finally {
 			sqlSession.close();
 		}
 	}
 	
 	//��ȡ��Ӧ��DeptNo
 	public String userGetDeptNo(String DeptName) {
 		SqlSession sqlSession = sqlSessionFactory.openSession();
 		ClassAndDeptMapper mapper = sqlSession.getMapper(ClassAndDeptMapper.class);
 		try {
 			return mapper.getDeptNo(DeptName);
 		}finally {
 			sqlSession.close();
 		}
 	}

}








