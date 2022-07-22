package com.spring.boardweb.service.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.boardweb.entity.Board;
import com.spring.boardweb.repository.BoardRepository;
import com.spring.boardweb.service.board.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Page<Board> getBoardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board); //board Entity에 있는 객체를 꺼내와서 boardRepository에 저장
	}

	@Override
	public Board getBoard(int boardSeq) {
		return boardRepository.findById(boardSeq).get();
	}

	@Override
	public void deleteBoard(int boardSeq) {
		boardRepository.deleteById(boardSeq);//board Entity에 있는 객체를 꺼내와서 boardRepository에서 삭제
	}

	@Override
	public void updateBoard(Board board) {
		boardRepository.save(board);
		
	}

}
