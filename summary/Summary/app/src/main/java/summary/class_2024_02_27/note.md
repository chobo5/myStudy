### 복습
- 강의 내용
- 복습(1)
- 쿠키 및 세션을 다루는 방법
- 서블릿을 배치하는 방법
- 과제
- 개인 과제
- 실습 프로젝트
- 최종 팀 프로젝트
- 학습 점검 목록


### 웹 앱 보관소
- ServletContext
  - 웹 앱의 시작과 함께 생성되며 웹 앱 종료시 소멸된다.
  - 앱당 1개만 생성된다.
  - ex) DAO, Service, TransactionManager, DB Connection
- HttpSession
  - 클라이언트당 1개 생성된다.
  - 클라이언트 접속시 생성되며 타임아웃(무효화)시에 소멸한다.
  - ex) 로그인 정보, transaction 작업, 중간 계산 결과
- Servlet Request
  - 요청시에 생성되며 응답시 소멸된다.
  - 요청당 1개 생성
  - ex)오류 정보, 페이지 작업 정보

### Cookie - 웹서버가 웹브라우저에게 맡기는데이터
- 웹브라우저는 사용범위에 해당하는 요청을 할 때만 쿠키를 보낸다.

### HttpSession과 Cookie의 관계
- 세션ID를 담고있지 않은 최초의 요청
- servlet container에서 getSession() 호출시 HttpSession 객체를 생성한다.
- 세션ID를 쿠키에 담아 응답한다.
- 요청에 세션ID가 포함되어있다면 HttpSession을 생성하지 않으며, 응답에 쿠키를 담지 않는다.