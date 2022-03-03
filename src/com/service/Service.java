package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.mapper.IType;
import com.mapper.IUser;
import com.vo.MComment;
import com.vo.MFile;
import com.vo.MType;
import com.vo.MUser;


public class Service {

	public Service() {
		
	}



	private   SqlSession session=null;
	private  IUser IUserDAO;
	private  IType ITypeDAO;
	


	
	public void init(){
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybatis_config.xml");
			//2.使用is输入流 创建SessionFactory
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//3.创建数据库链接
			session = build.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取文件
	
		
	}

	public void destory(){
		if(session!=null){
			session.close();
		}
	}
	
	
	
	// 登录 验证密码是否正确
	public  int SignIn(MUser muser){
		init();
		if(session!=null){
			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			
			String RelUserPassword=IUserDAO.selectPasswordByUid(muser.getUid());
			
			System.out.println("输入"+muser.getUpassword());
			System.out.println("密码"+RelUserPassword);
			
			if(muser.getUpassword().equals(RelUserPassword)){
				res=1;
			}else{
				res=-1;
			}
			session.commit();
			return res;	
		}
		destory();
		return -2;
	}
	
	// 减少数据库中空间大小
	public  int ChangeSpace(int uid, int reducesize){
		init();
		if(session!=null){
			System.out.println("输入"+uid);
			System.out.println("大小"+reducesize);
			
			int res=1;
			IUserDAO = session.getMapper(IUser.class);
			
			try {
				IUserDAO.ChangeSpaceByUid(uid,  reducesize);
			} catch (Exception e) {
				// TODO: handle exception
				res=-1;
			}
			
			
			session.commit();
			return res;	
		}
		destory();
		return -2;
	}
	
	// 回复数据库中空间大小
	public  int ChangeSpacePlus(int uid, int plussize){
		init();
		if(session!=null){
			System.out.println("输入"+uid);
			System.out.println("大小"+plussize);
			
			int res=1;
			IUserDAO = session.getMapper(IUser.class);
			
			try {
				IUserDAO.ChangeSpacePlus(uid,  plussize);
			} catch (Exception e) {
				// TODO: handle exception
				res=-1;
			}
			
			
			session.commit();
			return res;	
		}
		destory();
		return -2;
	}
	
	// 增加数据库中文件记录
	public  int ChangeFile(String newname,String fname,String fullname,int uid,String uptime,int filesize,int ftid){
		init();
		if(session!=null){

			
			
			int res=1;
			IUserDAO = session.getMapper(IUser.class);
			int fsid=IUserDAO.querrysid(uid);
			
				IUserDAO.ChangeFile(newname,fname,fullname,uid,uptime,filesize,fsid,ftid);
			
			System.out.println("service里接受"+newname);
			System.out.println("service里接受"+fname);
			System.out.println("service里接受"+fullname);
			System.out.println("service里接受"+uid);
			System.out.println("service里接受"+uptime);
			System.out.println("service里接受"+filesize);
			System.out.println("service里接受"+fsid);
			System.out.println("service里接受"+ftid);
			
			session.commit();
			return res;	
		}
		destory();
		return -2;
	}
	// 查询数据库中type
	public  List<MType> QuerryType(){
		init();
		if(session!=null){

			List<MType> res=new  ArrayList<MType>();
			
			ITypeDAO = session.getMapper(IType.class);
			
			
			res=ITypeDAO.QuerryType();
			System.out.println("service查询结果"+res.toString());

			session.commit();
			return res;	
		}
		destory();
		return null;
	}

	// 查询remainspace
	public  int Remain(int uid){
		init();
		if(session!=null){

			int res=0;
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.Remain(uid);
			System.out.println("service查询结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//查数据库所有文件
	public List<MFile> QuerryAllFile() {
		init();
		if(session!=null){

			List<MFile> res=new  ArrayList<MFile>();
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.QuerryAllFile();
			System.out.println("service查询结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return null;
	}
	//查此文件状态
	public int QuerryFileState(int fid) {
		init();
		if(session!=null){

			IUserDAO = session.getMapper(IUser.class);

			int res=IUserDAO.QuerryFileState(fid);
			
			System.out.println("service查询文件状态结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return -1;
	}
	//查此文件大小
	public int QuerryFileSize(int fid) {
		init();
		if(session!=null){

			IUserDAO = session.getMapper(IUser.class);

			int res=IUserDAO.QuerryFileSize(fid);
			
			System.out.println("service查询文件大小结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return -1;
	}
	
//冻结or解冻
	public int freeze(int fid) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			//先查询文件状态
			int res1=QuerryFileState(fid);
			if(res1==1){
				IUserDAO.freeze(fid);
				res=1;
				System.out.println("service冻结更改结果"+res);
			}else if (res1==0) {
				IUserDAO.NOfreeze(fid);
				res=1;
				System.out.println("service解冻更改结果"+res);
			}else{
				System.out.println("service冻错误"+res);
				res=-1;
			}

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//增加下载次数
	public int AddDownCount(String fid) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			
			IUserDAO.AddDownCount(fid);

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}
	//评论解冻
	public int NOfreeze(int fid,int uid, String acomment) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
		
				IUserDAO.NOfreeze(fid);
				res=1;
				System.out.println("service解冻更改结果"+res);
			
				IUserDAO.addcomment(uid,acomment,fid);
				res=2;
				System.out.println("service解冻更改结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//查评论
	public List<MComment> QuerryAllComments() {
		init();
		if(session!=null){

			List<MComment> res=new  ArrayList<MComment>();
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.QuerryAllComments();
			System.out.println("service查询结果"+res);

			session.commit();
			return res;	
		}
		destory();
		return null;
	}

	//删除文件
	public int mydelete(int fid) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			
				IUserDAO.mydelete(fid);
				res=1;
				System.out.println("service删除结果"+res);
			

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}
}
