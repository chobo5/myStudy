### 복습
- 강의내용
    - 복습
- 과제
    - 개인과제
        - Application Server 아키텍처로 전환
    - 실습 프로젝트
      - Application Server 아키텍처로 전환하기
    - 학습 점검 목록
    - Application Architecture에 대해 설명할 수 있는가?
    - StringWriter의 동작 원리를 설명할 수 있는가?

### DB 커넥션 공유의 문제점과 단순 해결책

#### 스레드 별로 DB 커넥션을 따로 유지하기
1. SQL을 실행할 떄 마다 Connection 생성 -> 다른 Thread의 SQL작업을 간섭하지 않는다.
    - 단점
      1. 매번 Auth(Authentication + Authorization)인증을 해야한다(시간 소요, 가비지 생성)
      2. Transaction으로 묶을 수 없다.

2. 스레드당 1개의 Connection 유지
   - 같은 트랜잭션으로 묶을 수 있다.
   - 스레드마다 다른 connection 사용 -> 다른 스레드의 commit/rollback에 영향을 받지 않는다.
   - 스레드가 SQL을 실행하는 동안 같은 Connection 사용 -> 여러개의 데이터 변경 작업을 하나의 트랜잭션으로 묶을 수 있다.
   - ThreadLocal을 사용하여 스레드 별로 Connection 객체를 유지한다.
   - 현재는 Transaction에 대한 제어(setAutoCommit, connection.close())가 DAO에서 동작한다.

3. 트랜잭션을 담당할 객체
   - DAO의 메서드 여러개를 업무에 따라 하나의 트랜잭션으로 묶어 실행해야 할 때가 있다.
   - DAO를 호출하는 쪽에서 트랜잭션을 제어해야한다 = Business Logic을 수행하는 객체 - handler


### DB 커넥션 재사용: DB 커넥션 풀
1. 현재방식 - Thread 수만큼 DB connection이 생성된다 -> 커넥션 낭비
   - 클라이언트가 connection을 사용하지 않아도 사라지지 않는다.