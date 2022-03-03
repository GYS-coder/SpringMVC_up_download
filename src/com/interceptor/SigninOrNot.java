package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SigninOrNot implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle) throws Exception {
		
		System.out.println("�����ǰ�����ط���preHandle");
		
		//����session
		HttpSession session =request.getSession();

		//��ȡ�����ַ
		String url =request.getRequestURL().toString();
		
		//���session�е��û�
		Object userid = session.getAttribute("uid");
	
		System.out.println(userid);
		
			if(userid != null)
			{
				return true;
			}else{
				response.sendRedirect("/jsp/signin.jsp");
				return false;
			}
		
		
	}
 
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����zhong");
		
	}
 
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����hou");
		
	}

}
