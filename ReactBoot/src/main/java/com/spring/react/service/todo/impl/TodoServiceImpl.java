package com.spring.react.service.todo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.react.entity.Todo;
import com.spring.react.repository.TodoRepository;
import com.spring.react.service.todo.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> selectTodoList(String username) {
		return todoRepository.findByUsername(username);
	}

	@Override
	public void insertTodo(Todo todo) {
		todoRepository.save(todo);
		
	}
}
