### 복습
- 강의내용
  - 복습
  - 멀티스레드 프로그래밍(com.eomcs.concurrent)
  - pooling 기법
- 실습 프로젝트
  - 45. 스레드 재사용하기: 스레드풀(thread pool) 구현
- 학습 점검 목록
  - pooling 기법을 설명할 수 있는가?
    - 생성하는데 많은 비용이드는 객체들을 사용후 보관하여 재사용하는 기법
  - pooling을 구현할 수 있는가?
    - 최소한의 기능만 구현 
  - 쌍방 참조(순환 참조)를 해결할 수 있는가?
    - superclass나 interface를 사용하여 직접적인 연관을 맺지 않도록 한다.
  - 자바에서 제공하는 스레드풀 클래스를 사용할 수 있는가?
    - ExecutorService


### DBMS(DataBase Management System) 도입하기
- DB: 데이터 모음(저장소)
- DBMS
  - 데이터 정의
  - 업데이트
  - 검색
  - 관리: 사용자 등록/모니터링, 데이터 보안, 성능 모니터링, 데이터 무결성, 동시성 제어, 오류제어

#### DBMS와 통신
**App ODBC API 명세 <-return call-> Vendor API(Native API) <-응답 DBMS 전용 프로토콜 요청-> DBMS**
  - App <----> Oracle ODBC 구현체(ODBC Driver) <-return call-> Oracle Client API <-응답 DBMS 전용 프로토콜 요청-> Oracle DBMS
  - App <----> SQLServer ODBC 구현체(ODBC Driver) <-return call-> SQL Server Client API <-응답 DBMS 전용 프로토콜 요청-> SQLServer
  - App <----> MySQL ODBC 구현체(ODBC Driver) <-return call-> MySQL Client API <-응답 DBMS 전용 프로토콜 요청-> MySQL
- DBMS 마다 API 사용법이 다르다(개발의 일관성이 떨어짐). -> DBMS마다 따로 APP 작성 -> 개발비용 증가
- ODBC Drive - 호출 규칙이 동일하기 때문에 APP을 한번만 작성하면 된다.

#### Java App과 DMBS 통신
**Java App <-return call--> JDBC Driver <-- --> ODBC Driver <-- --> Vendor API <-- --> DMBS**
- Type1 드라이버
  - ODBC-JDBC Bridge
  - JRE에 기본 포함
  - Local에 설치된 ODBC Drive를 사용한다.
  - 실행속도가 느리다.
- **Java App <-return call--> JDBC Driver <-- --> Vendor API <-- --> DMBS**
- Type2 드라이버
  - Native API call
  - Vendor에서 다운로드 해야 함
  - Local에 설치된 Native API를 사용
  - Type1보다 속도가 빠르다.
- **Java App <-return call--> JDBC Driver <-- --> DMBS**
- Type4 드라이버
  - Native 드라이버
  - Vendor에서 다운로드 해야함
  - Local c/c++ API 설치 불필요
  - 순수 자바 드라이버(pure java)
  - DBMS를 교체하면 로컬에 설치된 JDBC도 교체해야 한다(type2, type4 모두 해당)
- **Java App <-return call--> 중계 서버 JDBC Driver <-- --> 중계 서버(MiddleWare) <-- --> DMBS**
- Type3 드라이버
  - Network 드라이버
  - 3rd-party에서 다운로드
  - 미들웨어 서버 구매비용이 발생
  - 특정 DBMS에 종속되지 않는다.
  - DBMS를 교체하려면 미들웨어 서버측만 JDBC 드라이버 파일을 교체하면 된다.
  - 속도가 느리다.

### myapp과 DBMS
app-client <-- --> MySQL JDBC Driver <-- --> MySQL DBMS

### DBMS 사용하기
1. 직접 사용
- User <-출력 입력-> MySQL Client <-응답 통신 명령어 전달-> MySQL
-                    (client)                       (server) => C/S Archietecture

2. App에서 사용
- 사용자 <-출력 입력-> App <-return call-> JDBC Driver <-응답 통신 전달-> MySQL
