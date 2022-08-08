import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [hello, setHello] = useState("");
  const [hello2, setHello2] = useState([]); //리스트를 받아오기위해 배열로 선언

  useEffect(() => {
    /* 리턴 타입이 String일 때
    fetch("http://localhost:8080/api/test", { method: "GET" })
      .then((response) => response.text())
      .then((text) => setHello(text));
    */

    //리턴 타입이 객체나 리스트 일 때
    fetch("http://localhost:8080/api/test2", { method: "GET" })
      .then((response) => response.json())
      .then((json) => {
        setHello2(json.data);
      });
  }, []);

  return <div>{hello}</div>;
}

export default App;
