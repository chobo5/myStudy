### myapp 프로젝트의 디렉토리 구조

```agsl
//setting.gradle
rootProject.name = 'myapp'
include('app')
```

- /myapp - root project
  - app/ - main project
    - build.gradle


=====변경====>

```agsl
//setting.gradle
rootProject.name = 'myapp'
include('app-client')
include('app-server')
include('app-common')
```

- /myapp - root project
  - app-client/ - main project
    - build.gradle
  - app-server/ - main project
    - build.gradle
  - app-commom/ - 공유 라이브러리 프로젝트
    - build.gradle


### myapp client/server
ClientApp    응답<=====통신=====>요청    ServerApp

**요청 규칙(protocol)**
- 데이터명
  - ex) board
- 명령
  - ex) findAll
  - ex) add
  - delete
- 데이터(entity) - JSON 형식
  - ex) 빈 문자열
  - ex) {"title":"xxxx",....}
  - ex) 27

**응답 규칙(protocol**
- 상태코드
  - 200: ok
  - 200: {"no":207, "title":"xxxxx"....}
  - 300: 
- 데이터(entity) - JSON 형식


### Socket - 상대편 연결 정보
- 상대방 IP주소
- 상대방 포트번호
- 랜카드 정보
- getInputStream() -> InputStream객체를 리턴 -> read(), read(byte[])...
- getOutputStream() -> OutputStream객체를 리턴 -> write(), write(byte[])...

### ServerSocket.accept()
1. 여러 클라이언트가 서버에 연결 요청을 보낸다.
2. Server는 연결요청 순서대로 대기목록에 저장하고 연결정보를 꺼낸다.
3. 연결정보가 없다면 들어올떄까지 대기한다.


### client - server 연결
------------------서버------------------
1. ServerSocket ss = new ServerSocket(8888);
   - 서버소켓이 대기열을 생성한다.
2. ss.accept();
   - 클라이언트 연결정보가 대기열에 들어올때까지 대기한다.
------------------클라이언트------------------
3. new Socket(127.0.0.1, 8888);
   - 클라이언트에서 소켓을 생성 및 리턴한다.
------------------서버------------------
4. 클라이언트 연결정보가 대기열에 들어간다.


### 네트워킹 입출력 read()/write()

**write()**
- 랜카드의 메모리로 출력된다.
- 상대편이 읽을떄까지 기다리지 않고 즉시 리턴한다.

**read()**
- 상대편이 보낸 데이터는 램에 보관된다.
- 램에 보관된 데이터를 읽으면 리턴한다.
- 데이터가 없으면 상대편이 보낸 데이터가 들어올때까지 리턴하지 않는다.

### 네트워크 DAO구현
