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
			//2.ʹ��is������ ����SessionFactory
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			//3.�������ݿ�����
			session = build.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ȡ�ļ�
	
		
	}

	public void destory(){
		if(session!=null){
			session.close();
		}
	}
	
	
	
	// ��¼ ��֤�����Ƿ���ȷ
	public  int SignIn(MUser muser){
		init();
		if(session!=null){
			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			
			String RelUserPassword=IUserDAO.selectPasswordByUid(muser.getUid());
			
			System.out.println("����"+muser.getUpassword());
			System.out.println("����"+RelUserPassword);
			
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
	
	// �������ݿ��пռ��С
	public  int ChangeSpace(int uid, int reducesize){
		init();
		if(session!=null){
			System.out.println("����"+uid);
			System.out.println("��С"+reducesize);
			
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
	
	// �ظ����ݿ��пռ��С
	public  int ChangeSpacePlus(int uid, int plussize){
		init();
		if(session!=null){
			System.out.println("����"+uid);
			System.out.println("��С"+plussize);
			
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
	
	// �������ݿ����ļ���¼
	public  int ChangeFile(String newname,String fname,String fullname,int uid,String uptime,int filesize,int ftid){
		init();
		if(session!=null){

			
			
			int res=1;
			IUserDAO = session.getMapper(IUser.class);
			int fsid=IUserDAO.querrysid(uid);
			
				IUserDAO.ChangeFile(newname,fname,fullname,uid,uptime,filesize,fsid,ftid);
			
			System.out.println("service�����"+newname);
			System.out.println("service�����"+fname);
			System.out.println("service�����"+fullname);
			System.out.println("service�����"+uid);
			System.out.println("service�����"+uptime);
			System.out.println("service�����"+filesize);
			System.out.println("service�����"+fsid);
			System.out.println("service�����"+ftid);
			
			session.commit();
			return res;	
		}
		destory();
		return -2;
	}
	// ��ѯ���ݿ���type
	public  List<MType> QuerryType(){
		init();
		if(session!=null){

			List<MType> res=new  ArrayList<MType>();
			
			ITypeDAO = session.getMapper(IType.class);
			
			
			res=ITypeDAO.QuerryType();
			System.out.println("service��ѯ���"+res.toString());

			session.commit();
			return res;	
		}
		destory();
		return null;
	}

	// ��ѯremainspace
	public  int Remain(int uid){
		init();
		if(session!=null){

			int res=0;
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.Remain(uid);
			System.out.println("service��ѯ���"+res);

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//�����ݿ������ļ�
	public List<MFile> QuerryAllFile() {
		init();
		if(session!=null){

			List<MFile> res=new  ArrayList<MFile>();
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.QuerryAllFile();
			System.out.println("service��ѯ���"+res);

			session.commit();
			return res;	
		}
		destory();
		return null;
	}
	//����ļ�״̬
	public int QuerryFileState(int fid) {
		init();
		if(session!=null){

			IUserDAO = session.getMapper(IUser.class);

			int res=IUserDAO.QuerryFileState(fid);
			
			System.out.println("service��ѯ�ļ�״̬���"+res);

			session.commit();
			return res;	
		}
		destory();
		return -1;
	}
	//����ļ���С
	public int QuerryFileSize(int fid) {
		init();
		if(session!=null){

			IUserDAO = session.getMapper(IUser.class);

			int res=IUserDAO.QuerryFileSize(fid);
			
			System.out.println("service��ѯ�ļ���С���"+res);

			session.commit();
			return res;	
		}
		destory();
		return -1;
	}
	
//����or�ⶳ
	public int freeze(int fid) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			//�Ȳ�ѯ�ļ�״̬
			int res1=QuerryFileState(fid);
			if(res1==1){
				IUserDAO.freeze(fid);
				res=1;
				System.out.println("service������Ľ��"+res);
			}else if (res1==0) {
				IUserDAO.NOfreeze(fid);
				res=1;
				System.out.println("service�ⶳ���Ľ��"+res);
			}else{
				System.out.println("service������"+res);
				res=-1;
			}

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//�������ش���
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
	//���۽ⶳ
	public int NOfreeze(int fid,int uid, String acomment) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
		
				IUserDAO.NOfreeze(fid);
				res=1;
				System.out.println("service�ⶳ���Ľ��"+res);
			
				IUserDAO.addcomment(uid,acomment,fid);
				res=2;
				System.out.println("service�ⶳ���Ľ��"+res);

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}

	//������
	public List<MComment> QuerryAllComments() {
		init();
		if(session!=null){

			List<MComment> res=new  ArrayList<MComment>();
			
			IUserDAO = session.getMapper(IUser.class);
			
			
			res=IUserDAO.QuerryAllComments();
			System.out.println("service��ѯ���"+res);

			session.commit();
			return res;	
		}
		destory();
		return null;
	}

	//ɾ���ļ�
	public int mydelete(int fid) {
		init();
		if(session!=null){

			int res=0;
			IUserDAO = session.getMapper(IUser.class);
			
				IUserDAO.mydelete(fid);
				res=1;
				System.out.println("serviceɾ�����"+res);
			

			session.commit();
			return res;	
		}
		destory();
		return 0;
	}
}
