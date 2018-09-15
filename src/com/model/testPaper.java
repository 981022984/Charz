package com.model;


//试卷信息类
public class testPaper {
	private String tpNo;       //试卷编号	
	private String tpName;		//试卷名称
	private String tpAnalysis;	//试卷权值得分分析	
	
	public testPaper() {
	}
	
	public testPaper(String tpNo,String tpName,String tpAnalysis) {
		this.tpNo = tpNo;
		this.tpName = tpName;
		this.tpAnalysis = tpAnalysis;
	}
	
	public String getTpNo() {
		return this.tpNo;
	}
	
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	
	public String getTpName() {
		return this.tpName;
	}
	
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	
	public String getTpAnalysis() {
		return this.tpAnalysis;
	}
	
	public void setTpAnalysis(String tpAnalysis) {
		this.tpAnalysis = tpAnalysis;
	}
}










