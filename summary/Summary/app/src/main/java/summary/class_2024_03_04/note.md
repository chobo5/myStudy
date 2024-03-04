### 복습
- 강의 내용
  - 복습
  - EL, JSTL 사용법
- 실습 프로젝트
  - 66. EL및 JSTL 활용하기
  - 67. Front Controller 디자인 패턴 도입하기
  - 68. 페이지 컨트롤러를 POJO로 전환하기
- 학습 점검 목록
  - 프론트 컨트롤러 패턴을 설명할 수 있는가?
  - POJO를 설명할 수 있는가?
  - EL 및 JSTL의 특징을 설명할 수 있는가?

### 서버루트와 웹어플리케이션 루트
1. 다른경우
- http://localhost(서버):8888(포트)/(서버루트)myapp/(웹어플리케이션루트)board/list(resourece path)
2. 같은 경우
- http://localhost(서버):8888(포트)/(서버루트 = 웹어플리케이션루트)board/list(resourece path)

### <%@ include %> vs <jsp:include ____ />
1. <%@ include %>
  - a.jsb, x.txt, y.txt가 있을떄 txt파일이 a.jsp에 삽입되며 하나의 a.java파일이 만들어진다.
2. <jsp:include ____ />
  - a.jsp -> a.java
  - x.jsp -> x.java
  - y.jsp -> y.java
  - include()메서드를 호출한다.
