package org.zerock.web.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.web.board.service.BoardService;
import org.zerock.web.board.vo.BoardVO;
import org.zerock.web.board.vo.PagingCalculator;
import org.zerock.web.board.vo.PagingVO;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/getBoard")
	public String home(ModelMap model,@ModelAttribute PagingVO vo) throws Exception {
		String totalCnt = boardService.getCnt(vo);

		vo = PagingCalculator.pageCalculate(vo, Integer.parseInt(totalCnt));
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("hello1234567");
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", vo);

		return "board";
	}
	
	@RequestMapping(value = "/getBoardDetail")
	public String getBoardDetail(HttpServletRequest res,ModelMap model,@ModelAttribute PagingVO pagingVo) throws Exception {
		if(res.getParameter("bno") != null) {
			String bno = res.getParameter("bno");
			
			BoardVO vo = boardService.getBoard(bno);
			
			model.addAttribute("board",vo);

		}

		model.addAttribute("paging", pagingVo);
		
		return "boardDetail";
	}
	
	@RequestMapping(value = "/writeBoard", method=RequestMethod.POST)
	public String writeBoard(@ModelAttribute BoardVO vo) throws Exception {
		System.out.println(vo);
		boardService.insertBoard(vo);
		return "redirect:/getBoard";
	}

	@RequestMapping(value = "/chajangnim", method=RequestMethod.GET)
	public String get() throws Exception{

		return "exam";
	}
}
