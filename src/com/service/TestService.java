package com.service;

import java.util.ArrayList;

import com.model.testQuestion;

public interface TestService {
	public ArrayList<testQuestion> getQuestions(String tpNo);      //��ȡ��������
	
	public String getPaperNo(String tpName);        //��ȡ�����Ծ���
	
	//����ѧ�����Գɼ�
	public void saveTestScore(String Sno, String tpNo, int score); 
	
	//��ȡ���Ե÷ַ���
	public String getAnalysis(String tpNo);
	
	//�ж�ѧ���Ƿ���������
	public boolean checkTestAgain(String Sno, String tpNo);
	
}
