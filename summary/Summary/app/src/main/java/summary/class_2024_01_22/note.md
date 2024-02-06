#### conection-oriented / connectionless
1. connection-oriented = TCP
   1. client의 소켓을 server의 소켓과 연결

2. connectionless = UDP
   1. client측에서 DatagramSocket과 DatagramPacket생성(byte배열, byte배열길이, 상대편IP주소, port번호)
   2. packet을 socket에 담아 send()
   3. HUB
   4. router
   5. server측 DatagramSocket(포트번호)
   6. receive() (데이터를 받을때까지 블로킹)
   7. DatagramPacket
   8. byte[] (데이터를 받을 빈 배열)


#### URI/URL/URN
- URI(Uniform Resource Identifier) - URL과 URN을 포괄하는 상위 개념이다.
  - URL(Uniform Resource Location)
    - ex) http://naver.com:80/search?
  - URN(Unifrom Resource Name)
    - ex) urn:isbn:04517501

#### 병행처리
- 한개의 작업을 동시에 여러개 실행한다
  - 순차적으로 여러번 실행하는 것보다 대기시간이 적다.
- 사용
  - 작업 순서가 상관이 없는 경우
  - 서로 간섭하지 않는 작업의 경우
