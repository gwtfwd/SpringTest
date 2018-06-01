package kr.green.SpringTest.dao;

public class User {
	private String id;
	private String pw;
	private String email;
	
	public User(String id, String pw, String email) {
		this.id = id;
		this.pw = pw;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	
}
