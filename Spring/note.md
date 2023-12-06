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

---

## 2. Spring의 핵심기능
- container - 관점지향(AOP - Aspect Oriented Programming)

## 3. Spring 사용 방법
1. 설정파일을 만든다(xml, )
