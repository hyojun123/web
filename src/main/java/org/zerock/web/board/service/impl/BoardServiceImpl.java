package org.zerock.web.board.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.web.board.service.BoardService;
import org.zerock.web.board.vo.BoardVO;
import org.zerock.web.board.vo.PagingVO;

@Repository
public class BoardServiceImpl implements BoardService {

	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "org.zerock.web.board.mapper.BoardMapper";
	
	
	@Override
	public List<BoardVO> getBoardList(PagingVO vo) throws Exception {
		
		return sqlSession.selectList(Namespace+".getBoardList",vo);
	}


	@Override
	public String getCnt(PagingVO vo) throws Exception {
		
		return sqlSession.selectOne(Namespace+".getCnt",vo);
	}
	
	@Override
	public BoardVO getBoard(String bno) throws Exception {
		return sqlSession.selectOne(Namespace+".getBoard",bno);
	}


	@Override
	public void insertBoard(BoardVO vo) throws Exception {

		sqlSession.insert(Namespace+".insertBoard", vo);
	}
	
}
