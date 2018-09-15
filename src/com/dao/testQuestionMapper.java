package com.dao;

import java.util.ArrayList;

import com.model.SC;
import com.model.testQuestion;

public interface testQuestionMapper {
	//������Ŀ��Ų�����Ŀ
	public ArrayList<testQuestion> selectTestQuestion(String tpNo);
	
	//�����Ծ�����ȡ�Ծ���
	public String selectTestPaperNo(String tpName);
	
	//������Գɼ�
	public int insertTestScore(SC sc);
	
	//��ȡ�Ծ�÷ַ���
	public String selectTestAnalysis(String tpNo);
	
	//��ѯѧ���Ƿ������Ծ�
	public int selectTestHasDone(SC sc);
}
