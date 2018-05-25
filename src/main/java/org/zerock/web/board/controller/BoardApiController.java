package org.zerock.web.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.web.board.service.BoardService;
import org.zerock.web.board.vo.BoardVO;
import org.zerock.web.board.vo.PagingCalculator;
import org.zerock.web.board.vo.PagingVO;

@RestController
public class BoardApiController {

	@Inject
	private BoardService boardService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/boardApi", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public @ResponseBody String getPageBoardList(@ModelAttribute PagingVO vo) throws Exception {

		String totalCnt = boardService.getCnt(vo);
		
		vo = PagingCalculator.pageCalculate(vo, Integer.parseInt(totalCnt));
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		JSONArray jsonArry = new JSONArray();
		
		for(int i = 0 ; i < boardList.size(); i++) {
			JSONObject jsonObj = new JSONObject();
			
			jsonObj.put("bno", boardList.get(i).getBno());
			jsonObj.put("title",boardList.get(i).getTitle());
			jsonObj.put("content",boardList.get(i).getContent());
			jsonObj.put("writer",boardList.get(i).getWriter());
			jsonObj.put("regdate",boardList.get(i).getRegdate());
			jsonObj.put("viewcnt",boardList.get(i).getViewcnt());
			
			jsonArry.add(jsonObj);
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("data", jsonArry);
		obj.put("type", vo.getType());
		obj.put("first", vo.getFirst());
		obj.put("second", vo.getSecond());
		
		return obj.toString();
	}
	
}
