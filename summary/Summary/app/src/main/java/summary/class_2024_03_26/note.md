### 복습
- 강의 내용
    - 복습(1)
        - Spring WebMVC를 Java Config로 설정하기
        - Spring WebMVC의 기본 ViewResolver를 InternalResourceViewResolver로 교체하기
        - Mybatis SQL-mapper 프레임워크 사용하기
    - 실습 프로젝트
    - 최종 팀 프로젝트
        - DB 모델링
    - 학습 점검 목록
        - Lombok - Mybatis

### 수업내용
1. 필드에서 바로 생성된 값은 컴파일 단계에서 생성자의 맨앞으로 온다.
```dtd
public class BoardController {
    .
    .
    private final BoardService boardService;
    private final SevletContext servletContext;
    //여기서 생성된 프로퍼티는 자바컴파일러에 의해 생성자의 맨위로 내려간다.
    private String uploadDir //= ServletContext.getRealPath("/upload/board");

    @Override
    public void afterPorpertiesSet() throws Exception {
        this.uploadDir = ServletContext.getRealPath("/upload/board");
    }
}
```

2. factory method pattern: 객체 생성 과정이 복잡하지만 필요한 다른 객체가 적을때.
3. Build Pattern: 객체 생성과정이 복잡하고 여러 객체를 조립하여 생성해야 할 때.

5. Thymeleaf: HTML5 문법을 준수하기 때문에 실행전 파일도 그대로 화면에 출력해 볼 수 있다.
    - 미리보기 효과가 있어 페이지 디자인에 편리하다.
