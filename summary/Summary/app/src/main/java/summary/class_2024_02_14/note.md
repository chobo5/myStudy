### 복습
- 강의내용
    - 복습
    - AS(Application Server) 아키텍처에서 DB Connetion 관리하는 방법
- 과제
  - 개인과제
- 실습 프로젝트
  - 50. 여러 스레드가 DB 커넥션을 공유할 때의 문제점과 해결책1
  - 51. 여러 스레드가 DB 커넥션을 공유할 때의 문제점과 해결책2
  - 52. 트랜잭션을 제어하는 객체: 비즈니스 로직을 수행하는 객체
  - 53. DB 커넥션 풀을 이용한 Connection 재사용하기
- 학습 점검 목록
  - 여러 스레드가 DB 커넥션을 공유할 떄 발생하는 문제를 설명할 수 있는가?
  - 스레드에 커넥션을 저장하는 방법을 아는가?
  - 비즈니스 로직을 수행하는 객체에서 트랜잭션을 제어해야 하는 이유을 설명할 수 있는가?
  - 풀링 기법을 설명할 수 있는가?
  - DB Connection Pool을 구현할 수 있는가?

### DB 커넥션과 프록시 패턴
- 현재 방식
  1. Handler --getConnection()-> 

- 개선 방식
  1. Connection 인터페이스 구현하는 ConnectionProxy 생성
  2. 또한 ConnectionProxy는 Connection 인터페이스의 구현체를 포함한다.
  3. 모든 메서드는 Connection 객체에 위임하며 실제 작업은 Connection 객체(original가 한다.
  4. close() 메소드를 오버라이딩하여 connection을 close하는 것이 아닌 반환하도록 한다.
  5. 쌍방참조를 해결하기 위해 ConnectionPool 인터페이스를 도입한다.

### 외부키
