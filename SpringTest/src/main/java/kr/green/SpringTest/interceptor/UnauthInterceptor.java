package kr.green.SpringTest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UnauthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {				// 로그인 상태에서 /member/join 회원가입화면으로 가려고 하면 /board/list로 감 
			response.sendRedirect("/board/list");
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
}













