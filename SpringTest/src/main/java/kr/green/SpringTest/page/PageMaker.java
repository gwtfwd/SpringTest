package kr.green.SpringTest.page;

public class PageMaker {

	private int totalCount;			// 테이블에서 sql문으로 검색한 결과의 column의 개수
	private int startPage;			// 해당 페이지네이션의 시작 페이지 (1,11,21,...)
	private int endPage;			// 해당 페이지네이션의 마지막페이지 (10,20,30,...)
	private boolean prev;			// 이전
	private boolean next;			// 이후
	
	private int displayPageNum = 10;		// 한 페이지네이션에서 나타나는 페이지 수
	
	private Page page;				// 현재 페이지가 어떤 페이지인지 나타내는 변수

	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public void calcData() {
		// 현재 페이지가 3일때 마지막페이지는 10, 현재페이지가 15일때 마지막페이지는 20
		// ceil(1.3) = 2
		endPage = (int)(Math.ceil(page.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		// 총 필요한 페이지 개수 
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)page.getPerPageNum()));	
		// endpage와 tmpendpage 중 작은것을 실제 endpage로 한다
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		prev = startPage == 1? false : true;
		
		next = endPage * page.getPerPageNum() >= totalCount ? false : true;
		
	}
	
	public String query(int page) {
		return "/board/list?page="+page;
	}
	
	
}
















