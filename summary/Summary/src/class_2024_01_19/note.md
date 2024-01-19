### IO Stream 클래스
#### byte stream(InputStream/ OutputStream)
1. **Concrete Component**
   - FileInputStream/FileOutputStream
   - ByteArrayInputStream/ByteArrayOutputStream
   - PipedInputStream/PipedOutputStream(표준 입출력)
2. **Decorator**
   - DataInputStream/DataOutputStream
   - BufferedInputStream/BufferedOutputStream
 

#### character stream(Reader, Writer)
1. **Concrete Component**
   - CharArrayReader/CharArrayWriter
   - StringReader/StringWriter
   - PipedReader/PipedWriter
2. **Decorator**
   - BufferedReader/BufferedWriter
   - LineNumberReader/LineNumberWriter
   - PrintReader/PrintWriter

#### 구조
- Component(InputStream)
  - ConcreteComponent(FileInputStream)
  - Decorator(FilterInputStream <- DataInputStream, BufferInputStream) - 독립적으로 사용x


### Stateful 통신방식
- 연결한 후 연결을 끊을때까지 요청/응답을 계속 수행
- 클라이언트가 요청하지 않아도 계속 연결된 상태를 유지(서버의 메모리를 계속 차지, 접속 클라이언트 수가 제한된다.)
- 클라이언트 요청에 대한 작업결과를 서버에 유지할 수 있다.

### Stateless 통신방식
- 요청/읍답을 수행한 수 즉시 연결 끊음
- 요청할 때마다 매번 연결 필요
- 클라이언트와 작업한 내용은 서버에 유지하지 못한다.
- 서버 메모리를 

### stateless에서 client를 구분하는 방법
1. clientId와 parameter에 값을 담아 서버에 보낸다.
2. id가 있다면 새로운 id를 발급하고 결과값을 db에 저장한다.
3. clientId와 결과값을 client에게 보내고 client는 clientId를 저장한다.
4. 연결을 끊는다.
5. clientId와 새로운 연산을 담아 서버에 보낸다.
6. db에서 clientId를 찾아 결과값을 저장한다. 

**하지만 stateful이든 stateless방식이든 작업을 처리중일때는 다른작업을 대기시켜야한다.**


### Thread
#### main Thread - 기본 실행 흐름
- JVM -> main thread -> main()
- 실행흐름이 하나의 연결된 선으로 진행된다.(항상 main()으로 돌아와서 종료한다.)

#### 멀티 스레드
- 새로운 실행흐름을 만든다.
- 여러 스레드가 나란히(병행) 실행


#### 스레드 만들기
- main 실행 흐름과 분리해서 독립적으로 실행하고 싶은 코드
- Thread를 상속받아 run()메소드를 overriding 한다.

#### 스레드 실행
1. Thread를 상속받아 overriding한 클래스의 인스턴스를 생성시키고 start()메서드를 호출한다.


2. Runnable 인터페이스를 구현한 인스턴스를 인자로 갖는 Thread 인스턴스를 만들어 start()메서드를 호출한다.
   - 익명클래스 생성
   - 람다식 활용
