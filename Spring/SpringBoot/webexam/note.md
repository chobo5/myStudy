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


### DispatcherServlet 동작 과정
1. 브라우저가 DispatcherServlet에 어떤 요청을 보낸다.
   1. Locale(지역화, L18N)을 결정한다(언어, 시간대 등)
   2. RequestContextHolder에 저장
   3. FlashMap 복원(redirect와 관련, 한번만 사용되어야할 정보)
   4. 멀티파트 요청?(POST방식으로 파일업로드를 Form을 통해서 할떄)
      - yes: MultipartResolver가 멀티파트 결정
      - no: 핸들러 결정과 실행
2. DispatcherServlet이 요청에 맞는 handler를 실행한다.
   - handler: @Controller가 붙은 해당 클래스의 메소드
3. 핸들러에서 String(템플릿 이름)을 리턴한다.
4. DispatcherServlet은 해당 문자열을 가지고 뷰 템플릿을 실행한다.
5. DispatcherServlet은 실행결과를 브라우저에 리턴한다.
