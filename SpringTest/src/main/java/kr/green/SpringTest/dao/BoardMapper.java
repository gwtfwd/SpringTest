package kr.green.SpringTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.SpringTest.page.Page;

public interface BoardMapper {
	
	public void setBoard(@Param("title") String title, @Param("contents") String contents, @Param("author") String author);
	
	public List<Board> getBoards();			// 모든 게시글을 가져옴
	
	public Board getBoardById(@Param("number") int number);
	
	public void modifyBoardById(@Param("title") String title, @Param("contents") String contents, @Param("author") String author, @Param("number") int number);
	
	public List<Board> getPageBoards(Page p);		// 현재 페이지의 게시글을 가져옴
	
	public Integer getBoardsCount();				// 게시판에 있는 모든 글의 개수
	
	// 제목검색을 위한 메소드
	public List<Board> getPageBoardsByTitle(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByTitle(@Param("search") String search);
	
	// 내용검색을 위한 메소드
	public List<Board> getPageBoardsByContents(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByContents(@Param("search") String search);
	
	// 저자검색을 위한 메소드
	public List<Board> getPageBoardsByAuthor(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByAuthor(@Param("search") String search);
	
	
	
}
