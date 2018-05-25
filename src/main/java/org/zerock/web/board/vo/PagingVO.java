package org.zerock.web.board.vo;

public class PagingVO {
	private int totalCnt;
	private int rows = 10;
	private int totalPage;
	private int page = 1;
	private int pageGroup = 1;
	private int startPage;
	private int endPage;
	private int pageScale = 5;
	private int startRow = 1;
	private int prePage;
	private int nextPage;
	private int endPageGroup;
	private String first;
	private String second;
	private String type;
	
	
	
	@Override
	public String toString() {
		return "PagingVO [totalCnt=" + totalCnt + ", rows=" + rows + ", totalPage=" + totalPage + ", page=" + page
				+ ", pageGroup=" + pageGroup + ", startPage=" + startPage + ", endPage=" + endPage + ", pageScale="
				+ pageScale + ", startRow=" + startRow + ", prePage=" + prePage + ", nextPage=" + nextPage
				+ ", endPageGroup=" + endPageGroup + ", first=" + first + ", second=" + second + ", type=" + type + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public int getEndPageGroup() {
		return endPageGroup;
	}

	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public PagingVO() {
		
	}
	
	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getPageScale() {
		return pageScale;
	}

	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
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



}
