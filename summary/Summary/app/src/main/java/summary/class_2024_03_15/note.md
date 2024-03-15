### 복습
- 강의내용
    - 복습
    - Spring WebMVC 사용법
- 실습 프로젝트
- 최종 팁 프로젝트
    - DB Modeling
- 학습 점검 목록
    - ServletContainerInitializer의 구동 원리를 설명할 수 있는가?
    - SpringServletContainerInitializaer 클래스의 구동 원리를 설명할 수 있는가?
    - WebApplicationInitializer의 사용법을 구동 원리를 설명할 수 있는가?
    - WebApplicationInitializer를 활용하여 ContextLoadListener와 DispatcherServlet을 설정할 수 있는가?

### Request Headers와 Accept
- Request Headers
  - text/html, application/xhtml xml, application/xml....
- @GetMapping(produces=text/html)
- 웹 브라우저가 서버에게 같은 URL이지만 Accept의 형식에 따라 매핑되는 메서드를 서버에서 호출하여 리턴한다.