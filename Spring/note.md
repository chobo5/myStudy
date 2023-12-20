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
3. Servlet/JSP를 실행할 수 있는 환경(Servlet Container)
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
keyword: 관련된것을 모은다 -> 응집도가 높다.
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
  - web.xml(descriptor) - 웹어플리케이션을 설명하는 파일  
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
즉, Servlet은 메모리에 하나만 올라간다.

       
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
    
=> DMBS가 관리하는 DataBase의 Table 에서 CRUD하는 객체(DAO)를 만들어
프로그래밍한다(데이터 베이스 프로그래밍)
데이터베이스 프로그래밍 기술
- JDBC
- Spring JDBC
- MyBatis 등등
- ![스크린샷 2023-12-09 오후 6.22.37.png](..%2F..%2F..%2F..%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-12-09%20%EC%98%A4%ED%9B%84%206.22.37.png)

---

## 7.서블릿에서 JSP로 포워딩하기, EL표기법맛보기, Heroku에 웹 어플리케이션 배포하기

### 7.1 index.jspd의 Plus form
- http://localhost:8080/
  - ==> index.jsp를 요청
  - http://localhost:8080/index.jsp

webapp/index.jsp를 webapp/form/index.jsp로 이동
= http://localhost:8080/form/
= http://localhost:8080/form/index.jsp

```angular2html
<form method="get" action="/plus"> <!-- 초보들이 /를 빼먹는 실수를 자주한다.-->
    x: <input type="text" name="x"> <br>
    y: <input type="text" name="y"> <br>
    <input type="submit" value="plus">
</form>
```
- submit을 하면
  - http://localhost:8080/form/plus?x=50&y=100
    - action="plus"이면 상대경로이고
    - http://localhost:8080/form/ + plus 이런식으로 호출하지만
    - http://localhost:8080/plus <--이게 호출되어야한다.

---

## 8. Spring 프레임워크를 이용해 hello 출력하기

#### 8.1.1 서블릿에서 서블릿 인스턴스를 생성하는 것은 누구일까?

우리는 HelloServlet hello = new HelloServlet(); 이라는 코드를 작성한적이 없음
<br>
- Tomcat 이라는 WAS가 생성함
- /hello요청을 받으면, 해당 PATH를 처리하는 서블릿이 메모리에 있는가?
  - 없다면 hello.init() 실행
  - 있다면 hello.service(req, resp); 실행
    - GET방식으로 요청했다면 WAS가 doGet(req, resp)호출
      - service나 doGet을 overriding하면 service가 동작한다.

#### 8.1.2 Bean이란?
- Spring Container가 관리하는 객체

#### 8.1.3 Spring으로 WebApplication 만들기
-----WEB-INF --- classes --- 개발자가 만든 package, class 등<--
             --- lib --- spring과 관련된 각종 jar파일          |
             --- web.xml 알맞은 설정 -> javaConfig로 설정------
             --- 각종 리소스 hello.png // 포워딩하는 경로로는 접근할 수 있다.
-----각종 이미지, JSP, logo.png

이것들은 전부 묶어서 war파일을 만듬 -> Tomcat 서버에 배포

### 8.2 SpringWeb 프로젝트생성(Java EE)
- 오른쪽 코끼리 아이콘 Tasks/build/war 더블클릭
- 왼쪽 navigation에 build/libs/war파일 생성

External Libraries/Gradle: javax.servlet/javax.servlet/http/HttpServlet을 상속받아 만든다.
build.gradle에 compileOnly('javax.servlet:javax.servlet-api:4.0.1')는
배포 단계에서는 Tomcat이 HttpsServlet을 가지고 있어 lib폴더에 servlet이 필요없지만 컴파일시 IDE는 필요하기때문에 compileOnly다.


### 8.3 Spring 설정파일 작성(WebConfig.java)

```angular2html
@Configuration //Spring Java Config
@EnableWebMvc //xml에서는 <mvc:annotation-drive />
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig가 실행됩니다.");
    }
}
```
- Spring 설정을 읽어들이는것은 ApplicationContext interface를 구현하고있는 Container(스프링컨테이너)
  - web.xml, Servlet파일 등은 Tomcat이 이해할수 있지만 Java Config는 Tomcat이 이해할 수 없다.
  - -> ApplicationContext가 읽어들이도록 해야한다.
  - Spring이 제공해주는 WebApplicationInitializer interface를 구현한 class 생성
    - onStartup을 overriding하면 Tomcat이 실행되면서 자동으로 실행시켜준다.
      - Tomcat이 실행될떄 자동으로 읽어들이는 파일을 Spring jar파일이 제공하는데
      - 자동으로 제공하는 클래스가 WebApplicationInitializer를 구현하고 있는 클래스를 실행한다.


DispatcherServlet이란?

### 8.4 Spring MVC의 핵심 서블릿

- DispatcherServlet

1. 브라우저가 /hello 요청을 보내면 Tomcat이 받는다.
2. Tomcat이 /hello 경로가 붙어있는 Servlet을 실행한다.
3. 이때, 브라우저가 보내는 모든 요청을 /라고 설정된 Servlet(DispatcherServlet)이 다 받는다.
   - 모든 요청을 다 받기 때문에 단일 진입점 or frontController라고 한다.
왜? 
- DispatcherServlet이 ApplicationContext를 가지고 있다.
- ApplicationContext가 Bean을 관리한다.

#### DispatcherServlet을 사용하는 이유
1. Spring을 사용한다는것은 Spring Container가 Bean을 관리해주길 바라는것인데, 
2. HttpServlet은 Tomcat이 관리하기 때문에, 일단 Servlet이 모든 요청을 받아들이도록 하고
3. Servlet과 유사한 기능을 제공해주는 Controller라는 Bean을 생성한다.
4. Controller("/hello")을 생성하게 되면
5. 브라우저로부터 /hello라는 요청을 받고 DispatcherServlet이 /hello를 처리해주는 Controller에게 요청을 넘긴다.

---

## 9. Spring MVC - DefaultServlet, ViewResolver의 동작에 대한 이해

### 9.1 이미지와 jsp 호출하기

http://localhost:8080   +   Context Path(/)   +   PATH(/car.png)   +   ? 파라미터들
내컴퓨터의 8080서버에 접속

http://localhost:8080/car.png

        /car.png                    / (단일 진입점)
브라우저 -------> Tomcat ------> 서블릿(DispatcherServlet) ------> ApplicationContext ------> Bean(Controller("/car.png"))
<br>
                                                       ------> Tomcat DefaultServlet ---> /webapp/car.png
- img,html등은 정적파일이다.
- car.png를 처리하는 Bean이 없음으로 404를 띄운다.
- WebApplicationInitializer는 DispatcherServlet을 등록해주고 Spring이나 Bean에 대한 설정은 WebConfig가 설정해줬음
- 만약 car.png를 처리하는 Controller가 없다면 DispatcherServlet이 Tomcat의 DefaultServlet에게 떠넘긴다.


http://localhost:8080/hello.jsp
        /hello.jsp                    / (단일 진입점)
브라우저 -------> Tomcat ------> 서블릿(DispatcherServlet) ------> ApplicationContext ------> Bean(Controller(없음))
<br>
                                                        ------> Tomcat DefaultServlet ---> hello.jsp

 - JSP에서는 Java코드를 최대한 줄이고
 - 결과는 Servlet or Controller에서 만들고 JSP에게 결과를 전달한다.


### 9.2 Spring MVC는 여러개의 ViewResolver를 가질 수 있다.
- Spring Container는 ViewResolver 인터페이를 구현하고 있는 Bean이 어떤것들이 있는지 알고 있다.
- ViewResolver인터페이스를 구현하는 Bean을 가질 수 있다.
- Spring은 사용자가 JSP를 사용하도록 설정한것을 알고있다. 그런데 Bean중에 InternalResourceViewResolver가 있다면
- Controller가 리턴하는 문자열을 InternalResourceViewResolver가 처리하도록한다.
        /hello                    / (단일 진입점)
브라우저 -------> Tomcat ------> 서블릿(DispatcherServlet) ------> ApplicationContext ------> Bean(Controller("/car.png"))
<br>                                                                ---> Controller가값을리턴 ---> InternalResourceViewResolver가 동작하며
                                                                                           /WEB-INF/view/hello.jsp로 포워딩한다

### 9.3 JSP는 결과를 보여주는 역할만


webapp/WEB-INF/view/hello.jsp 로 옮김

http://localhost:8080//WEB-INF/view/hello.jsp

--> 404 error

#### 9.3.1 WEB-INF폴더는 외부에서 접근할 수 없다.
- /WEB-INF는 서버 내부에서는 포워딩할 수 있다.


### 9.4 Controller와 ViewResolver
- Controller는 로직을 수행하여 결과를 만들어낸다 --- InternalResourceViewResolver의 조건을 충족 ---> jsp는 결과만 출력한다.
- Controller는 로직을 수행하여 결과를 만들어낸다 ----------------------------------------------> Excel파일을 다운로드 하도록 할 수 있다.

---

## 10. DataSource 선언하기 (@PropertySource와 Environment를 이용)

브라우저 ----- /hello ----> Tomcat -- /(모든요청) ---> DispatcherServet ---요청을 넘김----> Controller("/hello")
----결과----> JSP ---> 브라우저

### 10.1 Controller가 결과를 만드는 방법
Controller의 메서드의 가장 중요한 역할
 - httpRequest를 받아서 httpResponse를 만들어내는게 목적
 - 데이터베이스 프로그래밍(JDBC) 응답을 위해 DBMS(MySQL) 사용
   - JDBC 프로그래밍을 좀더 간결하게 하는 방법 ---> Spring JDBC, Spring Data JPA(ORM기술), MyBatis
 - DBMS안에는 여러개의 DataBase가 있을 수 있다.
   - DataBase는 특정 사용자만 이용할 수 있다. 특정 사용자는 DBMS에서 관리되는 사용자를 말한다.
   - Database 안에는 Table이 있다. 회원정보는 회원Table에, 상품정보는 상품Table에 저장한다.


### 10.2 Database 프로그래밍
1. SQL - SQL성능이 안나오면 실행계획을 볼줄 알아야 한다.
2. SQL을 이용해서 JDBC 프로그래밍(데이터 베이스 프로그래밍)
3. Spring JDBC
4. Spring Data JPA(ORM기술) - 직접 SQL을 사용하지 않아도 된다. (내부적으로 SQL을 생성하여 동작) - 어떤 SQL을 생성할것인지 예상할 수 있어야함

데이터 베이스 프로그래밍을 통해 데이터를 다루는 객체를 다루게 됨(DAO - Data Access Object, Repository)
1. 비즈니스 로직을 수행(Service)
   - 이자계산, 특정 사용자가 주문한 상품의 전체 가격을 구한다.
   - 트랜젝션(Transaction)
     - 여러개의 DAO or Repository를 하나의 논리적인 작업 단위로 실행할 수 있어야 한다.
     
2. 하나의 Controller는 여러개의 Service를 사용해서 어떤 결과를 만들어 낼 수 있다.
3. DTO(Data Transfer Object) 각각의 layer(Controller, Service, Dao)를 넘나드는 객

---

## 11. Spring Data JPA 설정하기

### 11.1 DB 사용법
1. DBMS에 접속, SQL 전송
2. DB에서 SQL 실행
3. SQL 실행결과 수신
4. DBMS 접속 close

비용이 발생한다.
비용이 많이 발생했다.
- 시간이 오래걸린다.
- CPU 사용량이 많다.
- 메모리 사용량이 많다

**JDBC프로그래밍에서 DBMS 접속에서 비용이 많이 발생한다.**
- 따라서 접속과 close의 반복은 많은 비용을 발생시킨다.

### 11.2 커넥션 풀
1. Java로 만든 DBMS를 사용하는 client(connection 객체)와 DBMS를 미리 연결시켜놓는다
2. connection객체를 여러개 가지고 있는 connection pool에 필요할떄마다 connection을 빌려온다.
3. connection을 통해 SQL을 전송하고 결과를 받으면 받은 connection을 connection pool에 돌려준다.
DBCP, 히카리CP등 connection pool을 제공해주는 다양한 오픈소스가 있다.
<br>
connection객체들의 사용법을 통일하기 위해 Java(JaraktaEE, JavaEE)에서 DataSource interface를 제공해준다.
따라서 이런한 DataSource interface를 구현하고있는 개체들을 connection pool이라고 부른다.


### 11.3 Hibernate
**JDBC**
- MyBatis(SI)
- Spring JDBC
- Spring Data JPA(ORM 기술)

**ORM**
- SQL을 몰라도된다.
- ORM이라는 기술의 자바표준이 JPA이다.
- JPA라고 불리는 인터페이스들을 제공해주며 Spring과는 관계가 없다.
- JPA의 구현체가 hibernate이다.
- JPA를 편하게 쓰기 위해 제공해주는 기술이 Spring Data JPA이다.

### 11.4 Spring Data JPA 맛보기

![](https://www.baeldung.com/wp-content/uploads/2019/11/transition-persistence-context.png)

- Persistence Context(영속성 관리자) 
  - user1(Entity 객체)를 관리한다.
  - DB와 통신하며 영속성을 관리한다.
  - EntityManger가 필요하다(Entity Manager가 Persistence Context를 관리한다.)
  - EntityManager는 ThreadSafe하다(동시에 사용불가)
  - EntityManager-PersistenceContext는 JPA와 관련이 있고 JPA Exception을 발생시킬 수 있다.

<br>

이러한 것들을 편하게 사용할 수 있도록 해주는 것이 Spring Data JPA이다.
  - Spring은 JPA가 제공해주는 것들을 Bean으로 관리하길 원한다. 
 

---

## 12. 스프링을 이용한 웹 애플리케이션 만들기

#### JSP에서 JSTL 사용하기
```angular2html
//taglib 설정을 한다. jstl core 라이브러리의 약자인 c를 네임스페이스로 사용한다.
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


//컨트롤러에서 보낸값을 받는다.
<c:forEach var="todo" items="${todos}" varStatus="status">
    <p>${todo.todo}</p> //EL 표기법 todo가 참조하는 객체의 todo 프로퍼티(getTodo())를 사용한다.
</c:forEach>
```
