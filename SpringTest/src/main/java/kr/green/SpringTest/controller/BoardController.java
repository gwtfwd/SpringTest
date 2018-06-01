package kr.green.SpringTest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.SpringTest.dao.Board;
import kr.green.SpringTest.dao.BoardMapper;
import kr.green.SpringTest.dao.User;
import kr.green.SpringTest.page.Page;
import kr.green.SpringTest.page.PageMaker;

@Controller
@RequestMapping(value="/board/*")

public class BoardController {
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping(value="/write", method= RequestMethod.GET)
	public String boardWriteGet(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		model.addAttribute("author", user.getId());
		
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@RequestMapping(value="/write", method= RequestMethod.POST)
	public String boardWritePOST(Model model, HttpServletRequest request) {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String author;
		
		HttpSession session = request.getSession();						// 작성자를 id로 지정해줌
		User user = (User)session.getAttribute("user");
		author = user.getId();
		
		boardMapper.setBoard(title, contents, author);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String boardListGet(Model model, Integer page, HttpServletRequest r) {
		// ArrayList<Board> list = (ArrayList)boardMapper.getBoards();
		
		HttpSession session = r.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println(user.getId());
		
		if(page == null) {
			page = 1;
		}
		
		Page p = new Page(page,5);
		ArrayList<Board> list;
		int totalCount=0;
		String search = r.getParameter("search");
		
		Integer searchType;
	    String tmp = r.getParameter("searchType");
	      
	    if (tmp == null || tmp.length() == 0)
	    	searchType = 0;
	    else
	    	searchType = Integer.parseInt(tmp);
		
		//System.out.println("get 검색 : " + search);
		
		// 검색어가 없을때
		if(search == null || search.length() == 0 || searchType == null) {
			list = (ArrayList)boardMapper.getPageBoards(p);
			totalCount = boardMapper.getBoardsCount();
		}
		
		// 검색어가 있을때
		else {
			if(searchType==0) {
				list = (ArrayList)boardMapper.getPageBoardsByTitle(p, "%"+search+"%");	// like "%search%"
				totalCount = boardMapper.getBoardsCountByTitle("%"+search+"%");
				model.addAttribute("searchType", 0);
			}
			else if(searchType==1) {
				list = (ArrayList)boardMapper.getPageBoardsByContents(p, "%"+search+"%");	
				totalCount = boardMapper.getBoardsCountByContents("%"+search+"%");
				model.addAttribute("searchType", 1);
			}
			else {
				list = (ArrayList)boardMapper.getPageBoardsByAuthor(p, "%"+search+"%");	
				totalCount = boardMapper.getBoardsCountByAuthor("%"+search+"%");
				model.addAttribute("searchType", 2);
			}
		}
		
		
		PageMaker pm = new PageMaker();
		pm.setPage(p);
		pm.setTotalCount(totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		model.addAttribute("search", search);
		model.addAttribute("searchType", searchType);
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@RequestMapping(value="/list", method= RequestMethod.POST)
	public String boardListPost(Model model, Integer page, HttpServletRequest r) {
		
		//model.addAttribute("search", search);
		//System.out.println("post寃���: "+ search);					// ��湲��� ���λ����吏� test
		
		if(page == null) {
			page = 1;
		}
		
		Page p = new Page(page,5);
		ArrayList<Board> list;
		int totalCount=0;
		String search = r.getParameter("search");
		
		Integer searchType;
	    String tmp = r.getParameter("searchType");
	      
	    if (tmp == null )
	    	searchType = 0;
	    else
	    	searchType = Integer.parseInt(tmp);

	    // 검색어가 없으면 모든 게시글을 가져옴
		if(search == null || search.length() == 0 || searchType == null) {
			list = (ArrayList)boardMapper.getPageBoards(p);
			totalCount = boardMapper.getBoardsCount();
		}
		
		// 검색어가 있을때
		else {
			if(searchType==0) {
				list = (ArrayList)boardMapper.getPageBoardsByTitle(p, "%"+search+"%");	// like "%search%"
				totalCount = boardMapper.getBoardsCountByTitle("%"+search+"%");
				model.addAttribute("searchType", 0);
			}
			else if(searchType==1) {
				list = (ArrayList)boardMapper.getPageBoardsByContents(p, "%"+search+"%");	
				totalCount = boardMapper.getBoardsCountByContents("%"+search+"%");
				model.addAttribute("searchType", 1);
			}
			else {
				list = (ArrayList)boardMapper.getPageBoardsByAuthor(p, "%"+search+"%");	
				totalCount = boardMapper.getBoardsCountByAuthor("%"+search+"%");
				model.addAttribute("searchType", 2);
			}
		}
		
		PageMaker pm = new PageMaker();
		pm.setPage(p);
		pm.setTotalCount(totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		model.addAttribute("search", search);
		
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@RequestMapping(value="/detail", method= RequestMethod.GET)
	public String boardDetailGet(Model model, int number) {
		Board board = boardMapper.getBoardById(number);
		model.addAttribute("board", board);
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	@RequestMapping(value="/detail", method= RequestMethod.POST)
	public String boardDetailPost(Model model, HttpServletRequest r) {
		int number = Integer.parseInt(r.getParameter("number"));			// 臾몄���댁�� �レ��濡� 諛�轅�
		// System.out.println(number);
		
		String author = r.getParameter("author");
		String title = r.getParameter("title");
		String contents = r.getParameter("contents");
		
		boardMapper.modifyBoardById(title, contents, author, number);
		return "redirect:/board/list";
	}
	
}







