package com.vo;

public class MUser {

	
	
	public MUser(String uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}

	public MUser(int uid, String upassword) {
		super();
		this.uid = uid;
		this.upassword = upassword;
	}

	@Override
	public String toString() {
		return "MUser [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", sid=" + sid + "]";
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public MUser(){}
	public MUser(int uid, String uname, String upassword, int sid) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.sid = sid;
	}
	private  int  uid;
	private String uname;
	private String upassword;
	private int sid;
	
	
}
