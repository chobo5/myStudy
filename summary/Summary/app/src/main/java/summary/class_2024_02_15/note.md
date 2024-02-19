### 복습
- 강의 내용
  - 복습(1)
  - AS(Application Server) 아키텍처에서 DB Connection 관리하는 방법 II
    - 프록시 패턴을 이용하여 Connection 프록시를 생성
  - 자동 생성된 PK 값 가져와서 자식 테이블의 데이터 입력하기
  - 테이블 관계를 클래스로 관계로 구현하기
  - 테이블과 DAO, Handler의 관계
  - 테이블 컬럼과 도메인 클래스의 필드 사이의 관계
- 과제
  - 개인 과제
- 실습 프로젝트
  - 트랜잭션 제어 기능을 분리하기
  - 외부키(Foreign Key) 사용하기
- 학습 점검 목록
  - 프록시 패턴을 설명할 수 있는가? []
  - insert 문을 실행할 때 자동 생성된 PK 값을 가져올 수 있는가? []
  - 테이블의 부모 자식 관계를 클래스의 관계로 표현할 수 있는가? []
  - 테이블과 DAO, Handler의 관계를 설명할 수 있는가? []



### 프록시 패턴
프록시 패턴은 실제 작업을하는 객체를 가지고 있는 클래스가 실제 작업을 하는 객체가 구현한 인터페이스와 같은 인터페이스를 구현한다.
- 기존 코드를 손대지 않고 변경하는 방법

### 57. 웹 어플리케이션 서버 아키텍처
- ClientApp -> WebBrowser
- ServerApp ->
  - WebServer, Servlet Container -> Tomcat으로 대체
    - Tomcat이 networking, HTTP 통신, 멀티스레딩을 처리함
  - App-> DBMS와 통신

### Tomcat Server
- Mini Web Server(HTTP 서버 역할)
  1. HTTP 프로토콜을 준수하는 요청이 들어오면 응답을 한다.(HTTP 서버 역할)
  2. 들어온 요청은 Servlet Container에 위임한다.
  3. 정적자원(html, css, javascript, jpeg...) 서비스(요청에 대한 응답결과가 항시 같다.)

- Servlet = Server App + let(작은것 - ex)bullet) = 작은 서버 App = 서버 App의 조각
- ex) 인사 관리 시스템(서버 App)
  - 직원 등록
  - 휴가 신청
  - 퇴사
  - 경력 증명 신청... -> 서버 App의 작은 기능 -> servlet


- Servlet Container(Java App 관리(생성-실행-소멸))
  1. Java App(동적자원 = 서비스 할 떄마다 결과가 달라질 수 있다.)을 실행시킨다
  2. Servlet Container는 Java 클래스를 관리한다.(생성-실행-소멸)
     - Java class는 javax.servlet.Servlet 인터페이스를 구현해야 한다.

### Servlet
- Servlet Container는 Servlet 인터페이스 규칙에 따라 구현한 java class를 실행한다.
- interface Servlet <-------- class HelloServlet
  - init(): 객체 생성후 호출
  - service(): 요청이 들어올 때마다
  - destory(): app이 종료될떄
  - ----서블릿 생명주기 메서드
  - getServletInfo()
  - getServletConfig()
  - 



