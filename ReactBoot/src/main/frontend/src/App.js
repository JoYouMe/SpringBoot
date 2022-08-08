import "./App.css";
import { useState, useEffect, useCallback } from "react";
import TodoInsert from "./components/todos/TodoInsert";
import TodoList from "./components/todos/TodoList";
import TodoTemplate from "./components/todos/TodoTemplate";
import { call } from "./service/ApiService";

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    call("/api/todo/selectTodoList", "GET", null).then((Response) =>
      setTodos(Response.data)
    );
  }, []); //처음 렌더링 됐을때만 돌아가도록 설정

  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: todos.length + 1,
        text: text,
        checked: false,
      };
      setTodos(todos.concat(todo));
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
