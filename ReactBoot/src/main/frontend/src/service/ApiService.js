//fetch를 처리해주는 함수를 만들어서 export
import { API_BASE_URL } from "../app-config";

//api = "/api/todo/selectTodoList"
//method = "GET", "POST", "PUT", "DELETE"
//request는 백엔드로 보내줄 데이터
export function call(api, method, request) {
  //fetch 옵션 설정
  let options = {
    headers: new Headers({
      //보내줄 데이터의 타입 지정
      "Content-Type": "application/json",
    }),
    url: API_BASE_URL + api,
    method: method,
  };

  //보내줄 데이터가 있으면
  //request 바디에 담기
  if (request) {
    options.body = JSON.stringify(request);
  }

  //fetch 실행 후 결과 값 리턴
  return fetch(options.url, options).then((response) =>
    response.json().then((json) => {
      //api 오류 시 에러 리턴
      if (!response.ok) {
        return Promise.reject(json);
      }

      return json;
    })
  );
}
