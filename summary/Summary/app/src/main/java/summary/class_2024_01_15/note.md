### GoF proxy pattern
- proxy: 중간에서 호출을 대행하는 객체
- real: 실제 작업을 수행하는 객체
  - real객체를 직접사용하지 않고 proxy객체를 사용한다.
  - 직접 사용하려면 복잡한 코드를 작성해야 하는 경우 객체 사용에 대한 복잡한 코드를 캡슐화 할 수 있다.

**Handler <-return, call-> BoardDaoImpl <-통신, 요청-> ServerApp <-return, call(findAll) -> BoardDaoImple <-I/O-> Json파일**


### 원격에 존재하는 코드(ex> 메서드)를 호출하는 이유
- 다인용(기업용) App
  - 동시 처리 필요
  - 많은 성능 요구 -> App의 기능을 여러 컴퓨터에 분할해서 실행할 필요성이 있다. -> **분산 컴퓨팅 기술**

### 원격 메서드를 호출하는 기술 - (다른 or 같은) 컴퓨터의 프로세스에 있는 코드 실행
- 다른 프로세스의 메모리에 직접 접근할 수 없다.(변수나 메서드 사용불가)
- Local과 Remote
  - Local: 같은 컴퓨터든 다른 컴퓨터든 local의 반대편 process를 remote라고 부른다.
- 다른 컴퓨터(다른 프로세스)의 메서드를 호출하는 기술이 필요해졌다.

### 원격 메서드 호출 기술 발전사
1. RPC(Remote Procedure Call) ---> RMI(Remote Method Invocation)
   - 절차적 프로그래밍 언어에서 등장
   - ex) c, pascal등

2. RMI ---> CORBA
   - 객체지향 프로그래밍 언어에서 등장
   - c++, java등
   - client -call-> stub(c) <--> skel(c) -> service객체 

3. CORBA(Common Object Request Broker Architecture) ---> WebService
   - 이기종 플랫폼간의 호출(ex> c -> java, java -> pascal)
   - client -call-> stub(c) <--> skel(pascal) -> service객체 

4. WebService
   - stub을 local에서 자동 생성
   - client -> stub < -응답, IIOP, 요청- > skel -> service 객체
   - WSDL(xml): 서비스 객체가 제공하는 메서드 정보
   - 서버에서 WSDL을 받아와서 Local의 IDE가 stub을 자동 생성
   - facebook, google에서 제공하는 플랫폼별 라이브러리(서비스를 제공하는 쪽에서 제공한다.)

5. RESTful 
   - client <--응답  HTTP Protocol  요청--> WebServer <-return  위임-> 서비스 객체
   1. 클라이언트측에 stub역할을 하는 객체가 필요없다.
   2. 언어에 상관없이 HTTP통신에 맞춰 서비스객체를 이용(이기종 플랫폼간에 상호 호출 가능)
   3. 전송 데이터 포맷: XML, JSON을 주로 사용

### 공통코드를 서브 프로젝트로 분리
app-client ----포함---> app-common(vo 클래스, dao 인터페이스) <---포함--- app-server