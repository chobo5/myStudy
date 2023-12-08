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
