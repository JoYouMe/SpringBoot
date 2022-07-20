package com.spring.boardweb.controller.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/getBoardList")
	public ModelAndView getBoardListView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/getBoardList.html");
		
		return mv;
	}
	
	@GetMapping("/getBoard")
	public ModelAndView getBoardView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/getBoard.html");
		
		return mv;
	}
	
	@GetMapping("/insertBoard")
	public ModelAndView insertBoardView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insertBoard.html");
		
		return mv;
	}
}
