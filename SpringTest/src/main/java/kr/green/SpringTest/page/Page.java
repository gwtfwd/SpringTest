package kr.green.SpringTest.page;

public class Page {
	
	private int page;				// 현재 페이지 번호
	private int perPageNum;			// 한 페이지에 나타낼 수 있는 글의 최대 개수
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if(page <= 0) {				// 예외처리 : 현재 페이지의 번호가 0보다 작으면 페이지번호를 1로 지정
			this.page = 1;
		}
		else
			this.page = page;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 ) {			// 예외처리 : 한 페이지에 있는 글의 개수가 0과 같거나 작으면 글의 개수를 10으로 지정함
			this.perPageNum = 10;
		}
		else if(perPageNum > 50) {		// 예외처리 : 한 페이지에 있는 글의 개수가 50개가 넘으면 글의 개수를 50개로 지정함
			this.perPageNum = 50;
		}
		else
			this.perPageNum = perPageNum;
	}
	
	public Page() {
		page = 1;
		perPageNum = 10;
	}
	
	public Page(int page, int perPageNum) {
		this.setPage(page);
		this.setPerPageNum(perPageNum);
	}
	
	public int getPageStart() {
		return (page-1)*perPageNum;
	}
	
}













