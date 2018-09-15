package com.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TestQuestionPaperCRUD;
import com.model.SC;
import com.model.testQuestion;


/**
 * @author Administrator
 * @time 2018��6��26��20:07:56
 * @version 1.0
 * �û����в��Ե�ҵ����
 */
public class TestServiceImpl implements TestService{
	
	@Resource(name="tqpc")
	private TestQuestionPaperCRUD tqpc;
	
	@Override
	public ArrayList<testQuestion> getQuestions(String tpNo){
		ArrayList<testQuestion> tlist = tqpc.getTestQuestion(tpNo);
		if(tlist.isEmpty()) {
			return null;
		}
		for(testQuestion tq:tlist) {
			tq.setOptions(tq.getTqOptions().split(";"));
			tq.setScores(tq.getTqScore().split(";"));
		}
		return tlist;
	}
	
	@Override
	public String getPaperNo(String tpName) {
		return tqpc.getTestPaperNo(tpName);
	}
	
	@Override
	public void saveTestScore(String Sno, String tpNo, int score) {
		SC sc = new SC(Sno, tpNo, ""+score);
		tqpc.intoTestScore(sc);
	}
	
	@Override
	public String getAnalysis(String tpNo) {
		return tqpc.getTestAnalysis(tpNo);
	}
	
	@Override
	public boolean checkTestAgain(String Sno, String tpNo) {
		SC sc = new SC(Sno,tpNo);
		if(tqpc.getTestHasDone(sc)==0) {  //û���������ԣ����Խ��в���
			return true;
		}
		else {  //�Ѿ����Թ����ܽ��в���
			return false;
		}
	}
}
