package com.vo;

public class MComment {

	@Override
	public String toString() {
		return "MComment [cid=" + cid + ", cuid=" + cuid + ", ccontent="
				+ ccontent + ", cfid=" + cfid + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCuid() {
		return cuid;
	}
	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public int getCfid() {
		return cfid;
	}
	public void setCfid(int cfid) {
		this.cfid = cfid;
	}
	public MComment(int cid, int cuid, String ccontent, int cfid) {
		super();
		this.cid = cid;
		this.cuid = cuid;
		this.ccontent = ccontent;
		this.cfid = cfid;
	}
	public MComment(){}
	private int cid;
	private int cuid;
	private String ccontent;
	private int cfid;
}
