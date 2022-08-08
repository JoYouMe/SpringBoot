package com.spring.react.controller.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.react.dto.ResponseDTO;
import com.spring.react.dto.TodoDTO;
import com.spring.react.entity.Todo;
import com.spring.react.service.todo.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/selectTodoList")
	public ResponseEntity<?> selectTodoList() {
		try {
			String username = "test";
			
			List<Todo> todoList = todoService.selectTodoList(username);
			
			List<TodoDTO> todoDTOList = new ArrayList<TodoDTO>();
			
			for(Todo t : todoList) {
				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setId(t.getId());
				todoDTO.setUsername(t.getUsername());
				todoDTO.setText(t.getText());
				todoDTO.setChecked(t.isChecked());
				
				todoDTOList.add(todoDTO);
			}
			
			ResponseDTO<TodoDTO> response = new ResponseDTO<>();
			
			response.setData(todoDTOList);
			
			return ResponseEntity.ok().body(response);
		} catch(Exception e) {
			ResponseDTO<TodoDTO> response = new ResponseDTO<>();
			response.setError(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@PostMapping("/insertTodo")
	public ResponseEntity<?> insertTodo(@RequestBody Todo todo) {
		try {
			String username = "test";
			
			todo.setUsername(username);
			
			//DB에 새로운 Todo 저장
			todoService.insertTodo(todo);
			
			//새로 저장된 내용까지 가져오는 TodoList
			List<Todo> todoList = todoService.selectTodoList(username);
			
			List<TodoDTO> todoDTOList = new ArrayList<TodoDTO>();
			
			for(Todo t : todoList) {
				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setId(t.getId());
				todoDTO.setUsername(t.getUsername());
				todoDTO.setText(t.getText());
				todoDTO.setChecked(t.isChecked());
				
				todoDTOList.add(todoDTO);
			}
			
			ResponseDTO<TodoDTO> response = new ResponseDTO<>();
			
			response.setData(todoDTOList);
			
			return ResponseEntity.ok().body(response);
		} catch(Exception e) {
			ResponseDTO<TodoDTO> response = new ResponseDTO<>();
			response.setError(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}
