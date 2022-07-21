package com.spring.boardweb.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

//DTO에 Entity를 사용해도 무관
//@Entity

@Data
public class TestDTO {
	private int idx;
	private String testStr;
	private List<String> testList;
	private Map<String, String> testMap;
}
