### 복습
- 강의 내용
    - 복습(1)
        - Spring WebMVC 사용법(계속)
    - 실습 프로젝트
    - 최종 팀 프로젝트
        - DB 모델링
    - 학습 점검 목록
        - request handler에서 redirect, forward, include를 처리하는 방법을 설명할 수 있는가?  
        - request hadler에서 뷰 컴포넌트가 사용할 값을 리턴하는 방법을 설명할 수 있는가?
        - ViewResolver의 역할과 동작 과정을 설명할 수 있는가?
        - view name이 절대 경로일 떄와 상대 경로일 때에 따라 URL이 달라지는 것을 설명할 수 있는가?
        - request handler가 view name을 리턴하지 않을 때, 계산되는 view URL을 설명할 수 있는가?
        - @PathVariable을 사용하여 URL에 값을 추출하는 방법을 설명할 수 있는가?
        - @MatrixVariable 사용법을 설명할 수 있는가?
      
    
### @SessionAttribute(Controller03_2)
- HttpSession은 클라이언트 연결이 아닌 HttpSession을 호출하는 시점에 생성된다.
- 따라서 invalidate 이후 값을 추가하고 조회하기만 한다면 HttpSession 값이
- 추가된 상태가 아닌 HttpSession이 생성만 된 상태이다.
- 따라서 사용하지는 않지만 HttpSession을 파라미터로 받도록하면 HttpSession이 생성된다.
- 또는 JSP는 HttpSession이 빌트인 객체로 설정되어있기 때문에 첫페이지를 jsp로 만드는 경우가 많다.