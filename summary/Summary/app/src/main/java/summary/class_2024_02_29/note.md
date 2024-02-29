### 복습
- 강의 내용
    - 복습
    - JSP 구동 원리 이해
- 실습 프로젝트
  - 64. 필터 적용하기
  - 65. JSP를 이용하여 MVC 모델2 구조로 변경하기
- 학습 점검 목록
    - 서블릿 필터의 생명주기와 동작원리를 설명할 수 있는가?
    - JSP의 동작원리를 설명할 수 있는가?
    - MVC 모델1/모델2를 설명할 수 있는가?
    - JSP 태그의 역할을 설명할 수 있는가?

### JSP 태그
1. directive element
  - <%@ page ~ %> - JSP 페이지 설정
  - <%@ include ~ %> - 다른파일의 컨텐트를 삽입
  - <%@ taglib ~ %> - 외부 태그 가져오기
2. scriptlet
  - <% 자바코드 %> - 서블릿 클래스에 삽입할 코드
3. expression element
  - <% 표현식 %> - 표현식의 리턴값을 출력

- <%! 필드 및 메서드 %>

### EL(Expression Language)
- ${객체.프로퍼티.프로퍼티....}
  - OGNL - Object Graph(관계) Navigation Language(문법)

### JSTL(JSP Standard Tag Library) - JSP 확장 태그

### Front Controller 도입
1. 도입전
  - 각각의 서블릿이 요청을 받아 처리한다.
2. 도입후
   - DispatchServlet이 모든 요청을 받아 처리한다.
   - 서블릿이 반복적으로 하던일을 처리한다.

### PageControlller를 POJO(Plain Old Java Object)로 전환
- 모든 요청을 DispatcherServlet에서 받기 때문에 페이지 컨트롤러들은 Servlet일 이유가 없다.