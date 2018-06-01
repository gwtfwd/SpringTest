package kr.green.SpringTest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.SpringTest.page.Page;

public interface BoardMapper {
	
	public void setBoard(@Param("title") String title, @Param("contents") String contents, @Param("author") String author);
	
	public List<Board> getBoards();			// ��� �Խñ��� ������
	
	public Board getBoardById(@Param("number") int number);
	
	public void modifyBoardById(@Param("title") String title, @Param("contents") String contents, @Param("author") String author, @Param("number") int number);
	
	public List<Board> getPageBoards(Page p);		// ���� �������� �Խñ��� ������
	
	public Integer getBoardsCount();				// �Խ��ǿ� �ִ� ��� ���� ����
	
	// ����˻��� ���� �޼ҵ�
	public List<Board> getPageBoardsByTitle(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByTitle(@Param("search") String search);
	
	// ����˻��� ���� �޼ҵ�
	public List<Board> getPageBoardsByContents(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByContents(@Param("search") String search);
	
	// ���ڰ˻��� ���� �޼ҵ�
	public List<Board> getPageBoardsByAuthor(@Param("p") Page p, @Param("search") String search);
	public Integer getBoardsCountByAuthor(@Param("search") String search);
	
	
	
}
