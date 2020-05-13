package com.ct.app.model;

public class DataTable {

	private Integer subject;
	private Double time;
	private Double cp;
	
	public DataTable(Integer subject, Double time, Double cp) {
		super();
		this.subject = subject;
		this.time = time;
		this.cp = cp;
	}
	
	public DataTable() {
		super();
	}

	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	public Double getCp() {
		return cp;
	}
	public void setCp(Double cp) {
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return "DataTable [subject=" + subject + ", time=" + time + ", cp=" + cp + "]";
	}
	
}
