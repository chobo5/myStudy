### 복습
- 강의 내용
    - 복습
    - Web 기술 소개
    - Web Application의 등장 배경과 활용 소개
- 과제
    - 개인 과제
- 실습 프로젝트
- 학습 점검 목록
  - 서블릿에서 텍스트를 웹 브라우저로 보낼 수 있는가?
  - 서블릿에서 텍스트를 출력할 때 한글이 깨지는 이유를 설명할 수 있는가?
  - 서블릿에서 바이너리 데이터를 웹 브라우저로 보낼 수 있는가?
  - 웹 브라저가 전송한 파라미터 값을 꺼낼 수 있는가?
  - POST 방식으로 전달된 파라미터의 한글 데이터가 깨지는 이유를 설명할 수 있는가?
  - HTTP 프로토콜에서 요청 규칙과 응답 규칙을 설명할 수 있는가?
  - GET 방식과 POST 방식의 특징을 설명할 수 있는가?
  - 파일 업로드를 구현할 수 있는가?

### servlet-app ex06
1. 클라이언트가 servlet 실행을 요청하기전, 즉 웹 어플리케이션 실행 단계에서 servlet을 실행하고 싶다면
  - @WebServlet("path", loadOnStartup = 정수) (정수는 우선순위)
  - 서블릿이 작업할 때 사용할 자원을 준비하는데 시간이 오래 걸리는 경우
  - ex) DB 연결, 소켓 연결, 필요한 환경 변수 로딩, 스프링 IoC 컨테이너 준비 등

2. 서블릿이 사용할 값을 DD 설정으로 지정할 수 있다.(jdbcUrl, id, password등)
   - 모든 서블릿에서 사용할 경우  
   - <context-param>
   - <param-name>jdbc.url</param-name>
   - <param-value>jdbc:mysql://localhost:3306/studydb</param-value>
   - </context-param>
   - 서블릿에서 개별적으로 사용할 경우
   - <init-param>
   - <param-name>jdbc.password</param-name>
   - <param-value>1111</param-value>
   - </init-param>

### forwarding
- 요청 위임하기
- RequestDispatcher 요청배달자 = request.getRequestDispatcher("/ex07/s2");
- 요청배달자.forward(request, response);
- forwarding을 하게되면 이전까지 버퍼에 출력한 모든 내용을 삭제한다.(버퍼!, 다른 작업은 수행가능하다)
- forwarding 서블릿을 실행한후 리턴되면 해당 서블릿에서의 그 이후의 출력은 모두 무시된다.
- 포워드는 현재 서블릿에서 설정한 setContentType()이 무시된다.
- 여기부터 내가 정리
- 서블릿의 response는 최초의 서블릿으로 반환되기 때문에 url이 최초의 서블릿과 같다.
- ex) 누군가 종이에 문제를 냄 -> 내가 종이에 적으며 풀다 못풀어서 다른사람에게 포워딩 -> 내가 적은것을 모두 지운다.
- 다른사람이 풀어 나에게 준다. -> 나는 그 종이위에 다시 쓸수 없다. -> 내가 제출
- 오류 페이지의 url은 원래의 url이다. 어떠한 다른 url로 이동되어 나타나지 않는다.

### including
- including 은 forwarding과 달리 include 전에 수행한 출력들을 유지한다.
- 리턴후에도 출력이 가능하다.

### Refresh
- response.setHeader("Refresh", "1;url=/ex08/s2")
- 해당 servlet에서 다시 요청할 url을 포함해서 보낸다.
- 웹브라우저는 응답을 출력하고 해당 url의 서블릿에게 요청을 보낸다.

## Redirect
- response.sendRedirect("/member/list");
- 해당 servlet에서 다시 요청을 url을 포함해서 보내지만 컨텐트는 없다.
- 웹브라우저는 응답을 출력하지 않고 해당 url의 servlet에게 요청한다.
   