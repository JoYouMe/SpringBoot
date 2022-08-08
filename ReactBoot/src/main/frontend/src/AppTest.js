import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";

function AppTest() {
  const [hello, setHello] = useState("");
  const [hello2, setHello2] = useState([]); //리스트를 받아오기 위해 배열로 선언
  const onClickHandler = () => {
    const test = {
      id: 3,
      name: "yumi",
    };
    //fetch 함수 사용 URL 적으면 자동으로 GET요청
    //  fetch('url')
    //  .then(콜백함수(수신한 데이터를 파라미터로 가져옴))
    fetch("http://localhost:8080/api/test2", {
      method: "POST",
      headers: new Headers({
        "Content-type": "application/json",
      }),
      body: JSON.stringify(test), //요청 body안에 데이터를 받아오는 방식
    })
      //위처럼 가져온 데이터를 출력하고싶으면 then함수 사용
      .then((response) => response.json())
      .then((json) => {
        setHello2(json);
      });
    // 에러처리.catch(()=>{})
    //  then함수 뒤에 if(!response.ok) {
    //     throw new Error('400아니면 500에러남')
    //  } 붙여줌
  };

  useEffect(() => {
    /* 리턴 타입이 String일 때
    fetch("http://localhost:8080/api/test", { method: "GET" })
      .then((response) => response.text())
      .then((text) => setHello(text));
    */
    //리턴 타입이 객체나 리스트 일 때
    //   fetch("http://localhost:8080/api/test2", { method: "GET" })
    //     .then((response) => response.json())
    //     .then((json) => {
    //       setHello2(json.data);
    //     });
  }, []);

  return (
    <div>
      {/* {hello2.map((h) => (
        <p id={h.id} key={h.id}>
          {h.name}
        </p>
      ))} */}
      <button type="button" onClick={onClickHandler}>
        전송
      </button>
    </div>
  );
}

export default AppTest;
