package com.spring.react.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_TODO")
@Data
public class Todo {
	@Id
	private int id;
	
	private String username;
	
	private String text;
	
	private boolean checked;
}
