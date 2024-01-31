- 강의 내용
    - 복습
    - SQL 사용법
- 실습 프로젝트
- 학습 점검 목록
    - 테이블을 생성, 변경, 삭제할 수 있는가?
    - not null/null 옵션을 사용할 수 있는가?
    - 컬럼의 타입을 다룰 수 있는가?
    - key, candidate key, primary key, alternate key, artificial key(= surrogate key)를 설명할 수 있는가?
    - primary key, unique, index 컬럼을 설정할 수 있는가?
    - auto_increment 제약 조건을 설정할 수 있는가?
    - 기존 테이블에 칼럼을 추가하거나 변경할 수 있는가?
    - view를 생성하고 삭제할 수 있는가?

### Transaction(트랜잭션)

- 한 단위로 묶은 작업
- set autocommit = false
    - 작업이 임시 DB에 기록된다.(insert, update , delete..)
    - select시 실제 테이블의 데이터 + 임시 작업 결과 형태로 보여진다.
    - commit 명령시 실제 테이블에 적용된다.
    - rollback 명령시 임시 작업 결과는 모두 취소된다.
- commit, rollback은 모두 connection을 기준으로 이루어진다.
- 이렇게 여러개의 작업을 묶어 한 단위로 다룰 수 있다.
- 트랜잭션 즉, 하나의 업무는 여러개의 작업이 모두 완료되었을떄 완료되어야 한다.
    - ex) 주문 정보 + 결제 + 배송 = 하나의 주문 업무 완료

### SQL

1. select 칼럼명1, 칼럼명2 from 테이블명 where 조건;
    - projection: 칼럼 선택
    - selection: 칼럼중 선택한 데이터

### SQL의 실행 순서

#### Select문
```
SELECT 번호, 이름, 제품명, (수량 * 가격) as 총액
FROM 고객 join 주문 on 고객.번호 = 주문. 고객 번호
WHERE 가격 >= 10000
ORDER BY 가격 DESC

```


FROM - > ON -> JOIN -> WHERE -> GROUP BY -> HAVING -> SELECT -> DISTINCT -> ORDER BY

| 번호 | 이름   | 나이 | 성별 |
|----|------|----|----|
| 1  | kim  | 20 | F  |
| 2  | park | 30 | M  |
| 3  | lee  | 40 | M  |
| 4  | jo   | 18 | F  |
| 5  | choi | 60 | M  |
| 6  | jang | 30 | F  |
| 7  | yu   | 22 | F  |
| 8  | shin | 33 | F  |


| 주문 번호 | 제품명 | 수량| 가격 | 고객번호 |
|-------|------|-------|------|
| 1 | aaa |1 | 27000 | 1 |
| 2 | bbb |2 | 3000 | 1 |
| 3 | ccc |3 | 18000 | 2 |
| 4 | ddd |2 | 5000 | 4 |
| 5 | eee |10 | 7000 | 5 |
| 6 | fff |2 | 31000 | 7 |


| 번호 | 이름   | 나이 | 성별 | 주문 번호 | 제품명 | 수량 | 가격    | 고객번호 |
|----|------|----|----|-------|-----|----|-------|------|
| 1  | kim  | 20 | F  | 1     | aaa | 1  | 27000 | 1    |
| 1  | kim  | 20 | F  | 2     | bbb | 2  | 3000  | 1    |
| 1  | kim  | 20 | F  | 3     | ccc | 3  | 18000 | 2    |
| 1  | kim  | 20 | F  | 4     | ddd | 2  | 5000  | 4    |
| 1  | kim  | 20 | F  | 5     | eee | 10 | 7000  | 5    |
| 1  | kim  | 20 | F  | 6     | fff | 2  | 31000 | 7    |
| 2  | park | 30 | M  | 1     | aaa | 1  | 27000 | 1    |
| 2  | park | 30 | M  | 2     | bbb | 2  | 3000  | 1    |
| 2  | park | 30 | M  | 3     | ccc | 3  | 18000 | 2    |
| 2  | park | 30 | M  | 4     | ddd | 2  | 5000  | 4    |
| 2  | park | 30 | M  | 5     | eee | 10 | 7000  | 5    |
| 2  | park | 30 | M  | 6     | fff | 2  | 31000 | 7    |
| 3  | lee  | 40 | M  | 1     | aaa | 1  | 27000 | 1    |
| 3  | lee  | 40 | M  | 2     | bbb | 2  | 3000  | 1    |
| 3  | lee  | 40 | M  | 3     | ccc | 3  | 18000 | 2    |
| 3  | lee  | 40 | M  | 4     | ddd | 2  | 5000  | 4    |
| 3  | lee  | 40 | M  | 5     | eee | 10 | 7000  | 5    |
| 3  | lee  | 40 | M  | 6     | fff | 2  | 31000 | 7    |
| 4  | jo   | 18 | F  | 1     | aaa | 1  | 27000 | 1    |
| 4  | jo   | 18 | F  | 2     | bbb | 2  | 3000  | 1    |
| 4  | jo   | 18 | F  | 3     | ccc | 3  | 18000 | 2    |
| 4  | jo   | 18 | F  | 4     | ddd | 2  | 5000  | 4    |
| 4  | jo   | 18 | F  | 5     | eee | 10 | 7000  | 5    |
| 4  | jo   | 18 | F  | 6     | fff | 2  | 31000 | 7    |
| 5  | choi | 60 | M  | 1     | aaa | 1  | 27000 | 1    |
| 5  | choi | 60 | M  | 2     | bbb | 2  | 3000  | 1    |
| 5  | choi | 60 | M  | 3     | ccc | 3  | 18000 | 2    |
| 5  | choi | 60 | M  | 4     | ddd | 2  | 5000  | 4    |
| 5  | choi | 60 | M  | 5     | eee | 10 | 7000  | 5    |
| 5  | choi | 60 | M  | 6     | fff | 2  | 31000 | 7    |
| 6  | jang | 30 | F  | 1     | aaa | 1  | 27000 | 1    |
| 6  | jang | 30 | F  | 2     | bbb | 2  | 3000  | 1    |
| 6  | jang | 30 | F  | 3     | ccc | 3  | 18000 | 2    |
| 6  | jang | 30 | F  | 4     | ddd | 2  | 5000  | 4    |
| 6  | jang | 30 | F  | 5     | eee | 10 | 7000  | 5    |
| 6  | jang | 30 | F  | 6     | fff | 2  | 31000 | 7    |
| 7  | yu   | 22 | F  | 1     | aaa | 1  | 27000 | 1    |
| 7  | yu   | 22 | F  | 2     | bbb | 2  | 3000  | 1    |
| 7  | yu   | 22 | F  | 3     | ccc | 3  | 18000 | 2    |
| 7  | yu   | 22 | F  | 4     | ddd | 2  | 5000  | 4    |
| 7  | yu   | 22 | F  | 5     | eee | 10 | 7000  | 5    |
| 7  | yu   | 22 | F  | 6     | fff | 2  | 31000 | 7    |
| 8  | shin | 33 | F  | 1     | aaa | 1  | 27000 | 1    |
| 8  | shin | 33 | F  | 2     | bbb | 2  | 3000  | 1    |
| 8  | shin | 33 | F  | 3     | ccc | 3  | 18000 | 2    |
| 8  | shin | 33 | F  | 4     | ddd | 2  | 5000  | 4    |
| 8  | shin | 33 | F  | 5     | eee | 10 | 7000  | 5    |
| 8  | shin | 33 | F  | 6     | fff | 2  | 31000 | 7    |

1. from 고객 join 주문
2. on 고객.번호 = 주문. 고객 번호
3. where 가격 >= 10000
4. select 번호, 이름, 제품명 (수량 * 가격) as 총액
5. order by 가격 desc

### 부모 테이블과 자식 테이블

- Board(no, title, content, regdate, file1, file2, file3)
- => 중복 컬럼이 있을 경우 분리한다(제 1정규화)
- Board(no(PK), title, content, regdate)
- AttachedFile(file-no, path, board_no(FK))
    - board_no(Foreign Key)는 부모 테이블의 no(Primary Key)를 참조한다.
