### 복습
- 강의 내용
    - 복습
    - Web 기술 소개
    - Web Application의 등장 배경과 활용 소개
- 과제
    - 개인 과제
- 실습 프로젝트
    - 57. 웹 어플리케이션 서버 구조로 전환하기 - 웹 기술 도입
    - 58. 리스너 및 웹 어플리케이션 저장소 활용하기
- 학습 점검 목록
    - server-side 랜더링과 client-side 랜더링을 설명할 수 있는가?
    - Servlet 인터페이스와 GenericServlet, HttpServlet 추상 클래스를 설명할 수 있는가?
    - 서블릿 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?
    - DD(Deployment Descriptor) 파일을 설명할 수 있는가?
    - 서블릿 배치 방법을 설명할 수 있는가?
    - Filter 인터페이스를 설명할 수 있는가?
    - 필터의 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?
    - 필터 배치 방법을 설명할 수 있는가?
    - 필터의 동작 과정을 설명할 수 있는가?
    - xxxListener 인터페이스를 설명할 수 있는가?
    - 리스너 생명주기에 따라 호출되는 메서드를 설명할 수 있는가?
    - GoF의 Chain of Responsibility 패턴을 필터를 이용하여 설명할 수 있는가?
    - GoF의 Observer 패턴을 리스너를 이용하여 설명할 수 있는가?


### 서블릿에서 출력하기
1. ServletResponse 객체로부터 getWriter() 메서드를 통해 PrintWriter 객체를 얻어온다.
2. print()메서드 호출시 buffer에 저장한다.
3. 응답으로 buffer에 저장된 문자를 전송한다.
   - 요청과 응답은 한번만 오고 가므로 buffer에 저장된 문자를 한번에 출력한다.
- 이때, 출력하는 문자열 포맷을 지정하지 않으면 default가 ISO-8859-1 이므로 한글이 깨지게된다.
- 따라서 MIME type과 문자표를 지정해야한다.
- res.setContentType("MIME Type;charset=문자표이름");
- 이 때, 반드시 출력스트림을 얻기 전에 setContentType을 호출해야 한다.
```java
@Override
    public void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException{
        resp.setContentType("text/plain;charset=UTF-8")
        PrintWriter out = resp.getWriter();
    }
```


### HTTP - Web Browser와 Web Server 사이에 데이터를 주고 받는 규칙
1. 요청
**헤더**
- RequestLine: Method SP Request-URI SP HTTP-Version CRLF
- general-header: 요청과 응답에 모두 사용된다. Date, Connection 등
- request-header: 요청에서 사용한다. Accept, Host, User-Agent 등
- entity-header: 서버에 보내는 데이터 정보를 의미한다. Content-Type, Content-Length
- CRLF(빈줄)
**바디**
- message-body(실제 entity): 서버에 보내는 데이터(POST 방식)

2. 요청 예시
- GET/Photo.jpg HTTP/1.1
- GET /upload/468f3261-7279-4a56-8164-76bb694b1910 HTTP/1.1
- Accept: image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8
- Accept-Encoding: gzip, deflate
- Accept-Language: en-US,en;q=0.9,ko;q=0.8
- Connection: keep-alive
- DNT: 1
- Host: 192.168.0.42:8888
- Referer: http://192.168.0.42:8888/ex04/s5
- User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36

3. 응답
**헤더**
- RequestLine: Method SP Request-URI SP HTTP-Version CRLF
- general-header: 요청과 응답에 모두 사용된다. Date, Connection 등
- response-header: 
- entity-header: 서버에 보내는 데이터 정보를 의미. Content-Type, Content-Length
- CRLF(빈줄)
**바디**
- message-body(실제 entity): 서버에 보내는 데이터(POST 방식)

4. 응답 예시
HTTP/1.1 200
Accept-Ranges: bytes
ETag: W/"620933-1708599732794"
Last-Modified: Thu, 22 Feb 2024 11:02:12 GMT
Content-Length: 620933
Date: Thu, 22 Feb 2024 11:02:12 GMT
Keep-Alive: timeout=60
Connection: keep-alive


### GET vs POST
1. GET
   - 데이터 전송: URL에 포함
   - binary 데이터 전송: X(단, binary 데이터를 base64로 인코딩해서 텍스트로 변환한다면 가능하다.)
   - 전송 크기: 웹 서버에서 설정된 크기(보통 64KB 또는 8K)
   - 보안: 웹 브라우저는 URL을 보관한다 -> 따라서 데이터가 노출된다.
   - 용도: URL에 데이터를 포함해야 하는 경우(게시물 조회)
2. POST
  - 데이터 전송: message-body에 실어 보낸다.
  - binary 데이터 전송: multipart/form-data 포맷으로 인코딩하여 보낼 수 있다.
  - 전송 크기: 서블릿에서 제한하지 않는다면 제한되지 않는다.
  - 보안: 데이터 노출 안됨
  - 용도: 게시글 등록과 같은 대량의 데이터 전송, binary 데이터 전송