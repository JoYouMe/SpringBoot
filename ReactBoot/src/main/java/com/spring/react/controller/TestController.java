package com.spring.react.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.react.DTO.ResponseDTO;
import com.spring.react.DTO.TestDTO;

@RestController
@RequestMapping("/api")
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	
	@GetMapping("/test2")
	public ResponseEntity<?> test2() {
		//ResponseDTO를 ResponseEntity에 담아서 리턴
		List<TestDTO> testList = new ArrayList<TestDTO>();
		
		for(int i = 0; i < 3; i++) {
			TestDTO testDTO = new TestDTO();
			testDTO.setId(i);
			testDTO.setName("name" + i);
			testList.add(testDTO);
		}
		
		//TestDTO를 담은 응답 객체 생성
		ResponseDTO<TestDTO> response = new ResponseDTO<>();
		
		response.setData(testList);
		
		//통신이 ok(status가 200)일 때 응답 바디에 ResponseDTO를 담아서 return
		return ResponseEntity.ok().body(response);
	}
}
