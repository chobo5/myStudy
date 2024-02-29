### 복습
- 강의 내용
    - 복습
    - 서블릿을 배치하는 방법
    - ServletContext, HttpSession, ServletRequest, JSPContext 저장소 사용법
- 과제
    - 개인 과제
    - GET/POST 요청 다루기
    - refresh/redirect 다루기
    - forward/include 다루기
- 실습 프로젝트
- 학습 점검 목록
    - ServletContext, HttpSession, ServletRequest, JSPContext의 생명주기를 설명할 수 있는가?
    - 서블릿 컨테이너가 Http 클라이언트를 구분하는 방법을 설명할 수 있는가?
    - 각 저장소에 따라 값을 공유하는 범위를 설명할 수 있는가?
    - Cookie의 동작원리와 요청/응답 프로토콜을 설명할 수 있는가?
    - Cookie의 유효기간과 사용범위를 설정할 수 있는가?
    - HttpSession과 Cookie의 관계를 설명할 수 있는가?
    - HttpSession의 활용을 예를들어 설명할 수 있는가?


### JSP(JavaServerPages) 도입
- JSP 소스는 JSP 엔진에 의해 자바 서블릿 소스로 컴파일 된다(form_jsp.java)
- 자바 서블릿소스는 컴파일 되어 자바 클래스 파일이 왼다.

- JspPage 인터페이스는 Servlet 인터페이스를 구현하고 있다
  - jspInit()
  - jspDestroy()
- HttpJspPaged 인터페이스는 JspPage를 구현하고 있다.
  - jspService()
- HttpJspBase 추상 클래스는 HttpJspPage와 HttpServlet을 구현하고 있다.
  - jspInit() {...} 메서드는 init() 메서드에서 호출한다.
  - jspDestroy() {...} 메서드는 destroy() 메서드에서 호출한다.
- 우리가 구현한 form.jsp는 HttpJspBase를 구현하고 있다.
  - jspService() {...}는 service() 메서드에서 호출한다.

### JSP와 MVC모델 1



### JSP와 MVC모델 2


