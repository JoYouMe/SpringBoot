package com.spring.boardweb.service.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.boardweb.entity.Board;

public interface BoardService {
	Page<Board> getBoardList(Pageable pageable);

	void insertBoard(Board board);
	
	Board getBoard(int boardSeq);
						 //인자는 boardSeq를 받음
	void deleteBoard(int boardSeq);
	
	void updateBoard(Board board);
}
