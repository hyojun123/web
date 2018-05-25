package org.zerock.web.board.vo;

public class PagingCalculator {
	
	public static PagingVO pageCalculate(PagingVO vo,int totalCnt) {
		
		int rows = vo.getRows();
		int pageScale = vo.getPageScale();
		
		
		vo.setTotalCnt(totalCnt);
		vo.setTotalPage(totalCnt/rows);
		vo.setPageGroup((vo.getPage()-1)/pageScale+1);
		vo.setStartPage(((vo.getPage()-1)/pageScale) * pageScale + 1);
		vo.setEndPage(vo.getStartPage() + pageScale - 1);
		vo.setStartRow((vo.getPage() * rows - rows));
		
		if(totalCnt % rows > 0) {
			vo.setTotalPage(vo.getTotalPage()+1);
		}
		if(vo.getEndPage() > vo.getTotalPage()) {
			vo.setEndPage(vo.getTotalPage());
		}
		
		vo.setPrePage(((vo.getPageGroup()-1) * pageScale) - (pageScale - 1));
		vo.setNextPage(((vo.getPageGroup()+1) * pageScale) - (pageScale - 1));
		vo.setEndPageGroup(vo.getTotalPage()/pageScale);
		
		if(vo.getTotalPage() % pageScale > 0) {
			vo.setEndPageGroup(vo.getEndPageGroup() + 1);
		}
		
		return vo;
	}
}
