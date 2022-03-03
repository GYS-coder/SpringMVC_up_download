package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.Service;
import com.vo.MComment;
import com.vo.MFile;
import com.vo.MUser;


@Controller
public class UserController {

	//��¼
	@RequestMapping(value = "/Sign",produces = "text/html;charset=utf-8")
	public String SignIn(MUser muser,HttpSession session){ //SpringMVC�����������ǿ����Զ�����ת�� 

		Service service = new Service();
		
		int res=service.SignIn(muser);

		System.out.println("���"+res);
		
		
        if(res==1){
        	session.setAttribute("uid",muser.getUid());
        	return "mainpage"; 
        }else{
        	return "signin"; 
        }
	}
	
	//����or�ⶳ
	@RequestMapping(value = "/freeze",produces = "text/html;charset=utf-8")
	@ResponseBody  //��ǰ������ ��������ת
	public String freeze(int fid,HttpSession session){ //SpringMVC�����������ǿ����Զ�����ת�� 

		Service service = new Service();
		
		int res=service.freeze(fid);

		JSONObject object = new JSONObject();
        
        object.put("res",res);
    
        System.out.println(object.toString());
    
        return object.toString(); 
       
	}
	
	//���۽ⶳ
	@RequestMapping(value = "/NOfreeze",produces = "text/html;charset=utf-8")
	public String NOfreeze(int fid,String acomment ,HttpSession session){ //SpringMVC�����������ǿ����Զ�����ת�� 

		int uid=(Integer) session.getAttribute("uid");
		
		Service service = new Service();	
		int res=service.NOfreeze(fid,uid,acomment);

		JSONObject object = new JSONObject();
        
        object.put("res",res);
    
        System.out.println(object.toString());
    
        return "success"; 
       
	}
	//ɾ���ļ�
	@RequestMapping(value = "/mydelete",produces = "text/html;charset=utf-8")
	@ResponseBody  //��ǰ������ ��������ת
	public String mydelete(int fid, String fname,HttpSession session){ //SpringMVC�����������ǿ����Զ�����ת�� 

		int uid=(Integer) session.getAttribute("uid");
		Service service = new Service();
		
		//�ظ��ռ�
	    int filesizeres=service.QuerryFileSize(fid);
		
		int res22=service.ChangeSpacePlus(uid,filesizeres);
		System.out.println("�ظ��洢�ռ�res22���"+res22);	
		
		//���ݿ��ļ���ɾ��
		int res=service.mydelete(fid);

		//Ӳ��ɾ���ļ�
		boolean result = false;
	    String realpath = session.getServletContext().getRealPath("\\file");
	    
	    
	    String fullname = realpath+"\\"+uid+"\\"+fname;
	    
	    File file = new File(fullname);
	    if (file.exists()) {
	        file.delete();
	        result = true;
	    }
	    System.out.println("Ӳ��ɾ�����"+result);
	    
	  
		
		JSONObject object = new JSONObject();        
        object.put("res",res);    
        System.out.println(object.toString());  
        return object.toString(); 
       
	}

	//��ѯ���ݿ���������
	@RequestMapping(value = "/QuerryAllComments",produces = "text/html;charset=utf-8")
	@ResponseBody  //��ǰ������ ��������ת
	public String QuerryAllComments(Model m, HttpSession session){

	  
	    Service service = new Service();
	    List<MComment> res22=new  ArrayList<MComment>();
	    
		res22=service.QuerryAllComments();

		JSONObject object = new JSONObject();
        for(int i=0;i<res22.size();i++){
	        object.put("res",res22);
        }
        System.out.println(object.toString());
        
		return object.toString(); 
	}
}
