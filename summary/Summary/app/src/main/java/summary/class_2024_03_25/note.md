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
        - Mybatis의 <resultMap/>, <association/>, <collection/> 태그를 설명할 수 있는가?
        - Mybatis의 <typeAliases/> 태그를 설명할 수 있는가?
        - Mybatis 설정을 XML대신 Java Config로 바꿀 수 있는가?
        - Spring 프레임워크의 @Transactional 애노테이션으로 트랜잭션을 다룰 수 있도록 설정할 수 있는가?
        - Spring 프레임워크에서 @Transactional을 어떻게 처리하는지 그 구동원리를 설명할 수 있는가?

### Mybatis가 생성한 DAO 객체에서 SQL을 찾는 방식
- Spring에서 Mybatis를 사용할 수 있도록 해주는 라이브러리에 들어있는 클래스가 자동생성 해준다.
- DAO 구현체 -> SQL Mapper 파일에서 SQL을 찾아서 실행
- DAO 인터페이스(Fully Qualified Name) + 메서드명 = bitcamp.myapp.dao.AssignmentDao.findAll

### Service 컴포넌트
1. 현재 - Controller가 UI 흐름제어, 요청/응답 데이터처리, 업무흐름제어(트랜잭션 제어)를 한다
2. 개선 - Controller와 DAO 사이에 Service를 도입하여 업무흐름제어 책임을 맡는다.

### Controller - Service - Dao - Table간의 관계
1. Controller는 Service를 여러개 참조할 수 있으며 Service는 여러개의 DAO를 참조할 수 있고 DAO는 여러개의 테이블을 사용할 수 있다
2. 하나의 Table에는 한개의 owner DAO만 존재한다. 이외의 DAO에서는 조회(select)만 할 수 있도록 한다.
3. Controller, Service, DAO 끼리는 참조하지 않도록 한다.

### 적용
1. BoardController는 BoardService를 참조한다.
2. BoardService는 BoardDao, AttachedFileDao를 참조한다.
3. BoardDao는 boards 테이블의 owner이고 boards, board_files 테이블을 사용한다.
4. AttachedFileDao는 board_files 테이블의 owner이고 board_files 테이블을 사용한다.

### Lombok
- lombok은 Getter, Setter, ToString 등을 컴파일 단계에서 생성한다.(컴파일된 .class에는 존재)
- 따라서 IDE는 현재 코드만을 바라보고 컴파일 에러를 낸다.
- IDE애개 해당 어노테이션으 붙은 클래스는 .class파일을 뒤져보라는 의미로 lomobok 플러그인을  설치하면 컴파일 에러가 없어진다.