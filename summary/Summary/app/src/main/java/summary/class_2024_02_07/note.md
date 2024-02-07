### 복습
- 강의 내용
    - 복습
    - JDBC 프로그래밍(com.eomcs.jdbc.*)
    - 드라이버 등록, 커넥션 얻기, SQL 실행하기
- 과제
    - 개인 과제 DB 모델링
- 실습 프로젝트
- 학습 점검 목록
  - JDBC 프로그래밍의 필요할 기술을 설명할 수 있는가?
  - JDBC API와 JDBC Driver의 관계를 설명할 수 있는가?
  - JDBC API를 사용하여 DBMS와 연동하는 방법을 아는가?
  - JDBC API 주요 객체에 대한 역할을 설명할 수 있는가?
  - Driver와 DriverManager의 역할을 설명할 수 있는가?
  - Driver를 등록하는 다양한 방법을 설명할 수 있는가?
  - Service-Provider 기법을 이용하여 드라이버를 자동으로 로딩하는 방법을 설명할 수 있는가?
  - DriverManager를 사용하여 Connection을 생성할 수 있는가?
  - Statement를 이용하여 DML, DQL SQL문을 실행할 수 있는가?
  - ResultSet을 이용하여 select 실행 결과를 다룰 수 있는가?

### PreparedStatement

- PreparedStatement pstmt =
  - 주어진 SQL문을 값과 분리하여 DBMS가 이해할 수 있는 형식으로 미리 변환(compile)한다.
    - 값은 따로 DBMS에 전달한다.
- con.prepareStatement("insert into x_board(title, contents) values(?, ?)");
  - ?는 In-parameter값이 들어갈 자리를 표시한다(값을 설정하는 방법)



