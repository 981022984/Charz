package com.model;

public class SC {
	private String Sno;
	private String tpNo;
	private String score;
	
	public SC() {
	}
	
	public SC(String Sno,String tpNo,String score) {
		this.Sno = Sno;
		this.tpNo = tpNo;
		this.score = score;
	}
	
	public SC(String Sno,String tpNo) {
		this.Sno = Sno;
		this.tpNo = tpNo;
	}
	
	public String getSno() {
		return Sno;
	}
	
	public void set(String Sno) {
		this.Sno = Sno;
	}
	
	public String gettpNo() {
		return tpNo;
	}
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
