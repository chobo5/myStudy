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


### SQL
- 테이블 생성, 테이블 삭제, 테이블 수정
- 값을 저장, 수정, 삭제, **조회**(중요)
- 권한 부여, 데이터베이스 생성

---

## 02. SQL 부터 Spring Data JPA까지

SELECT 구문의 기본문형
- Table에서 데이터를 가져오기 위해 SELECT구문을 사용한다.
- SELECT: 검색하고자 하는 데이터(칼럼)을 나열한다.
- DISTINCT: 중복을 제거한다.
- ALIAS: 나타날 칼럼에 다른 이름 부여
- FROM: 선택한 칼럼이 있는 테이블을 명시한다.
- DESC: 테이블의 구조를 보여준다.


```SQL
show tables; -- 테이블 목록을 보여달라
select *from employees limit 0,10; -- 페이지별로 조회가 가능하다.
desc employees;
-- Key가 PRI(primary)이면 유일해야한다.
select first_name, last_name, salary from employees;

select first_name as 성, last_name as 이름, salary as 연봉 from employees;

select concat(first_name,' ' ,last_name) as 이름, hire_date as 입사일 from employees;

select distinct manager_id from employees; -- 중복제거

select first_name, last_name, hire_date from employees order by hire_date asc;
select first_name, last_name, hire_date from employees order by hire_date desc;

select first_name, last_name, hire_date, salary from employees order by salary desc;
```

**WHERE와 함께 조회하기**
- SELECT(DISTINCT) 칼럼명(ALIAS)
- FROM 테이블명
- WHERE 조건식
- ORDER BY 칼럼이나 표현식(ASC or DESC)

**문자형 함수 - UCASE, UPPER**
- SELECT  UPPER('SEoul), UCASE('seOUL'); (UPPER = UCASE) //SEOUL
- SELECT  LOWER('SEoul), LCASE('seOUL'); //seoul
- SELECT SUBSTRING('happy day',3 ,2) //3번쨰 부터 2개잘라

**좌변을 변형시키는 것은 성능을 하락시킬 수 있다.**

**실행 계획보기**
- 맨앞에 explain을 추가한다
- 평상시에는 비슷하지만 index를 주면 상황이 달라진다.
```SQL
create index employees_hire_date_idx on employees (hire_date);

show index from employees;

explain select concat(first_name, last_name) as 이름, hire_date as 입사일 
from employees 
where substring(hire_date, 1, 4) = '1989'; -- 0.020 sec

explain select concat(first_name, last_name) as 이름, hire_date as 입사일 
from employees 
where hire_date like '1987'; -- 0.018 sec
```
인덱스를 생성한후 실행계획을 보면 좌변을 변형하지 않은것은 인덱스를 탄다.
인덱스를 최대한 이용하는것이 성능이 좋은 쿼리를 만드는 것이다.

---

## 03. SQL 부터 Spring Data JPA까지


**LPAD, RPAD**
- select lpad('hi', 5, '?'), lpad('joe', 7, '*'); -- 5글자를 만드는데 왼쪽을 ?로 채워라

- select employee_id, lpad(cast(salary as char), 10 , '*') from employees; -- salary를 char(문자열)로 casting함

**TRIM**
- select LTRIM('  hello   '), RTRIM('   hi   '); -- 공백 제거
- select TRIM('.  hello.  '), TRIM(both'x' from 'xxxxhixxxx'); -- x제거

**연산**
- select ABS(-2); -- 절댓값
- select mod(234, 10), 253 % 7, mod(29, 9); -- 나머지 연산자
- select ceiling(1.23), ceiling(-1.23); -- 올림
- select round(1.23), round(2,64), round(-1.67), round(1.298, 1); -- 반올림, 소숫점 선택
- select POW(2, 3); -- 제곱
- select sign(-32), sign(0), sign(17); -- 음수면 -1, 0은 0, 양수는 1
- select greatest(2, 0), greatest(4.0, 3.0, 5.0), greatest("B", "A", "C");
- select least(2, 0), least(4.0, 3.0, 5.0), least("b", "A", "C");


**날짜**
- select curdate(), current_date;
- select curtime(), current_time;
- select now(), sysdate(), current_timestamp();

**날짜형 함수 - DATE_FORMAT(date, format): 입력된 date를 format형식으로 변환
- select date_format(curdate(), '%W %M %Y');
- select date_format(curdate(), '%Y %m %d');
- https://devjhs.tistory.com/89

**날짜형 함수 - PERIOD_DIFF(p1, p2): YYMM이나 YYYYMM으로 표기되는 p1, p2의 차이 개월을 반환**

**날짜형 함수**
- DATE_ADD(date, INTERVAL expr type)
- DATE_SUB(date, INTERVAL expr type)
- ADDDATE(date, INTERVAL expr type)
- SUBDATE(date, INTERVAL expr type)
- 날짜 date에 type형식으로 지정한 expr을 더하거나 뺸다
- DATE_ADD()와 ADDDATE()는 같은 동작이고 DATE_SUB(), SUBDATE()는 같은 동작이다.

**형변환**
- CAST 함수는 type을 지정(변경)하는데 유용하다.
- 사용법
```
CAST(expression AS type)
CONVERT(expression, type)
```

- MySQL 타입
  - BINARY
  - CHAR
  - DATE
  - DATETIME
  - SIGNED {INTEGER}
  - TIME
  - UNSIGNED {INTEGER} (양수값만 표현)

**그룹 함수**
- COUNT(expr): non-NULL인 row 숫자를 반환
- COUNT(DISTINCT expr, [expr...]): non-NULL인 중복되지 않은 row의 숫자를 반환
- COUNT(*): row의 숫자를 반환
- AVG(expr): expr의 평균값을 반환
- MIN(expr): expr의 최솟값을 반환
- MAX(expr): expr의 최댓값을 반환
- SUM(expr): expr의 합을 반환
- GROUP_CONCAT(expr): 그룹에서 concatenated한 문자를 반환
- VARIANCE(expr): 분산
- STDDEV(expr): expr의 표준 편차를 반환


**select 구문의 전체 문형**
```
SELECT(DISTINCT) 칼럼명(ALIAS)
FROM 테이블명
WHERE 조건식
GROUP BY 칼럼명
HAVING 조건식
ORDER BY 칼럼이나 표현식(ASC 또는 DESC)
```
- GROUP BY: 전체 데이터를 소그룹이나 나눠 칼럼을 명식
- HAVING: GROUP에 대한 조건을 기술

**GROUP BY절의 사용**
- GROUP BY 절에 기술되 칼럼이 반드시 SELECT절 뒤에 올 필요는 없으나 SELECT문 결과의 의미를 명확하게 하기 위해 기술하는 것이 좋다.

---

## 04. SQL 부터 Spring Data JPA까지

### Join이란?
- 하나 이상의 테이블로부터 연관된 데이터를 검색해 오는 방법

### Cartesian Join
- Join에 대한 조건이 생략되거나 잘못 기술되어 한 테이블에 있는 모든행들이 다른 테이블에 있는 모든 행들과 Join 되어
  얻어진 경우를 Cartesian Join 이라고 한다(의미가 없는 데이터들)
```SQL
select * from employees, departments;
```
- Cartesian Product를 얻지 않기 위해 반드시 WHERE 절을 써준다.
- (JOIN하는 테이블의 수 - 1)개의 JOIN조건이 필요하다.

### Simple Join
문법
```
SELECT t1.col1, t1.col2, t2.col1 ...
FROM Table1 t1, Table2 t2
WHERE t1.col3 = t2.col3
```
- FROM 절에 필요한 모든 테이블을 적는다.
  - 칼럼 이름의 모호성을 피하기 위해 (어느 테이블에 속하는지 알 수 없을 수 있으므로 Table이름에 alias 사용) - 테이블 이름으로 직접 지칭 가능
  - 적절한 Join조건을 WHERE절에 부여(일반으로 테이블 개수 - 1개의 조인 조건이 필요)
  - 일반적으로 PK와 FK간의 = 조건이 붙는 경우가 많음

### JOIN 종류
- Cross Join(Cartesian Product): 모든 가능한 쌍이 나타남
- Inner Join: Join 조건을 만족하는 튜플만 나타남
- Outer Join: Join 조건을 만족하지 않는 튜플(짝이 없는 튜플)도 null과 함께 나타남
- Theta Join: 조건(theta)에 의한 조인
- Equi-Join: Theta Join & 조건이 Equal(=)
- Natural Join: Equi-Join & 동일한 Column명 합쳐짐
- Self Join: 자기 자신과 조인

---

## 05. SQL 부터 Spring Data JPA까지

### 조건(theta) Join
- 임의의 조건을 Join조건으로 사용가능
- Non-equi Join이라고도 함(=으로 나타낼수 없는)
```SQL
SELECT e.name, e.sal, s.grade
FROM emp e, salgrade s
Where e.sal BETWEEN s.local AND s.hisal
```

### Natural Join
- 두 테이블에 공통 칼럼이 있는 경우 별다른 조인 조건없이 공통 칼럼처럼 묵시적으로 조인되는 유형
- ANSI/ISO SQL1999를 따르는 ANSI JOIN 문법
```SQL
select * from departments natural join locations;
```
- 칼럼명이 같으면 무조건 join해주기 때문에 조심해서 써야한다.


### INNER JOIN - JOIN~USING
- Natural Join의 문제점 : 조인하고자 하는 두 테이블에 같은 이름이 칼럼에 많을 때 특정한 칼럼으로만 조인하고 싶다면 USING절을 이용한다.
- ANSI/ISO SQL1999를 따르는 ANSI JOIN문법.
```SQL
select * from employees natural join departments;
select * from employees join departments using(department_id);
```

### INNER JOIN - JOIN ~ON
- 공통된 이름의 칼럼이 없는 경우 가장 보편적으로 사용할 수 있는 유형
- WHERE절에 일반조건만 쓸수 있게 하고 조인 조건은 ON에 두어 보다 의미를 명확하게 하고 알아보기도 쉽다.
- ANSI/ISO SQL1999를 따르는 ANSI JOIN문법.
- ON부분을 WHERE절에서 작성 가능하다
```
select * from employees e join departments d on(e.department_id = d.department_id);
```

### OUTER JOIN
정의
- JOIN조건을 만족하지 않는 (짝이 없는) 튜플의 경우 NULL을 포함한 결과를 생성
- 모든 행이 결과 테이블에 참여

종류
- Left Outer Join: 왼쪽의 모든 튜플은 결과 테이블에 나타남
- Right Outer Join: 오른쪽의 모든 튜플은 결과 테이블에 나타남
- Full Outer Join: 양쪽 모두 결과 테이블에 참여

표현 방법
- NULL이 나올 수 있는쪽 조건에 '(+)'를 붙인다(Oracle의 경우)


### SELF JOIN
- 반드시 alias를 사용해야 한다.
```
# 사원의 이름과 그 사원의 상사이름을 함꼐 출력하시오(employee_id는 사원의것이면서도 상사의 것이다.)
select employee_id as '상사의 id', first_name as '상사의 이름' from employees where employee_id = 100;

select concat(e.first_name, ' ', e.last_name) as '사원의 이름', concat(h.first_name, ' ', h.last_name) as '상사의 이름'
from employees e, employees h where e.manager_id = h.employee_id;
# ANSI JOIN으로 변경 
select concat(e.first_name, ' ', e.last_name) as '사원의 이름', concat(h.first_name, ' ', h.last_name) as '상사의 이름'
from employees e join employees h on(e.manager_id = h.employee_id);
# 상사의 이름이 없는 경우도 출력
select concat(e.first_name, ' ', e.last_name) as '사원의 이름', concat(h.first_name, ' ', h.last_name) as '상사의 이름'
from employees e left join employees h on(e.manager_id = h.employee_id);
```
