package com.spring.react.service.todo;

import java.util.List;

import com.spring.react.entity.Todo;

public interface TodoService {
	List<Todo> selectTodoList(String username);
	
	void insertTodo(Todo todo);
}
