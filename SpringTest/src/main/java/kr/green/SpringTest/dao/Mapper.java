package kr.green.SpringTest.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.SpringTest.dto.LoginDTO;

public interface Mapper {
	
	public String getId(@Param("id") String id);
	
	public String getPw(@Param("id") String id);
	
	public String getEmail(@Param("id") String id);
	
	public User getUser(@Param("id") String id);
	
	public void setUser(@Param("id") String id,	@Param("pw") String pw,@Param("email") String email);
	
	public User login(LoginDTO dto);		// id와 pw가 일치하면 user정보 가져옴
	
}


