### Handler와 DAO
- Handler
  - UI 제공
  - 입력 화면
  - 출력화면

- DAO
  - 데이터 처리

**UI코드와 데이터 처리 코드 분리(DAO의 데이터 처리 방식이 바뀌더라도 Handler를 변경할 필요가 없다.) -> DAO, Handler의 재사용성이 좋아진다.**

### interface xxxDAO
**DAO를 변경하더라도 Handler를 변경하지 않아도 된다.**


### networking을 이용하여 데이터 공유하기
1. 개인용 App
   - 파일을 공유하지 않아도된다.

2. 업무용 App
   - 파일을 공유해야한다.

### 데이터 공유
1. 공유 폴더/ 공유 디스크
  - ex) Windows -  network drive, Linux - NFS(Network File System)
  - 문제점 - 여러 App이 같은 파일을 동시에 변경할 때 다른 App이 변경한 내용을 덮어쓰는 경우가 발생한다.

2. 데이터 공유 관리 시스템 도입
   - 하나의 파일 관리 앱이 여러 앱들로부터 요청을 받아 파일에 읽고 쓰고 응답을 보낸다.
     - 어플리케이션끼리 데이터를 덮어쓰는 문제를 해결하였다.
     - ClientApp <----------> ServerApp 구조가 되었다.
       - "Client/Server App" = "C/S 프로그램"