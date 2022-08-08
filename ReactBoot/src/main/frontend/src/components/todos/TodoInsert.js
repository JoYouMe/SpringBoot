import React, { useState, useCallback } from "react";
import { MdAdd } from "react-icons/md";
import "../../styles/todos/TodoInsert.scss";

const TodoInsert = ({ onInsert }) => {
  const [value, setValue] = useState("");

  const changeValue = useCallback((e) => {
    setValue(e.target.value);
  }, []);

  const handleSubmit = useCallback(
    (e) => {
      onInsert(value);
      setValue("");

      //서브밋되면 화면이 새로고침되기 때문에 새로고침 방지
      e.preventDefault();
    },
    [onInsert, value]
  );

  return (
    <form className="TodoInsert" onSubmit={handleSubmit}>
      <input
        placeholder="할 일을 입력하세요."
        value={value}
        onChange={changeValue}
      ></input>
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default TodoInsert;
