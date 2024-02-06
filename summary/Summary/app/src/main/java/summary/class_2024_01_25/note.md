### 복습
- 강의내용
- 복습
- 멀티 스레드 프로그래밍(com.eomcs.concurrent)
- 실습 프로젝트
- 학습 점검 목록
- 스레드의 생명주기를 설명할 수 있는가?
- sleep(), join() 메서드의 사용법을 아는가? 
  - not runnable, blocking
- 스레드의 우선순위를 설명할 수 있는가? 
  - 우선순위를 설정할 수 있지만 os에 종속되므로 사용하지 않을것을 권장
- critical section을 설명할 수 있는가? 
  - 여러 스레드가 접근해 의도하지 않은 값이 나올 수 있는 코드 
- Thread safe를 설명할 수 있는가?
  - 여러 스레드가 접근하여도 한번에 하나의 스레드만 작업하도록 하여 결과를 보장함
- critical section을 thread safe로 만드는 방법을 설명할 수 있는가?
  - synchronized 사용
- semaphore(n)와 mutex를 설명 할 수 있는가?
  - semaphore(n)은 한번에 작업할 수 있는 스레드의 개수 n
  - sempaphore(1) = mutex - 상호 배제 
- synchronized 메서드 또는 블록의 동작을 이해하는가?
  - 같은 인스턴스에 접근하면 블럭을 잠근다.
  - 다른 인스턴스에 접근하면 접근을 허락한다.

### 스레드생성 과정
1. JVM -- 스레드 생성 요청 --> OS
2. OS가 스레드를 생성한후 JVM에게 스레드 정보를 반환
   - 스레드 생성에는 시간이 소요된다.
   - 메모리를 사용한다.
   - 즉, 자주 스레드를 생성하고 버리면 실행 시간과 메모리 효울성이 떨어진다.
   - 따라서 스레드를 재사용 해야한다.
3. JVM이 thread 인스턴스를 생성
4. thread 인스턴스를 이용해 스레드를 제어한다.
   - peer(스레드 인스턴스와 OS의 스레드의 관계)

### 스레드 재사용
1. new Thread -- start() --> Running
   - run()메서드 실행이 종료되어 dead상태가 되지 않도록 해야한다.
   - wait()사용
2. 작업이 끝났다면 Running -- wait() --> Not Runnable 상태
3. 작업을 다싯 시작해야 한다면 Not Runnable 상태 -- notify() --> Running

#### myapp에 적용시키기
- 기존 방식은 Thread 사용후 버린다.
- pooling 기법 적용
- GoF의 FlyWeight 디자인 패턴

### Java의 Thread pool -> ExecutorService
1. Executor.newFixedThreadPool(3) --생성--> ExecutorService
2. execute(Runnable 구현체)
3. ExecutorService --생성--> Thread
4. Thread --start()--> Runnable 구현체 실행
5. 실행이 끝나면 pool에 보관