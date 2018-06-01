package kr.green.SpringTest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// 인터셉터가 요청을 가로채어 postHandle을 처리하고 작업을 완료한 후에는 preHandle로 넘어감
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object user = modelMap.get("user");					// user정보를 가져옴
		
		if (user != null) {								
			session.setAttribute("user", user);				// 현재 session에 "user"라는 정보를 객체user로 저장
			response.sendRedirect("/board/list");			// 처리된 후 board/list로 보내줌 
			System.out.println("new login success");		// 로그인이 제대로 됬는지 확인
		}
	}
	
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");						// 이전에 있던 user정보를 지움
			System.out.println("clear login data before");			// 이전에 있던 user정보를 지웠는지 확인
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













