### 리눅스 update
1. prompt 기호
   - # - 관리자
   - $ - 일반사용자
2. 패키지 update
    - # apt update
    - $ sudo apt update

### Thread LifeCycle
- 실행이 끝난(죽은) 스레드는 다시 실행할 수 없다.(IllegalThreadStateException)
- join()
- sleep() - 일정시간동안 CPU를 할당받지 않겠다.


### Critical section을 thread safe로 전환하는 방법
```java
synchronized void add(int value) {
    values[size] = value;
    size = size + 1
        }
```

- synchronized - 한번에 하나의 스레드만 접근가능 = semaphore(1) = mutex(상호 배제) = Mutual Exclusion
- 같은 인스턴스에 대해 접근할떄 synchronized 메소드는 다른 메소드의 접근을 막는다.
- 다른 인스턴스에 접근한다면 synchronized 메소드이더라도 다른 메소드의 접근을 막지 않는다.
- 결과적으로 작업은 동기적으로, 순차적으로 실행된다.