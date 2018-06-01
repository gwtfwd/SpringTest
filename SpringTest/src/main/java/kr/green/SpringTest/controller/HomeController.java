package kr.green.SpringTest.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.SpringTest.dao.Mapper;
import kr.green.SpringTest.dao.User;
import kr.green.SpringTest.dto.LoginDTO;


@Controller
public class HomeController {
	
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user != null)
			return "redirect:/board/list";
		
		return "/WEB-INF/views/home.jsp";
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "redirect:/main";
	}*/
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainGet(String id, String pw,Model model) {
		model.addAttribute("id", id);
		return "/WEB-INF/views/main.jsp";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainPost(HttpServletRequest request, Model model, LoginDTO dto) {
		
		/* LoginDTO�� ���ָ� �Ʒ� ������ �ʿ� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");*/ 
		
		User user = mapper.login(dto);
		
		if(user == null)									// ������ ��ã�����
			return "redirect:/";
		
		/* LoginDTO�� ���ָ� �Ʒ� ������ �ʿ� ����
		else if(user.getPw().compareTo(pw) != 0)			// ������ ã������ ����� ��ã�� ���
		return "redirect:/";*/
		
		model.addAttribute("user", user);
		
		return "/WEB-INF/views/main.jsp";
	}
	
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
}




