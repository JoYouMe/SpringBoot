package com.spring.boardweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_Board_File")
@Data

//다중 pk설정
//다중 pk가 모여있는 객체를 만들어서 연결해줌, Idclass 연결 선언
@IdClass(BoardFileId.class) 
public class BoardFile {
	@Id //두 개 이상의 키 값을 가질때는 class를 만들어서 사용
	@ManyToOne 												//foreign key 설정
	//1. board Entity에서 BOARD_SEQ만 꺼내서 사용하기 때문에		//매핑 관계
	@JoinColumn(name="BOARD_SEQ") 							//1:1 @OneToOne
	//2. int boardSeq -> Board board로 변경					//다:1 @ManyToOne 
	private Board board;									//1:다 @OneToMany
												
	@Id												
	private int fileSeq;						
	
	private String originalFileName;
	
	private String fileName;
	
	private String filePath;
}
