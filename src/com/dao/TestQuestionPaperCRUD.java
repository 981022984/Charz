package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.model.SC;
import com.model.testQuestion;

//�Ծ�������ɾ���
public class TestQuestionPaperCRUD {
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	//�����Ծ��Ż�ȡ�Ծ�������
	public ArrayList<testQuestion> getTestQuestion(String tpNo){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestQuestion(tpNo);
		}finally {
			sqlSession.close();
		}
	}
	
	//�����Ծ�����ȡ�Ծ���
	public String getTestPaperNo(String tpName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestPaperNo(tpName);
		}finally {
			sqlSession.close();
		}
	}
	
	//���뿼�Գɼ�
	public int intoTestScore(SC sc) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.insertTestScore(sc);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	//��ȡ�÷ַ���
	public String getTestAnalysis(String tpNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestAnalysis(tpNo);
		}finally {
			sqlSession.close();
		}
	}
	
	//��ѯѧ���Ƿ���������
	public int getTestHasDone(SC sc) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestHasDone(sc);
		}finally {
			sqlSession.close();
		}
	}
}










