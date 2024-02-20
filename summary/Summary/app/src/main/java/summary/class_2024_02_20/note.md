### 복습
- 강의 내용
    - 복습
- 과제
    - 개인 과제
- 실습 프로젝트
    - 57. 웹 어플리케이션 서버 구조로 전환하기 - 웹 기술 도입
    - 58. 리스너 및 웹 어플리케이션 저장소 활용하기
- 학습 점검 목록
    - ServletContextListener를 설명할 수 있는가?
    - ServletContext를 설명할 수 있는가?
    - ServletContextListener를 구현하고 배포할 수 있는가?
    - ServletContext에 공유 객체를 저장하고 꺼내서 사용할 수 있는가?

### Web

- HTML과 HTTP프로토콜의 탄생 배경(실습프로젝트7.pdf page 1~)

### C/S Architecture와 Web Application Architecture
1. Cleint/Server Architecture
- Client ---DB에 직접 접근---> DBMS
  - 클라이언트가 DB에 직접 접근하기 때문에 DB에 접속할 아이디와 패스워드가 클라이언트 측에 있어 보안 위험이 높다.
  - 기능 변경 때마다 재배포하여 client가 업데이트 해야한다.
2. Web Application Architecture
- Web Browser(클라이언트) <-- 응답 HTTP 요청 --> Web Server --실행--> App --> DBMS
  - DBMS접속이 서버에서 이루어지므로 아이디 패스워드가 노출될 위험이 적다.
  - 모든 리소스는 서버에서 제공하고 client는 받은 리소스를 화면에 나타내기만 하므로 재배포시 업데이트가 필요하지 않다.


### Web Application의 2가지 Architecture
1. Monolithic Architecture
  - 한개의 서비스나 웹 어플리케이션에 모든 기능을 담는 방식
  - 장점
    - 기능간의 연결이 쉽다 - 직접 메소드 호출이 가능하다.
    - 데이터의 공유가 용이하다.(Session, DB)
  - 단점
    - 기능 변경시 전체 서비스를 재시작 해야한다.
    - 일부 기능만 동작하거나 정지시킬 수 없다.
    - 특정기능에만 더 많은 자원을 할당할 수 없다.
    - 강한 결합 - 상호기능이 매우 의존적이다.
2. MicroService Architecture
  - 기능별로 서비스를 분리하는 방식
  - 장점
    - 특정 서비스만 동작하거나 정지 시킬수 있다.
    - 기능 변경시 해당 기능만 배포하면 된다.
    - 특정 기능에 자원을 더 할당시킬 수 있다.
  - 단점
    - 반복적인 부가작업이 늘어난다.
    - -> 기능간의 연동시 오버헤드가 발생하기 쉽다.
    - 세션 유지및 관리가 어렵다(세션과 DB가 달라 관리가 어렵다(세션에서 로그인정보 공유 불가, sql join 불가))
    - DB의 데이터 무결성 관리가 어렵다(일부 데이터는 중복될수 밖에 없다.)

### Java Web Application
- Java EE(Enterprise Edition)
- 기업에서 사용할 application을 만드는데 필요한 기술과 도구를 제공한다.

1. 개인용 App
  - 단일 사용자용
2. 기업용 App
  - 다중 사용자용
  - 동시 접속제어(통신, 멀티 테스킹)
  - 사용자 인증/권한 제어
  - 자원 관리
  - Application 분산 처리

**Java EE는 이러한 다중 사용자용 App 개발에 필요한 기술 모음 및 도구 모음을 제공한다.**

### Servlet과 RESTful
- App <-응답 HTTP 요청-> JavaEE Server <-return call-> 서블릿 
  - App은 어떠한 프로그래밍 언어로 만들어지든 상관 없다.
    - HTTP 요청은 프로그래밍 언어와 상관없기 때문에(플랫폼, 기술로 부터 독립적이다)
  - App에서 Http 요청을 통해 원격의 서블릿을 실행시키는 방법
  - EJB 방식은 stub가 자바객체이기 때문에 Java App에서만 사용할 수 있다.
  
  
### Java EE와 서버
**Java EE 기술**
- 웹 기술
- 분산 컴포넌트 기술
- 분산 서비스 기술
- 자원관리
- 등등..

1. Java EE Implementation Server
- Java EE 기술 명세에 때라 동작하도록 구현한 서버이다
- Java EE의 전체기능을 구현하였다.
- ex) JBOSS, WebLogic, WebSphere, JEUS, Geronimo, GlassFish 등...

2. Servlet Container
- Java EE의 기술 중 웹 기술만 구현하였다.(Servlet, JSP, JSTL, EL등..)
- ex) Tomcat, Resin, Jetty, Undertow등


### Web 프로젝트 표준 디렉토리 구조
- app/
  - build/
    - classes/
      - java/ <- classpath
        - main/
          - com/
            - eomcs/
              - App.class
  - src/
    - main/
      - java/ <- 자바 소스폴더
        - com/ <- 루트 패키지
          - eomcs/
              - App.java
      - resources/ <- 자바 소스 폴더
      - webapp/
        - WEB-INFO
          - web.xml(component의 배치 정보를 기술할 파일)
          - 기타 웹어플리케이션 관련 설정 파일
        

