# Spring

---

## 1. Bean이란?

일반적으로 java에서 instance 생성은
```agsl
Book book = new Book();
```
다음과 같이 하지만, Bean은 Container가 관리하는 객체를 의미한다.

- 객체(Bean)의 생명주기(생성, 소멸)를 Container가 관리한다.
- 객체를 싱글턴으로 만들지, 프로토타입으로 만들것인지 등을 Container가 자동으로 설정하고 관리해준다.
- 따라서 프로그래머가 직접 객체를 생성하지 않고 Container를 통해 생성, 관리 되도록한다.


### 1-2. Spring의 핵심기능
- container - 관점지향(AOP - Aspect Oriented Programming)

### 1-3. Spring 사용 방법
1. 설정파일을 만든다(xml, )

---

## 2. ApplicationContext 와 XML설정파일 읽어들이기
### 2-1. Applcation Context
- ApplicationContext는 다양한 interface를 상속받고 있다.
- Spring Container의 핵심 interface

```agsl
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html

Package org.springframework.context
Interface ApplicationContext
```
<br>

- ApplicationContext는 BeanFactory의 자식 Interface이다.

```agsl
Package org.springframework.beans.factory
Interface BeanFactory
```


### 2-2. ApplicationContext를 구현하고 있는 대표적인 클래스
```agsl
Package org.springframework.context.support 
Class ClassPathXmlApplicationContext
```
ClassPathXmlApplicationContext을 사용하려면 <br>
Package org.springframework.context.support를 다운받아야한다.


### 2-3. Spring Framework의 핵심 모듈
![height:400](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/images/spring-overview.png)
- Core Container 부분이 가장 핵심적이다.

### 2-4. Spring Framework의 핵심 모듈 사용하기
https://mvnrepository.com/artifact/org.springframework/spring-core
5.3.23(강의기준) build.gradle에 core, context 라이브러리를 불러온다.

```agsl
implementation 'org.springframework:spring-core:5.3.23'
implementation 'org.springframework:spring-context:5.3.23'
```
- context를 추가하면 나머지 Core Container도 가져온다.


### 2-5. ApplicationContext xml설정 파일
SpringApplicationContextExam

---

## 3.AnnotationConfigApplicationContext , JavaConfig, Component Scan 

### 3.1 xml파일을 통한 설정은 불편하다
- (IDE가  error를 찾기 어렵고, java개발자가 xml파일을 작성하기는 짜증난다.)

```agsl
Package org.springframework.context.annotation
Class AnnotationConfigApplicationContext
```


### 3.2 AnnotationConfigApplicationContext

- AnnotationConfigApplicationContext(Spring 3.0) 등장
    - (ClassPathXmlApplicationContext는 Spring의 등장과 함께 생김)
- Annotation 기반(aka.Java Config, Component Scan을 한다.)

---

## 4. Servlet이 실행되는 환경 이해하기
### 4.1 Web Application

 - 웹 브라우저에서 이용할 수 있는 응용 소프트웨어(youtube, naver, google, coupang...)

### 4.2 Web Application Server(WAS)

 - Java에서는 보통 Java EE 표준준수 웹 어플리케이션 서버를 말한다.
   - 스프링, 스프링부트를 사용하는 사용자는 이것을 WAS라고 부른다.

### 4.3 Java EE에 대한 표준을 일부 준수
- 아파치 톰캣(Apache Tomcat)
  - javax.servlet spec을 구현하고 있음

### 4.4 Java EE 에서 Jakarta EE로의 전환

### 4.5 Java 웹 프로그래밍
1. Java언어로 웹어플리케이션을 만들겠다.
2. 웹 어플리케이션을 실행할 WAS가 필요하다.
3. Servlet/JSP를 실행할 수 있는 환(Servlet Container)
   - JSP도 알고보면 Servlet 기술로 만들어진다.
   - Servlet Container는 WAS안에 있다.
   - WAS는 여러개의 WebAppliation을 실행할 수 있다.
     - 대표적인 WAS로 Tomcat이 있다.


### 4.6 Tomcat
- apache-tomcat-10.1.16 다운로드(tar.gz)
- tar xvfz apache-tomcat-10.1.16.tar.gz 압축해제
- cd apache-tomcat-10.1.16/bin
- ./startup.sh 서버 실행
- ./shutdown.sh 서버 종료

#### 4.6.1 startup.sh을 수정하고 실행한다
tomcat Server가 background에서 실행되기 때문에 무슨일이 일어나는지 보이지 않기때문에
  
```agsl
exec "$PRGDIR"/"$EXECUTABLE" start "$@"
exec "$PRGDIR"/"$EXECUTABLE" run "$@" 로 변경
```

- foreground에서 실행되며 실행과정이 보인다. 
  - 종료 - ctrl + c

#### 4.6.2 Tomcat이 기본으로 제공하는 Web Application
apache-tomcat-10.1.16/webapp
```agsl
drwxr-x---@  7 wonjun-yeon  staff   224 11 11 01:17 .
drwxr-xr-x  16 wonjun-yeon  staff   512 12  7 21:27 ..
drwxr-x---@ 13 wonjun-yeon  staff   416 11 11 01:17 ROOT
drwxr-x---@ 61 wonjun-yeon  staff  1952 11 11 01:17 docs
drwxr-x---@  8 wonjun-yeon  staff   256 11 11 01:17 examples
drwxr-x---@  7 wonjun-yeon  staff   224 11 11 01:17 host-manager
drwxr-x---@  9 wonjun-yeon  staff   288 11 11 01:17 manager
```

#### 4.6.3 Tomcat이 성공적으로 실행되었다면
- http://localhost:8080/
  - ROOT 웹 어플리케이션 
- http://localhost:8080/docs/
  - docs 웹 어플리케이션 
- http://localhost:8080/examples/
  - examples 웹 어플리케이션

### 4.7 Tomcat을 이용한 웹 어플리케이션을 만든다는 의미는?
- webapps/ROOT의 내용을 내가 만든 내용으로 바꿔 나의 웹어플리케이션을 만든다.
  - 'deploy한다' 라고 한다.

### 4.8 서버와 브라우저의 동작
1. Tomcat Server를 실행한다.
    - mac OS 위에서 실행된다(8080 포트)
        - 단, 각 서버마다 포트값이 다르다.
2. 브라우저로 접속한다.
   - 서버에 접속하기 위해 pc의 ip주소를 얻어 http://ip주소:8080에 접근
   - 운영체제가 8080포트를 보고 Tomcat 서버에 연결
3. 브라우저와 서버가 같은 컴퓨터 안이라면
   - ip주소 = 127.0.0.1 or domain이름 = localhost
 
### 4.9 웹 어플리케이션을 만드는 방법
- 4.7의 과정을 IDE(Eclipse, intelliJ)가 손쉽게 해준다.

<br>
intelliJ에서 만들기

 - 프로젝트 이름: ServletExam
 - http://localhost:8080/ServletExam_war_exploded/
   - 우리가 만들 Application이 ROOT Web Application이 아니다.
   - src/main/webapp/index.jsp가 실행됬음

<br>
   
http://localhost:8080 으로 실행되려면?
- Edit Configuration -> Deployment(배포) -> Application context를 / 만 남긴다

---

## 5.Http 프로토콜과 서블릿이 실행되는 과정 이해하기
1. 브라우저로 http://google.com(google.com = 도메인주소)을 입력하면
2. OS 의 DomainNameServer(DNS)에 도메인주소를 활용해 google의 IP를 얻는다.
   - Terminal 명령어 nslookup을 사용해 확인할 수 있다.
   - http://google.com 뒤에는 :80/가 생략되어있다.
3. IP에 접속한다.
4. 요청 정보를 서버에 보낸다(요청라인 + 헤더 + 빈줄 + 바디)
5. Body에 index.html, css, javascript 파일들이 포함된다.
6. html문서에서 img 태그를 보고 서버에게 요청한다.


### 5.1 intelliJ로 프로젝트를 생성하면 자동으로 만들어주는 Servlet이 있다.
- HelloServlet 파일로 이동
- class HelloServlet은 HttpServlet을 상속받고 있다. 그래서 Servlet이라고 한다.

### 5.2 Servlet 이란?
- HttpServlet을 상속받고 있는 class를 말한다.
  - HttpServlet은 http요청을 처리해주는 클래스이다.
  - JSP도 특수한 Servlet이다.

#### 5.2.1 Servlet 실행
```angular2html
@WebServlet(name = "helloServlet", value = "/hello-servlet")
```
1. http://localhost:8080/hello-servlet 접속
2. 서버에게 GET /hello-servlet 이라는 요청을 보낸다.
3. 서버에 ____/hello-servlet(언더바 부분을 Application context부분이라고함)라는 요청이온다
   - Application context가 /로 된것을 찾아 Tomcat이 대신 실행한다.
   - 즉 Tomcat이 HelloServlet 클래스를 대신 실행한다.
     - doGet이라는 메서드를 실행한다.(GET이라는 요청을 받았기 때문에)
     - HttpServletRequest, HttpServletResponse을 Tomcat이 넣어준다.
     - 그 결과를 응답으로 보낸다.

### 5.3 Tomcat이 http요청을 처리하는 방법
keyword: 관련된을 모은다 -> 응집도가 높다.
- tomcat은 Java로 만들어진 프로그램이다.
- Tomcat은 브라우저로 부터 받은 요청을 HttpServletRequest에 넣어준다.
- Tomcat은 누구에게 응답할지를 알기 때문에 미리 HttpServletResponse을 생성한다.
- 이렇게 두개의 인스턴스가 생성된다.
- GET요청이 왔기 때문에 2개의 인스턴스를 doGet메서드의 parameter로 넣어준다.
- 그리고 개발자는 두개의 인스턴스를 이용해 프로그래밍 한다.

---

## 6. Servlet, JSP라이프 싸이클, Servlet vs JSP , 포워딩 맛보기

<br>

### 6.1 Java Web Application을 WAS에 배포하는 방법

- WEB-INF 폴더가 있어야한다.
  - web.xml(discriptor) - 웹어플리케이션을 설명하는 파일  
  - classes 폴더
    - 우리가 만든 class들
  - lib 폴더
    - 라이브러리 파일(~.jar)
- html, jsp, js, 이미지들

1. 이것들을 하나의 파일로 묶어 압출시킬 수 있다(ex- ROOT.war)
2. 이 파일을(.war) WAS에 배포한다.
   - ROOT.war은 자동으로 압축이 해제된다.
3. WAS가 서비스를 해준다.
4. WAS가 8080포트로 동작하고 있다면, http://localhost:8008/index.jsp을 입력했을때 WAS에 요청을 보내고 WAS가 요청을 처리해 응답을 보낸다.
   
1, 2과정을 intelliJ가 해준다.

### 6.2 class HttpServlet
Methods
- init()
- destory()
- service() <- parameter로 request, response

#### 6.2.1. Servlet 실행과정
1. 사용자가 /hello-servlet 으로 요청을 보낸다.
2. /hello-servlet이라는 url path로 등록된 servlet을 찾는다.
3. 메모리에 있는지 확인한다.
   - 있다면 (2번째 이상 실행)
     - service() 바로 호출
   - 없다면 인스턴스를 생성한다.(첫번째 실행)
     - init() 호출
     - service() 호출
즉, Servlet은 메모리에 하만 올라간다.

       
### 6.3 JSP
- 특수한 형태의 서블릿
- MicroSoft사의 스크립트 기술을 보고 Java에서 만듬

```angular2html
/System/Volumes/Data/Users/wonjun-yeon/Library/Caches/JetBrains/IntelliJIdea2023.3/tomcat/e2a561d4-3212-40cb-897d-c2d805fec4ad/work/Catalina/localhost/ROOT/org/apache/jsp
```
WAS는 다음과 같은 작업을 실행한다.
1. index.jsp가 처음 실행되면
2. 위의 경로에 index_jsp.java가 생성되고 이파일에 문법적 오류가 없으면
3. index_jsp.class가 생성되어 실행된다.
4. 2번쨰 이상 실행되면 _jspService()가 바로 호출된다.

#### 6.3.1 index_jsp

- index_jsp파일은 org.apache.jasper.runtime.HttpJsBase 를 상속받는다.
- HttpJsBase는 HttpServlet과 같은 역할
- Servlet init() = _jspInit()
- Servlet destory() = _jspDestroy()
- Servlet service() = _jspService(req, resp)

#### 6.3.2 _jspService() 메서드
```angular2html
파라미터
final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response

지역 변수
final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;
```
다음과 같은 변수들이 선언되어있다.(JSP 내장변수)

```angular2html
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>JSP - Hello World</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>");
      out.print( "Hello World!" );
      out.write("</h1>\n");
      out.write("<br/>\n");
      out.write("<img src=\"Java_Logo.png\">\n");
      out.write("<a href=\"hello-servlet\">Hi Servlet</a>\n");
      out.write("</body>\n");
      out.write("</html>");
```
Servlet과 같이 html을 출력해준다.
Servlet과 전체적으로 비슷하며
index_jsp.java가 생성후 컴파일해 index_jsp.class를 만드는 부분만 다르다.

다른점
- Servlet은 클래스파일로 되어있고
- JSP는 일반적인 text파일처럼 되어있다.

따라서 그 역할을 구분하여 사용한다.

### 6.4 Servlet vs JSP
- Servlet은 Java코드
  - java 코드를 넣어서 개발한다.
  - 자바코드로 작성하는 비즈니스 로직
  - 하지만 HTML, CSS입력이 어렵

- JSP
  - HTML
  - Java코드를 넣을 수 있다.(하지만 되도록 넣지 않는다.)
  - 프론트개발자, 퍼플리셔들과 코드가 섞인다.
  - => 사용하지말고 다른 템플릿 기술을 사용하자.(Thymeleaf 등등..)
    
=> DMBS가 관리하는 DataBase의 Tabled에서 CRUD하는 객체(DAO)를 만들어
프로그래밍한다(데이터 베이스 프로그래밍)
데이터베이스 프로그래밍 기술
- JDBC
- Spring JDBC
- MyBatis 등등
- ![스크린샷 2023-12-09 오후 6.22.37.png](..%2F..%2F..%2F..%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-12-09%20%EC%98%A4%ED%9B%84%206.22.37.png)