package com.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import com.vo.MType;
import com.vo.MUser;

@Controller
public class UploadController {

	//查询type
	@RequestMapping(value = "/QuerryType",produces = "text/html;charset=utf-8")
	@ResponseBody  //当前的请求 不进行跳转
	public String QuerryType(Model m, HttpSession session) throws IOException{
		//查询数据库中type
	    Service service = new Service();
	    List<MType> res=new  ArrayList<MType>();
	    
		res=service.QuerryType();

		JSONObject object = new JSONObject();
        for(int i=0;i<res.size();i++){
	        object.put("res",res);
        }
        System.out.println(object.toString());
        
		return object.toString(); 

	}
	
	//查询remainspace
	@RequestMapping(value = "/Remain",produces = "text/html;charset=utf-8")
	@ResponseBody  //当前的请求 不进行跳转
	public String Remain(Model m, HttpSession session) throws IOException{
		int uid=(Integer) session.getAttribute("uid");
	    Service service = new Service();
	    int res=0;
	    
		res=service.Remain(uid);

		JSONObject object = new JSONObject();
        
	        object.put("res",res);
        
        System.out.println(object.toString());
        
		return object.toString(); 

	}
	
	//上传操作
	@RequestMapping(value = "/Upload",produces = "text/html;charset=utf-8")
	public String upload(MultipartFile myfile,String filetypeId,Model m, HttpSession session) throws IOException{

		int filesize=(int) myfile.getSize();
		//上传前获取此人网盘容量剩余大小
		int uid=(Integer) session.getAttribute("uid");
		Service service1 = new Service();
		int remain=service1.Remain(uid);
		//判断是否超出大小5m
		if(filesize<=remain){ 
			
			
			//下拉框的文件类型
			int ftid=Integer.parseInt(filetypeId);
			
			
			String realpath = session.getServletContext().getRealPath("/file");
		    System.out.println("上传文件保存地址:"+realpath+"/"+uid+"/");

		    // 获取客户端文件名
		    String fname = myfile.getOriginalFilename();
		    // 以 . 进行分割并截取后面的
		    String ftype =  fname.substring(fname.lastIndexOf("."));
		    // 生产的不重复的文件名
		    String filename = UUID.randomUUID().toString();
		    // 文件名+文件类型
		    String newname=filename+ftype;
		    String fullname = realpath+"/"+uid+"/"+filename+ftype;
		    System.out.println("上传的文件名："+fname);

		   
		    //将上传的文件输出到磁盘
		    System.out.println("上传的全名："+fullname); 
		    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(fullname));
		    
		    String uptime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		    
		    //更改数据库
		    Service service = new Service();
		    //上传人uid，文件真名，uuid名，存放路径，大小，上传时间
			int res1=service.ChangeFile(newname,fname,fullname,uid,uptime,filesize,ftid);
			int res2=service.ChangeSpace(uid,(int) myfile.getSize());
			System.out.println("res1结果"+res1);			
	        if(res2==1){
	        	m.addAttribute("fname", fname);
			    return "up_one_success";
	        }else{
	        	return "error"; 
	        }
	        
		    
		    
		}else{
			return "error";
		}
	}
	
	

}
