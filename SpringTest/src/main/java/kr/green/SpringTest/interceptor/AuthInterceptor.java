package kr.green.SpringTest.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

	// 로그인 유지

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null ) {				// 홈화면에서 로그인 안하고 /board/list 직접 들어가지 못하게 함
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}
	
	
	
	
}










