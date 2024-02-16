### 복습
- 강의 내용
  - 복습
- 과제
  - 개인 과제
- 실습 프로젝트
  - 55. 외부키(Foreign Key) 사용하기 (계속)
  - 56. 로그인/로그아웃 적용하기
  - 57. 웹 어플리케이션 서버 구조로 전환하기 - 웹 기술 도입
- 학습 점검 목록
  - 임베디드 톰캣 서버를 사용하여 웹 어플리케이션 서버를 구축할 수 있는가?


### Servlet Container가 관리하는 객체(component)
1. 서블릿 - 클라이언트 요청을 처리
2. 필터 - 서블릿 실행 전후에 보조 작업을 수행
3. 리스너 - 특정 상태(event)에서 작업을 수행
4. 저장소
   - Servlet Context
     - WebApplication당 1개
     - 서블릿, 필터, 리스너가 공유하는 저장소
     - 관리하는 객체의 예시: DB Connection 객체, DAO 객체, 트랜잭션 관리 객체
   - HttpSession
     - 클라이언트당 1개
     - 서블릿 필터 리스너가 공유하는 저장소
     - 관리하는 데이터의 예시: 로그인 사용자 정보, 페이지 작업 정보
   - ServletRequest
     - 요청당 1개
     - 서블릿 필터 리스너가 공유하는 저장소
     - 관리하는 데이터의 예시: 요청을 처리하는 동안 사용할 정보(email, name...)

### Servlet Container와 Web Application 그리고 Servlet Context
- Servlet Container는 한개이상의 Web Application을 실행할수 있고
- Web Application은 한개 이상의 Servlet이 존재한다.
  - Web Application당 1개의 Servlet Context가 존재한다.

### Servlet과 요청 그리고 Servlet Request
1. 요청이 들어오면 ServletRequest를 생성해 Servlet에게 전달한다.
2. 응답을 하면 ServletRequest는 소멸한다.
   - 한개의 요청은 한개의 ServletRequest를 생성한다.

### Servlet, GenericServlet, HttpServlet의 관계
Servlet(interface) <-- GenericServlet(abstract class) <-- HttpServlet(abstract class)
- Servlet을 만드는 방법은? Servlet 인터페이스를 구현한다. (HttpServlet을 상속받는다는 반쪽짜리 답이다)
- 
