### 복습
강의 내용
복습(1)
실습 프로젝트
페이지 컨트롤러를 자동 생성하기(계속)
IoC 컨테이너 만들기
Spring IoC 컨테이너 도입하기
최종 팀 프로젝트
UI 프로토타입 작성
학습 점검 목록
Reflection API를 사용하여 클래스를 로딩하고 인스턴스를 생성할 수 있는가? []
Spring IoC 컨테이너를 설정하고 사용할 수 있는가? []


### 발생한 에러
1. cookie는 값이 없으면 null을 반환하지 않고 에러를 던지기 때문에 
    값이 없을수 있다면 isRequired = flase 또는 defaultValue를 설정해주자
2. domain의 프로퍼티는 DB로 부터 데이터를 담기 위한 클래스이다.
   Spring MVC의 MultipartResolver 빈은 multipart-form 형식의 데이터(Part)를 처리하는데
   이 데이터와 다른 데이터를 Board 객체에 담으려고 할때, Board의 files의 타입은 ArrayLisy<AttacedFile>이고 멀티파트폼 형식의 데이터는 Part[]이기 때문에
   충돌이 일어난다.