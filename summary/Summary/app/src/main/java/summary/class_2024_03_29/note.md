### URL 주소 다루기
1. Web Browser의 입장 -> HTML이나 JavaScript에서 URL을 읽을때
    - 현재 URL = http://localhost:8888/web/app/board/form
    - <a href="add"> -> http://localhost:8888/web/app/board/add
    - <a href="/add"> -> http://localhost:8888/add
    - <a href="../../add"> -> http://localhost:8888/web/add
2. Thymeleaf 입장 -> 서버의 HTML 템플릿에 지정된 경로
    - 현재 URL = http://localhost8888/web/app/board/form 
    - @{add} -> http://localhost:8888/web/app/board/add
    - @{/add} -> http://localhost:8888/web/add
    - @{~/add} -> http://localhost:8888/add
- 