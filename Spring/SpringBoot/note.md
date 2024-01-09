## 즐거운 스프링 부트 01 - SQL부터 Spring Data JPA까지

### SpringBoot란?

- 독립적이고, 실제 제품수준의 애플리케이션을 쉽게 만들어준다.
- 특정 버전의 서드파티 라이브러리들을 특정한 방법으로 사용할 수 있도록 확장점을 제공한다.
- 최소한의 노력으로 시작할 수 있는 틀을 만들어 놓았다.
- 스프링 부트는 최소한의 설정만 필요하다. 그러나, 보안 관련 설정등 추가적인 설정이 추가 될 가능성이 크다.
- java-jar를 이용하여 쉽게 실행할 수 있다.(큰 장점중의 하나)
- war로 묶어서 배포할 수 있다. 설치 WAS에 배포한다.
- 커맨드 라인 툴도 제공한다(spring-boot-cli-2.7.5-bin.zip)

### SpringBoot의 중요 목적

- 아주 손쉽게 프로젝트를 시작할 수 있도록 한다.
- 주관을 가지고 만들어진 제품이지 요구사항이 다양해짐으로써 주어진 틀에서도 얼마든지 벗어날 수 있도 한다(커스터마이징이 가능하다.)
- 프로덕션을 위한 모니터링, 헬스 체크등의 기능도 제공한다.
- 코드 제너레이을 제공하는 도구가 아니다. xml설정을 필요없다.

### 스프링부트 설치
- spring-boot-*.jar를 classpath에 추가한다. 아무 ide나 텍스트 에디터를 사용하면 된다.
- Maven이나 Gradle을 이용하는것이 편리하다

### 스프링부트 demo 프로젝트
build.grade
- id 'io.spring.dependency-management' version '1.1.4' 플러그인을 적용하면,
    SpringBoot 플러그인을 자동으로, 사용하고있는 SpringBoot버전에서
    spring-boot-dependencies bom을 가져옵니다.
  - bom: 프로젝트 생성시 다운받은 라이브러리는 다른 라이브러리를 의존하는데,
    의존하는 라이브러리들의 호환성이 높은 버전을 다운받도록 관리해준다

### Spring JDBC 핵심 클래스
- JdbcTemplate
- NamedParameterJdbcTemplate
- SQLExceptionTranslator
- RowMapper

### DTO(DataTransferObject) & DAO(DataAccessObject)
Client <-> Controller <-> Service <-> DAO(Repository) <-> DB
       DTO            DTO         DTO                ENTITY


- Entity: DB에서 정보를 Entity에 담아온다.
- 그 정보를 DTO에 담는다.
- DAO: DataBase에서 입력, 수정, 삭제, 조회하는 객체
- 