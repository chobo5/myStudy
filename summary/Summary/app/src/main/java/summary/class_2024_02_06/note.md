### 복습
- 강의 내용
  - 복습
- 과제
  - myapp ver.47을 참조하여 개인별 CRUD 프로젝트 구현 및 발표
  - 개인 과제 DB 모델링
- 학습 점검 목록
  - DB 모델링을 설명할 수 있는가?
  - ER-Diagram의 구성요소를 이해하고 그릴 수 있는가?
  - 정규화를 설명할 수 있는가?
  - 포함관계, 배타적관계, 다대다 관계를 설명할 수 있는가?
  - 다대다 관계를 해소할 수 있는가?
  - 같은 성격의 컬럼을 묶어 도메인을 정의하는 방법을 아는가?
  - 유니크 컬럼, 인덱스 컬럼을 설정할 수 있는가?
  - 포워드 엔지니어링(forward engineering), 리버스 엔지니어링(reverse engineering)을 설명할 수 있는가?

### DB Programming
App <-return call-> JDBC Driver <-응답 통신 요청-> DBMS <- I/O -> Database

### JDBC Programming
1. Driver
2. Driver Manager
3. Connection
4. Statement
5. ResultSet
6. PreparedStatement
7. Transaction: commit/rollback
8. Connection Pool: DataSource

#### 0. JDBC API 와 JDBC Driver
1. JDBC API: 자바에서 제공하는 인터페이스 및 클래스
   - java.sql.x 또는 javax.sql.x 패키지
2. JDBC Driver: Vendor에서 제공하는 인터페이스 구현체 및 보조 클래스, 다음의 구현체들을 포함한다.
   - Driver 인터페이스를 구현한 구현체 
     - ex) com.mysql.cj.jdbc.Driver
   - Connection 인터페이스를 구현한 구현체
     - ex) com.mysql.cj.jdbc.ConnectionImpl
   - Statement 인터페이스를 구현한 구현체
     - ex) com.mysql.cj.jdbc.StatementImpl
   - PreparedStatement 인터페이스를 구현한 구현체
   - ConnectionPool 인터페이스를 구현한 구현체


#### 1. Driver와 DriverManager
1. Driver 구현체 등록
   - Driver의 인스턴스를 생성해 DriverManager 클래스에 등록한다.
     - DriverManager.registerDriver()
   - DriverManager는 Driver 구현체 목록을 포함(관리)한다.
     - JDBC URL: jdbc:mysql, Driver 인스턴스
