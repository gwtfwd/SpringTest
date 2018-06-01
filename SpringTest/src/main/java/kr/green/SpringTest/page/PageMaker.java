package kr.green.SpringTest.page;

public class PageMaker {

	private int totalCount;			// ���̺��� sql������ �˻��� ����� column�� ����
	private int startPage;			// �ش� ���������̼��� ���� ������ (1,11,21,...)
	private int endPage;			// �ش� ���������̼��� ������������ (10,20,30,...)
	private boolean prev;			// ����
	private boolean next;			// ����
	
	private int displayPageNum = 10;		// �� ���������̼ǿ��� ��Ÿ���� ������ ��
	
	private Page page;				// ���� �������� � ���������� ��Ÿ���� ����

	
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
		// ���� �������� 3�϶� �������������� 10, ������������ 15�϶� �������������� 20
		// ceil(1.3) = 2
		endPage = (int)(Math.ceil(page.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		// �� �ʿ��� ������ ���� 
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)page.getPerPageNum()));	
		// endpage�� tmpendpage �� �������� ���� endpage�� �Ѵ�
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
















