package com.spring.boardweb.controller.board;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardweb.entity.Board;
import com.spring.boardweb.service.board.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	@GetMapping("/getBoardList")									//개수
	public ModelAndView getBoardListView(@PageableDefault(page = 0, size = 10)Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/getBoardList.html");
		
		Page<Board> boardList = boardService.getBoardList(pageable);
		mv.addObject("boardList", boardList);
		
		return mv;
	}
						//url 파라미터로 받음
	@GetMapping("/getBoard/{boardSeq}") //@PathVariable이용해서 같은 값을 꺼내옴
	public ModelAndView getBoardView(@PathVariable int boardSeq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/getBoard.html");
		
		Board board = boardService.getBoard(boardSeq);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@GetMapping("/insertBoard")
	public ModelAndView insertBoardView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insertBoard.html");
		
		return mv;
	}
	
	@PostMapping("/insertBoard")
	public void insertBoardView(HttpServletResponse response, Board board) throws IOException {
		boardService.insertBoard(board);
		
		//커맨드 객체란? 메소드에서 매개변수로 선언된 객체
		//해당 객체는 Getter, Setter가 필수적으로 존재해야됨
		//view에서 보내준 데이터의 키 값과 이름이 같은 속성 값의 Setter가 자동 호출되어 세팅
		//커맨드 객체의 속성 값 중 int는 0으로 String은 "" 으로 초기화됨
		Board board2 = new Board();
		System.out.println(board2.getBoardSeq());
		System.out.println(board2.getBoardTitle());
		//RestController에서는 String으로 Redirect 불가능하여 response객체를 사용하여 Redirect함
		response.sendRedirect("/board/getBoardList");
		
	}
							//url 파라미터로 받음
	@GetMapping("/deleteBoard/{boardSeq}")
	public void deleteBoard(HttpServletResponse response, @PathVariable int boardSeq) throws IOException {
		boardService.deleteBoard(boardSeq);
		
		response.sendRedirect("/board/getBoardList"); //처리가 끝나면 getBoardList로 이동
	}
	
	@PostMapping("/updateBoard")
	public void updateBoard (Board board, HttpServletResponse response) throws IOException {
		boardService.updateBoard(board);
		
		response.sendRedirect("/board/getBoardList");
	}
	
	
	
	
	
	
}
