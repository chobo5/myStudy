### IP주소와 도메인명(호스트명 + 도메인명; www(host name).naver.com(domain name))
1. www.naver.com입력 ---------> PC(31.2.4.57) ---------> Naver server(211.35.7.8)
2. PC는 DNS서버에 IP주소를 요청한다.
3. DNS는 naver.com DNS 서버 주소를 알려준다.
4. Naver DNS Server에 www 호스트의 IP주소를 요청한다.
5. 211.35.7.8을 PC에 알려준다.
6. 211.35.7.8 naver 서버 컴퓨터에 연결한다.

### Connection Oriented vs Connectionless
- Connection Oriented(TCP)
  1. 연결
  2. 데이터 송수신
  3. 연결 끊기
  - ex) 전화 통화
    - 데이터 송수신을 보장한다.
    - 연결과정에 시간이 소요된다.

- Connectionless(UDP)
  1. 데이터 전송
  2. 응답 데이터 수신
  3. 서버가 실행중이지 않다면 응답을 받지 못한다.
  - ex) 편지
    - 데이터 송수신을 보장하지 않는다.
    - 연결과정이 없기때문에 TCP보다 빠르다.

- HTTP1, HTTP2
  - TCP 방식

속도를 높이기 위해 연결에 소요되는 시간을 제거===> 

- HTTP3
  - UDP 방식

### TCP/IP - write()
**Application - TCP - IP - NIC(랜카드)**
1. 데이터
2. TCP에서 전송단위(packet)로 데이터 분할


### TCP/IP - read()
