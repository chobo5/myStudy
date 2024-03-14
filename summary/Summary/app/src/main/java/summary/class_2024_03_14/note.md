### 복습
- 강의내용
    - 복습
    - Use-case 모델(계속)
    - Spring WebMVC 사용법
- 실습 프로젝트
- 최종 팁 프로젝트
    - DB Modeling
- 학습 점검 목록
    - 서블릿 기반 웹프로젝트에 Spring WebMVC를 적용할 수 있는가?
    - DispatcherServlet의 IoC 컨테이너 설정 방법을 설명할 수 있는가?
    - ContextLoaderListener의 IoC 컨테이너 설정 방법을 설명할 수 있는가?
    - DispatcherServlet의 IoC 컨테이너와 ContextLoaderListener의 관계를 설명할 수 있는가?
  
### MyInitializer는 어떻게 어노테이션 없이 객체가 생성되어 onStartup을 호출되는가?
1. 서버를 시작한다(Listener가 실행되기 전)
2. ServletContainer가 spring-web.x.x.x.jar/META-INF/services/javax.Servlet.ServletContainer에
   등록된 클래스(SpringServletContainerInitializer)를 생성 하고 onStartup()을 호출한다.
3. onStartup()의 파라미터로 WebApplicationInitialzer를 구현한 객체를 넘겨주도록 한다.
4. onStartup 호출시 넘겨받은 객체들의 onStartup()을 실행시킨다.
