### 웹 어플리케이션의 종류
1. 화면으로 응답하는 어플리케이션(html, css 활용)
   - @Controller 어노테이션 사용
2. 데이터로 응답하는 어플리케이션(Json)
   - @RestController 어노테이션 사용

### MVC
- Model: 어플리케이션 상테(데이터)나 비즈니스 로직을 제공하는 컴포넌트
- View: 모델이 보유한 어플리케이션 상태(데이터)를 참조하고 클라이언트에 반환할 응답 데이터를
  생성하는 컴포넌트
- Controller: 요청을 받아 모델과 뷰의 호출을 제어하는 컴포넌트로 컨트롤러라는 이름처럼 
  요청과 응답의 처리흐름을 제어한다.

- application.yml에 대한 설정은 SpringAutoConfiguration이 읽어들인다.