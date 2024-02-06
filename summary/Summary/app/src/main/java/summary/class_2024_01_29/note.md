### 복습
- 강의 내용
  - 복습
  - DBMS 프로그래밍
    - 데이터베이스와 DBMS개념
    - MySQL 설치 및 설정
    - 사용자 등록, 데이터베이스 생성, 권한 설정
  - 실습 프로젝트
    - 스레드 재사용하기: 자바에서 제공하는 스레드풀 사용
  - 학습 점검 목록
    - Database와 DBMS에 대해 설명할 수 있는가?
    - DBMS를 사용한 프로그래밍 방법에 대해 설명할 수 있는가?
    - Vendor API 호출과 ODBC API 호출을 설명할 수 있는 가?
    - ODBC API와 ODBC Driver를 설명할 수 있는가?
    - JDBC API와 JDBC Driver를 설명할 수 있는가?
    - JDBC Driver를 유형에 따라 나눈 Type 1~4의 특징을 설명할 수 있는가?
    - 미들웨어(middleWare)가 무엇인지 설명할 수 있는가?
    - MySQL DBMS를 설치하고 설정할 수 있는가?
    - MySQL DBMS에 사용자를 추가하고 조회할 수 있는가?
    - 사용자가 사용할 데이터베이스의 권한을 설정할 수 있는가?
    

### JDBC API 프로그래밍
1. JDBC Driver 준비, java.sql.Driver 구현체를 생성하여 DriverManager에 등록한다.
   - Driver driver = new com.mysql.jdbc.Driver();
   - DriverManager.registerDrive(driver)
2. DriverManager를 통해 DBMS 연결을 요청
   - Connection con = DriverManager.getConnection();
3. SQL을 DBMS에 전달해줄 객체 준비
   - StateMent stmt = con.createStatement();
4. SQL을 DBMS에 전달
   - ResultSet rs = stmt.executeQuery();
5. select 실행결과 데이터중 한개의 데이터(record = row = tuple)를 서버에서 가져오기
   - rs.next()
6. 서버에서 가져온 레코드에서 컬럼 값 꺼내기
   - rs.getString("칼럼명");