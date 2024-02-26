### 복습
- 강의 내용
    - 복습
    - Web 기술 소개
    - Web Application의 등장 배경과 활용 소개
- 과제
    - 개인 과제
    - GET/POST 요청 다루기
    - refresh/redirect 다루기
    - forward/include 다루기
- 실습 프로젝트
- 학습 점검 목록
  - GET/POST 프로토콜의 특징을 이해하고 프로젝트에 적용할 수 있는가? 
  - refresh와 redirect의 특징을 설명할 수 있는가? 
  - forward/include의 특징을 설명할 수 있는가? 


### forward 응용
- forwarding시 request, response를 넘겨주는것은 같은 request, response를 공유한다는 의미이다.

### cookie
1. 쿠키 저장하기
    - 웹브라우저가 servlet에 요청을 보낸다.
    - servlet이 쿠키를 생성해 응답에 실어 보낸다.
    - 브라우저는 쿠키를 로컬에 저장한다.

2. 쿠키 읽기
    - 웹브라우저가 로컬에 있는 쿠키를 로드한다.
    - 요청과 함께 쿠키를 servlet에 보낸다.
    - servlet이 쿠키를 읽고 응답한다.
- 클라이언트는 웹서버에서 받은 쿠키를 해당 웹서버에 방문할 때 마다 보낸다.
   