package kr.green.SpringTest.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

	// �α��� ����

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null ) {				// Ȩȭ�鿡�� �α��� ���ϰ� /board/list ���� ���� ���ϰ� ��
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}
	
	
	
	
}










