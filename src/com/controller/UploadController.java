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

	//��ѯtype
	@RequestMapping(value = "/QuerryType",produces = "text/html;charset=utf-8")
	@ResponseBody  //��ǰ������ ��������ת
	public String QuerryType(Model m, HttpSession session) throws IOException{
		//��ѯ���ݿ���type
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
	
	//��ѯremainspace
	@RequestMapping(value = "/Remain",produces = "text/html;charset=utf-8")
	@ResponseBody  //��ǰ������ ��������ת
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
	
	//�ϴ�����
	@RequestMapping(value = "/Upload",produces = "text/html;charset=utf-8")
	public String upload(MultipartFile myfile,String filetypeId,Model m, HttpSession session) throws IOException{

		int filesize=(int) myfile.getSize();
		//�ϴ�ǰ��ȡ������������ʣ���С
		int uid=(Integer) session.getAttribute("uid");
		Service service1 = new Service();
		int remain=service1.Remain(uid);
		//�ж��Ƿ񳬳���С5m
		if(filesize<=remain){ 
			
			
			//��������ļ�����
			int ftid=Integer.parseInt(filetypeId);
			
			
			String realpath = session.getServletContext().getRealPath("/file");
		    System.out.println("�ϴ��ļ������ַ:"+realpath+"/"+uid+"/");

		    // ��ȡ�ͻ����ļ���
		    String fname = myfile.getOriginalFilename();
		    // �� . ���зָ��ȡ�����
		    String ftype =  fname.substring(fname.lastIndexOf("."));
		    // �����Ĳ��ظ����ļ���
		    String filename = UUID.randomUUID().toString();
		    // �ļ���+�ļ�����
		    String newname=filename+ftype;
		    String fullname = realpath+"/"+uid+"/"+filename+ftype;
		    System.out.println("�ϴ����ļ�����"+fname);

		   
		    //���ϴ����ļ����������
		    System.out.println("�ϴ���ȫ����"+fullname); 
		    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(fullname));
		    
		    String uptime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		    
		    //�������ݿ�
		    Service service = new Service();
		    //�ϴ���uid���ļ�������uuid�������·������С���ϴ�ʱ��
			int res1=service.ChangeFile(newname,fname,fullname,uid,uptime,filesize,ftid);
			int res2=service.ChangeSpace(uid,(int) myfile.getSize());
			System.out.println("res1���"+res1);			
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
