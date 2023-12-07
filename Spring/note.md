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
- 
