package com.service;

import java.util.ArrayList;

import com.model.testQuestion;

public interface TestService {
	public ArrayList<testQuestion> getQuestions(String tpNo);      //获取测试试题
	
	public String getPaperNo(String tpName);        //获取测试试卷编号
	
	//插入学生测试成绩
	public void saveTestScore(String Sno, String tpNo, int score); 
	
	//获取测试得分分析
	public String getAnalysis(String tpNo);
	
	//判断学生是否做过测试
	public boolean checkTestAgain(String Sno, String tpNo);
	
}
