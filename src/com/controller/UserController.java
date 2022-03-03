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

	//登录
	@RequestMapping(value = "/Sign",produces = "text/html;charset=utf-8")
	public String SignIn(MUser muser,HttpSession session){ //SpringMVC的数据类型是可以自动进行转换 

		Service service = new Service();
		
		int res=service.SignIn(muser);

		System.out.println("结果"+res);
		
		
        if(res==1){
        	session.setAttribute("uid",muser.getUid());
        	return "mainpage"; 
        }else{
        	return "signin"; 
        }
	}
	
	//冻结or解冻
	@RequestMapping(value = "/freeze",produces = "text/html;charset=utf-8")
	@ResponseBody  //当前的请求 不进行跳转
	public String freeze(int fid,HttpSession session){ //SpringMVC的数据类型是可以自动进行转换 

		Service service = new Service();
		
		int res=service.freeze(fid);

		JSONObject object = new JSONObject();
        
        object.put("res",res);
    
        System.out.println(object.toString());
    
        return object.toString(); 
       
	}
	
	//评论解冻
	@RequestMapping(value = "/NOfreeze",produces = "text/html;charset=utf-8")
	public String NOfreeze(int fid,String acomment ,HttpSession session){ //SpringMVC的数据类型是可以自动进行转换 

		int uid=(Integer) session.getAttribute("uid");
		
		Service service = new Service();	
		int res=service.NOfreeze(fid,uid,acomment);

		JSONObject object = new JSONObject();
        
        object.put("res",res);
    
        System.out.println(object.toString());
    
        return "success"; 
       
	}
	//删除文件
	@RequestMapping(value = "/mydelete",produces = "text/html;charset=utf-8")
	@ResponseBody  //当前的请求 不进行跳转
	public String mydelete(int fid, String fname,HttpSession session){ //SpringMVC的数据类型是可以自动进行转换 

		int uid=(Integer) session.getAttribute("uid");
		Service service = new Service();
		
		//回复空间
	    int filesizeres=service.QuerryFileSize(fid);
		
		int res22=service.ChangeSpacePlus(uid,filesizeres);
		System.out.println("回复存储空间res22结果"+res22);	
		
		//数据库文件表删除
		int res=service.mydelete(fid);

		//硬盘删除文件
		boolean result = false;
	    String realpath = session.getServletContext().getRealPath("\\file");
	    
	    
	    String fullname = realpath+"\\"+uid+"\\"+fname;
	    
	    File file = new File(fullname);
	    if (file.exists()) {
	        file.delete();
	        result = true;
	    }
	    System.out.println("硬盘删除结果"+result);
	    
	  
		
		JSONObject object = new JSONObject();        
        object.put("res",res);    
        System.out.println(object.toString());  
        return object.toString(); 
       
	}

	//查询数据库所有评论
	@RequestMapping(value = "/QuerryAllComments",produces = "text/html;charset=utf-8")
	@ResponseBody  //当前的请求 不进行跳转
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
