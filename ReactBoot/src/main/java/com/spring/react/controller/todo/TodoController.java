package com.spring.react.controller.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
			String username = "test"; // 로그인 기능 구현 안했기때문에 test로 사용

			List<Todo> todoList = todoService.selectTodoList(username);

			List<TodoDTO> todoDTOList = new ArrayList<TodoDTO>();

			for (Todo t : todoList) {
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
		} catch (Exception e) {
			ResponseDTO<TodoDTO> response = new ResponseDTO<>();
		}

	}

}
