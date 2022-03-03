package com.vo;

public class MType {

	@Override
	public String toString() {
		return "MType [tid=" + tid + ", tname=" + tname + "]";
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public MType(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public MType(){}
	private int tid;
	private String tname;
	
}
