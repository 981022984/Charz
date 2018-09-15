package com.dao;

import java.util.ArrayList;

import com.model.SC;
import com.model.testQuestion;

public interface testQuestionMapper {
	//根据题目编号查找题目
	public ArrayList<testQuestion> selectTestQuestion(String tpNo);
	
	//根据试卷名获取试卷编号
	public String selectTestPaperNo(String tpName);
	
	//插入测试成绩
	public int insertTestScore(SC sc);
	
	//获取试卷得分分析
	public String selectTestAnalysis(String tpNo);
	
	//查询学生是否做过试卷
	public int selectTestHasDone(SC sc);
}
