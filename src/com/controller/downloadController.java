package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.service.Service;
import com.vo.MFile;
import com.vo.MType;


//ʹ�û�����Java�� ��ɿ������Ĳ���
@Controller
public class downloadController {
	//����ͼƬǰ  ��ʾ�б�
	/*@RequestMapping("/show")
	public String testXzView(Model m, HttpSession session){
		//��¼ʱsession�������uid
	    int uid=(Integer) session.getAttribute("uid");
	    
	    String realpath = session.getServletContext().getRealPath(File.separator+"file"+File.separator+uid);
		
		String realpath = session.getServletContext().getRealPath(File.separator+"file");		
	    File f = new File(realpath);
	    String[] fs = f.list(); //�ļ��������е��ļ���
	    
	    
	    m.addAttribute("fs", fs);
	    
	    return "download";
	}*/
	//��ѯ���ݿ������ļ�
	@RequestMapping("/QuerryAllFile")
	@ResponseBody  //��ǰ������ ��������ת
	public String QuerryAllFile(Model m, HttpSession session){
		//��¼ʱsession�������uid
	    /*int uid=(Integer) session.getAttribute("uid");*/
	    
	  //��ѯ���ݿ��������ļ�
	    Service service = new Service();
	    List<MFile> res=new  ArrayList<MFile>();
	    
		res=service.QuerryAllFile();

		JSONObject object = new JSONObject();
        for(int i=0;i<res.size();i++){
	        object.put("res",res);
        }
        System.out.println(object.toString());
        
		return object.toString(); 
	}
	//����ͼƬ
	@RequestMapping("/jsp/download")
	public void xzimgcon(String fname , String fid, int fuid, HttpServletRequest request, HttpServletResponse response){
		
	    /*response.setContentType("image/jpeg;charset=utf-8");*/// ������� ������������ʽ ��Ӧ�ͻ���

	    
	    HttpSession session = request.getSession(); //��ȡsession����
	    
	    /*int uid=(Integer) session.getAttribute("uid");*/
	    
	    
	    ServletContext sc =  session.getServletContext(); //��ȡServletContext����  Servlet�����Ķ���
	    String realpath = sc.getRealPath("file/"+fuid+"/");

	    response.setHeader("Content-disposition", "attachment;filename=" + fname);
	    try {

	    	//��������� ������
			ServletOutputStream os = response.getOutputStream();
			
	    	//��Ҫ���ص��ļ�����ΪFile����
			File file = new File(realpath, fname);
			
			//ʹ�õ����������ع���
			byte[] bytes = FileUtils.readFileToByteArray(file);
			os.write(bytes);
			os.flush();
			os.close();
	    	
			//�������ش���
			Service service = new Service();
			int re=service.AddDownCount(fid);

	        System.out.println("controller��re��"+re);
	    	
	    } catch (Exception e) {
	        System.out.println("�����ļ������쳣");
	        e.printStackTrace();
	    }
	}


}
