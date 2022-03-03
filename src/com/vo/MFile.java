package com.vo;

public class MFile {

	@Override
	public String toString() {
		return "MFile [fid=" + fid + ", fname=" + fname + ", frealname="
				+ frealname + ", fpath=" + fpath + ", fuid=" + fuid
				+ ", fuptime=" + fuptime + ", fsize=" + fsize + ", fdowntimes="
				+ fdowntimes + ", fsid=" + fsid + ", ftid=" + ftid
				+ ", fstate=" + fstate + "]";
	}
	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFrealname() {
		return frealname;
	}
	public void setFrealname(String frealname) {
		this.frealname = frealname;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public int getFuid() {
		return fuid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}
	public String getFuptime() {
		return fuptime;
	}
	public void setFuptime(String fuptime) {
		this.fuptime = fuptime;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	public int getFdowntimes() {
		return fdowntimes;
	}
	public void setFdowntimes(int fdowntimes) {
		this.fdowntimes = fdowntimes;
	}
	public int getFsid() {
		return fsid;
	}
	public void setFsid(int fsid) {
		this.fsid = fsid;
	}
	public int getFtid() {
		return ftid;
	}
	public void setFtid(int ftid) {
		this.ftid = ftid;
	}
	public int getFstate() {
		return fstate;
	}
	public void setFstate(int fstate) {
		this.fstate = fstate;
	}
	
	public MFile(int fid, String fname, String frealname, String fpath,
			int fuid, String fuptime, int fsize, int fdowntimes, int fsid,
			int ftid, int fstate) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.frealname = frealname;
		this.fpath = fpath;
		this.fuid = fuid;
		this.fuptime = fuptime;
		this.fsize = fsize;
		this.fdowntimes = fdowntimes;
		this.fsid = fsid;
		this.ftid = ftid;
		this.fstate = fstate;
	}
	public MFile(){}
	int fid;
	String fname;
	String frealname;
	String fpath;
	int fuid;
	String fuptime;
	int fsize;
	int fdowntimes;
	int fsid;
	int ftid;
	int fstate;
}
