import "./App.css";
import { useState, useEffect, useCallback } from "react";
import TodoInsert from "./components/todos/TodoInsert";
import TodoList from "./components/todos/TodoList";
import TodoTemplate from "./components/todos/TodoTemplate";
import { call } from "./service/ApiService";

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    call("/api/todo/selectTodoList", "GET", null).then((response) =>
      setTodos(response.data)
    );
  }, []);

  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: todos.length + 1,
        text: text,
        checked: false,
      };

      //setTodos 그냥 화면만 변경이 됨
      //setTodos(todos.concat(todo));

      //todo입력하고 db에 저장한 한 후에
      //다시 selectTodoList 해온 값을 리턴
      call("/api/todo/insertTodo", "POST", todo).then((response) =>
        setTodos(response.data)
      );
    },
    [todos]
  );

  const onRemove = useCallback(
    (id) => {
      setTodos(todos.filter((todo) => id !== todo.id));
    },
    [todos]
  );

  const onChecked = useCallback(
    (id) => {
      setTodos(
        todos.map((todo) =>
          id === todo.id ? { ...todo, checked: !todo.checked } : todo
        )
      );
    },
    [todos]
  );

  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert} />
      <TodoList todos={todos} onRemove={onRemove} onChecked={onChecked} />
    </TodoTemplate>
  );
}

export default App;
