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


//使用基本的Java类 完成控制器的操作
@Controller
public class downloadController {
	//下载图片前  显示列表
	/*@RequestMapping("/show")
	public String testXzView(Model m, HttpSession session){
		//登录时session中已添加uid
	    int uid=(Integer) session.getAttribute("uid");
	    
	    String realpath = session.getServletContext().getRealPath(File.separator+"file"+File.separator+uid);
		
		String realpath = session.getServletContext().getRealPath(File.separator+"file");		
	    File f = new File(realpath);
	    String[] fs = f.list(); //文件夹中所有的文件名
	    
	    
	    m.addAttribute("fs", fs);
	    
	    return "download";
	}*/
	//查询数据库所有文件
	@RequestMapping("/QuerryAllFile")
	@ResponseBody  //当前的请求 不进行跳转
	public String QuerryAllFile(Model m, HttpSession session){
		//登录时session中已添加uid
	    /*int uid=(Integer) session.getAttribute("uid");*/
	    
	  //查询数据库中所有文件
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
	//下载图片
	@RequestMapping("/jsp/download")
	public void xzimgcon(String fname , String fid, int fuid, HttpServletRequest request, HttpServletResponse response){
		
	    /*response.setContentType("image/jpeg;charset=utf-8");*/// 服务端以 二进制流的形式 相应客户端

	    
	    HttpSession session = request.getSession(); //获取session对象
	    
	    /*int uid=(Integer) session.getAttribute("uid");*/
	    
	    
	    ServletContext sc =  session.getServletContext(); //获取ServletContext对象  Servlet上下文对象
	    String realpath = sc.getRealPath("file/"+fuid+"/");

	    response.setHeader("Content-disposition", "attachment;filename=" + fname);
	    try {

	    	//创建输出流 二进制
			ServletOutputStream os = response.getOutputStream();
			
	    	//将要下载的文件生成为File对象
			File file = new File(realpath, fname);
			
			//使用第三方的下载工具
			byte[] bytes = FileUtils.readFileToByteArray(file);
			os.write(bytes);
			os.flush();
			os.close();
	    	
			//增加下载次数
			Service service = new Service();
			int re=service.AddDownCount(fid);

	        System.out.println("controller里re："+re);
	    	
	    } catch (Exception e) {
	        System.out.println("下载文件出现异常");
	        e.printStackTrace();
	    }
	}


}
