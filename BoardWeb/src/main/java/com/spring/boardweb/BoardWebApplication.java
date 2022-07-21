package com.spring.boardweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BoardWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardWebApplication.class, args);
	}

}
