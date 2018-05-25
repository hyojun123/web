package org.zerock.web.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.zerock.web.board.vo.BoardVO;
import org.zerock.web.board.vo.PagingVO;

public interface BoardService {

	List<BoardVO> getBoardList(PagingVO vo) throws Exception;

	String getCnt(PagingVO vo) throws Exception;

	BoardVO getBoard(String bno) throws Exception;

	void insertBoard(BoardVO vo) throws Exception;


}
