package com.model;


//�Ծ���Ϣ��
public class testPaper {
	private String tpNo;       //�Ծ���	
	private String tpName;		//�Ծ�����
	private String tpAnalysis;	//�Ծ�Ȩֵ�÷ַ���	
	
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










