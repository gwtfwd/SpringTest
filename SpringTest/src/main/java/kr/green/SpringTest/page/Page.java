package kr.green.SpringTest.page;

public class Page {
	
	private int page;				// ���� ������ ��ȣ
	private int perPageNum;			// �� �������� ��Ÿ�� �� �ִ� ���� �ִ� ����
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if(page <= 0) {				// ����ó�� : ���� �������� ��ȣ�� 0���� ������ ��������ȣ�� 1�� ����
			this.page = 1;
		}
		else
			this.page = page;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 ) {			// ����ó�� : �� �������� �ִ� ���� ������ 0�� ���ų� ������ ���� ������ 10���� ������
			this.perPageNum = 10;
		}
		else if(perPageNum > 50) {		// ����ó�� : �� �������� �ִ� ���� ������ 50���� ������ ���� ������ 50���� ������
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













