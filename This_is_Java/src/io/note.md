### Stream
- 단방향으로 데이터가 흐르는 것.
- byte stream: 그림, 멀티미디어,문자등 모든 종류의 데이터를 입출력할 때 사용
  - java.io.InputStream
  - java.io.OutputStream
- char stream: 문자만 입출력할 때 사용
  - java.io.Reader
  - java.io.Writer

### ByteStream
#### 출력
- write(int b): 1byte 출력
- write(byte[] b): 매개값으로 주어진 배열 b의 모든 바이트를 출력
- write(byte[] b, int off, int len): 매개값으로 주어진 배열 b[off] 부터 len개의 바이트를 출력
- flush(): 출력버퍼에 잔류하는 모든 바이트를 출력
- close(): 출력 스트림을 닫고 사용 메모리 해제
- 

### CharStream
