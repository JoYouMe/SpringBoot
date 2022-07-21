package com.spring.boardweb.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//이 클래스를 설정 파일로 읽는 어노테이션
@Configuration
//설정내용을 어느 파일에서 읽어올 것인지 결정
@PropertySource("classpath:/application.properties") //classpath : src/main/resource를 의미
public class DataConfiguration {
	@Bean //옵션에서 Bean객체로 객체 생성하는 어노테이션
	//application.properties 파일에서 spring.datasource.hikari로 시작하는 설정들만 읽어오는 설정
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.jpa") //spring.jpa 설정들만 읽어옴
	public Properties hibernateConfig() { 
		return new Properties();
	}
}
