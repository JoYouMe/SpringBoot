package com.spring.boardweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boardweb.entity.Board;
													//Entity, 키 값의 형태
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
