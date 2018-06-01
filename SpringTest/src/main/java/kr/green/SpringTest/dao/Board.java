package kr.green.SpringTest.dao;

public class Board {
	private String title;
	private String contents;
	private int number;
	private String author;
	
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public int getNumber() {
		return number;
	}
	public String getAuthor() {
		return author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
