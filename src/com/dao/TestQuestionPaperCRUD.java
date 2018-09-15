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

//试卷试题增删查改
public class TestQuestionPaperCRUD {
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	//根据试卷编号获取试卷内试题
	public ArrayList<testQuestion> getTestQuestion(String tpNo){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestQuestion(tpNo);
		}finally {
			sqlSession.close();
		}
	}
	
	//根据试卷名获取试卷编号
	public String getTestPaperNo(String tpName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestPaperNo(tpName);
		}finally {
			sqlSession.close();
		}
	}
	
	//插入考试成绩
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
	
	//获取得分分析
	public String getTestAnalysis(String tpNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		testQuestionMapper mapper = sqlSession.getMapper(testQuestionMapper.class);
		try {
			return mapper.selectTestAnalysis(tpNo);
		}finally {
			sqlSession.close();
		}
	}
	
	//查询学生是否做过测试
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










