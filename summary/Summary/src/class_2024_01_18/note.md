### TCP/IP 네트워킹
1. 여러대의 컴퓨터는 HUB(+공유기)에 연결되어있다.
2. HUB는 GATEWAY에 연결되어있다.
3. GATEWAY는 통신사(KT, SKT..)에 연결되어있다.
4. 데이터(+발신지, 수신지)는 여러 라우터를 거쳐 전달된다.


### I/O
- JVM은 내부적으로 UTF-16BE를 사용한다.


#### FileWriter
1. JVM의 file.encoding변수에 설정된 문자집합을 사용한다.
2. 설정되어 있지 않다면, OS가 사용하는 문자집합을 사용한다.
   - windows: MS949, linux/macOS: UTF-8
과정
1. 76 6B AC 00 <==UTF-16BE
   - 두의 2byte를 사용
2. write()
   - encoding(UTF-16-BE --> file.encoding에 설정된 문자집합)
3. EA B0 80
