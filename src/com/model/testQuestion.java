package com.model;

//试题信息类
public class testQuestion {
	private String tqNo;
	private String tpNo;
	private String tqName;
	private String tqOptions;
	private String tqScore;
	private String[] Options;   	//多个选项
	private String[] Scores;    	//选项分数权值
	public testQuestion() {
	}
	
	public testQuestion(String tqNo,String tpNo,String tqName,
			String tqOptions,String tqScore) {
		this.tqNo = tqNo;
		this.tpNo = tpNo;
		this.tqName = tqName;
		this.tqOptions = tqOptions;
		this.tqScore = tqScore;
	}
	
	public String getTqNo() {
		return this.tqNo;	
	}
	public void setTqNo(String tqNo) {
		this.tqNo = tqNo;
	}
	
	public String getTpNo() {
		return this.tpNo;	
	}
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	
	public String getTqName() {
		return this.tqName;	
	}
	public void setTqName(String tqName) {
		this.tqName = tqName;
	}
	
	public String getTqOptions() {
		return this.tqOptions;
	}
	
	public void setTqOptions(String tqOptions) {
		this.tqOptions = tqOptions;
	}
	
	public String getTqScore() {
		return this.tqScore;
	}
	
	public void setTqScore(String tqScore) {
		this.tqScore = tqScore;
	}
	
	public String[] getOptions() {
		return this.Options;
	}
	
	public void setOptions(String[] Options) {
		this.Options = Options;
	}
	
	public String[] getScores() {
		return this.Scores;
	}
	
	public void setScores(String[] Scores) {
		this.Scores = Scores;
	}
}





