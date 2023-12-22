## 01. SQL 부터 Spring Data JPA까지

### Database
- 데이터의 집(a Set of Data)
- 여러 응용 시스(프로그램)들의 통합된 정보들을 저장하여 운영할 수 있는 공용(share)데이터의 집합
- 효율적으로 저장, 검색, 갱신할 수 있도 데이터 집합들끼리 연관시키고 조직화되어야한다.

### DBMS(DataBase Management System)
- 데이터 베이스를 관리하는 소프트웨어
- 여러 응용소프트웨(프로그램) 또는 시스템이 동시에 데이터베이스에 접근하여 사용할 수 있게 한다.
- 필수 3기능
  - 정의기능: 데이터베이스의 논리적, 물리적 구조를 정의
  - 조작기능: 데이터를 검색, 삭제, 갱신, 삽입하는 기능
  - 제어기능: 데이터베이스의 내용 정확성과 안정성을 유지하도록 제어하는 기능
- Oracle, SQL Server, MySQL, DB2등의 상용 또는 공개 DBMS가 있다.

### 관계형 데이터베이스(Relational DataBase = RDB)
- 키와 값들의 간단한 관계를 테이블화 시킨 매우 간단한 원칙의 개념의 데이터베이스
- 일련의 정형화된 테이블로 구성된 데이터 항목들의 집합이며 각 테이블은 데이터의 성격에 따라 여러개의 칼럼(키)이 포함된다.
- 사용자는 SQL이라는 표준 질의어를 통해 데이터를 조작 또는 조회 할 수 있다.

### MySQL
- 가장 인기있는 openSource DB

### Docker-Desktop을 이용해 MySQL DBMS를 실행한다.
- docker-compse로 간단히 실행

### docker-compose.yml
- 평범한 text 파일이다.
```
version: "2"

services:
  vacation-db:
    image: mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: "root1234"
      MYSQL_DATABASE: "examplesdb"
      MYSQL_USER: "chobo5"
      MYSQL_PASSWORD: "12241509"
      TZ: Asia/Seoul
    command:
      - --character-set-server=utf8mb4
      - --collation-server=utf8mb4_unicode_ci
    volumes:
      - ./database/init/:/docker-entrypoint-initdb.d/
      - ./database/datadir/:/var/lib/mysql
    platform: linux/x86_64
    ports:
      - 3306:3306
```
- utf8mb4: 이모지를 저장하기 위한 형식
- volumes 이하: docker환경이 실행되는 컴퓨터(mac) ---> Docker-desktop 실행 ---> MySQL DBMS 실행
  - 사용중 Docker가 종료되었을떄 데이터가 사라지지 않도록
  - 컴퓨터에 폴더를 만들어 DBMS가 사용하도록 한다.
  - ./database/init/: Docker가 실행되는 컴퓨터의 디렉토리
  - /docker-entrypoint-initdb.d/: Docker 안에서 실행되는 DBMS가 가지고 있는 폴더
  - 두 폴더를 연결시켜라
- 3306:3306
  - 앞: Docker환경을 실행시키는 컴퓨터의 포트
  - 뒤: Docker환경에서 실행되는 MySQL DBMS의 포트
  - 포트포워딩
**docker-compose up -d**
 - 현재폴더의 docker-compose.yml파일을 읽어 MySQL서버를 실행한다.

**docker-compose down**
- 종료


### MySQL Workbench (Client)
select version(), current date;
- SQL ---> 전송 ---> MySQL DBMS(SQL 실행) ---> 결과를 MySQL Workbench로
- 