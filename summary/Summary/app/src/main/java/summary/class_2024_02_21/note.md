### 복습
- 강의 내용
    - 복습
    - Web 기술 소개
    - Web Application의 등장 배경과 활용 소개
- 과제
    - 개인 과제
- 실습 프로젝트
    - 57. 웹 어플리케이션 서버 구조로 전환하기 - 웹 기술 도입
    - 58. 리스너 및 웹 어플리케이션 저장소 활용하기
- 학습 점검 목록
    - HTML, HTTP 즉 Web 기술의 등장을 설명할 수 있는가?
    - 웹 기술이 활용되어 온 과정을 설명할 수 있는가?
    - CGI와 CGI프로그램을 설명할 수 있는가?
    - CGI 프로그램을 개발할 때 스크립트 언어를 주로 사용하는 이유를 설명할 수 있는가?
    - C/S 아키테거와 Web Application Server 아키텍처를 설명할 수 있는가?
    - 모놀리식 아키텍처와 마이크로서비스 아키텍처를 설명할 수 있는가?
    - Java EE에 대해 설명할 수 있는가?
    - 기업용 프로그램을 설명할 수 있는가?
    - Servlet 기술과 EJB기술을 설명할 수 있는가?
    - RESTful 기술을 설명할 수 있는가?
    - 원격 메서드 호출 기술에 대해 이해하는가?
    - JavaEE 구현 서버에 대해 설명할 수 있는가?
    - JavaEE 구현 서버와 서블릿 컨테이너를 설명할 수 있는가?
    - JavaEE 버전과 구현 서버의 버전 관계를 이해하는가?
    - JavaEE 와 JakartaEE의 관계를 설명할 수 있는가?
    - 자바 웹 프로젝트를 생성하고 톰캣 서버를 기본 장착하여 실행할 수 있는가?


### 분산 컴포넌트

각기 다른 세개의 서버에 다음과 같이 컴포넌트가 배치되어 있다. -> 분산 컴포넌트
Server1(월급 정산 Handler), Server2(EmployDao), Server3(PayDao)

1. Server1의 Handler는 Server2의 EmployDao의 객체(원격 객체 - 컴포넌트)의 메서드를 호출한다.
2. Server1이 1의 결과를 리턴받는다
3. Server1의 Handler는 Server3의 PayDao의 객체(원격 객체 - 컴포넌트)의 메서드를 호출한다.
4. Server1이 2의 결과를 리턴받는다.


### Servlet 객체 생성 과정

1. ServerApp 실행
2. Servlet Container 생성
3. 특정 url에 접속
4. 해당 Servlet 객체 생성
    1. new -> 생성자 호출
        2. init() 호출
        3. service() 호출


### 서블릿 배치방법

1. 어노테이션 ex) @WebServlet
2. XML: /WEB-INF/web.xml


### GenericServlet

- Servlet 인터페이스를 구현한 추상 클래스
- service() 메서드는 구현하지 않았다.
- Serializable 인터페이스를 구현하고 있다.
    - Serializable 인터페이스를 구현하게 되면 해당 객체를 읽거나 쓸수 있도록 하거나 다른 서버 보내거나 받을수 있다.
    - serialVersionUID를 설정할 수 있다.


### HttpServlet

- GenericServlet을 구현한 추상 클래스
- GenericServlet에서 구현하지 않은 service() 메서드를 구현하고 있다.
```java
protected void service(ServletRequest req, ServletResponse resp) {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    service(request, response);
        }

protected void (HttpServletRequest request, HttpServletResponse response) {
    // 요청에 따라 doGet(), doPost, doDelete 등을 호출하도록 짜여져있다.
        }
```
- 다음과 같이 service() 메서드는 구현되어 있다.
- 따라서 개발자는 요청에 따라 doGet(), doPost(), doDelete() 메서드등을 재정의하면 된다. 


### Filter 만들기
- Filter 인터페이스를 구현한다.
  - init() - 웹 어플리케이션이 실행되는 시점에 호출된다.
  - doFilter(request, response, chain) - 서블릿 요청에 필터가 적용되면 실행된다.
  - destory() - 웹 어플리케이션 종료시 실행된다.








