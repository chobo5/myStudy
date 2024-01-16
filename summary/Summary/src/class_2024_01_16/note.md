### DAO 프록시 객체 자동 생성
#### java.lang.reflect.Proxy 클래스 사용법
package com.eomcs.reflect.ex06.a

- MyInterface
  - m1()
  - m2()

- InvocationHandler
  - invoke()
- MyInvocationHandler implements InvocationHandler

- Proxy

### Stateless 통신 방식
1. Stateful
   - client와 server가 한번 연결하면 요청/응답을 연속해서 여러번 수행할 수 있다.
   - 요청/응답을 수행하지 않는 순간에도 연결정보를 계속 유지
   - 대량의 클라이언트 연결을 지원하지 못한다.
2. Stateless
   - client와 server가 요청할 때마다 매번 연결해야 한다.
   - 요청 처리 시간이 길어진다.
   - stateful방식보다 더 많은 클라이언트 요청을 처리할 수 있다.

### 서버 만들기
1. new ServerSocket(8888)
   - 랜카드와 연결할 정보 생성
   - 대기열을 준비시킨다.
2. accept()
   - 대기열에서 연결된 클라이언트 정보를 꺼낸다.
   - Socket객체 생성 및 리턴
   - 대기열이 비어있으면 리턴하지 않고 기다린다.