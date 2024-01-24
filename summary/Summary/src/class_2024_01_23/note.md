### 병행 처리(Concurrency)
1. 프로세스 복제(fork)
   - code segment(기계어)와 data segment(heap)로 이루어진 프로세스를 복제한다.
   - 프로세스가 사용하는 heap메모리도 복제하기 떄문에 메모리 사용이 과도하게 증가한다.
2. 스레드
    - 코드 실행에 필요한 스택 메모리만 스레드별로 관리한다.
    - data segment에 대한 실행 위치 정보를 가지고 있다.
    - 프로세스의 heap 메모리를 공유하기 떄문에 메모리 사용이 적다.
   
### naver cloud vpc
#### VPC(Virtual Private Cloud) - 가상의 개인 네트워크 공간
1. VPC = 10.1.0.0/16 (앞의 10.1 16비트는 고정)
   - 10.1.0.0 ~ 10.1.255.255 
   - 256 * 256 = 65536개
2. Network ACL = 접근 제어 규칙
3. Subnet = 10.1.1.0/24
   - 10.1.1.0 ~ 10.1.1.255: 256개
   - VPC를 IP주소의 법위를 이용해 구획한다
4. Server ACG - 서버 접근 제어 규칙(방화벽)
5. Linux 서버

### Java Thread
- $java hello

### JVM의 기본 스레드
- JVM
  - system(TG)
    - main(TG)
      - main thread(T)
    - Innocuous ThreadGroup(TG)
      - Common-Cleaner(T)
    - Reference Handler(T)
    - Finalizer(T)
    - Signal Dispatcher(T)
    - Notification Thread(T)

### CPU Scheduling - OS가 관리
- 여러 프로스세를 돌아가면서 실행하는 규칙

1. Round-Roblin(Windows)
   - 일정 시간을 돌아가면서 시행
2. Priority Scheduling + aging(Unix/Linux)
   - 우선순위가 높은 프로세스를 더 자주 실행한다.

### context(실행 정보) switching(교환)
1. A process 실행
2. A의 실행 상태 저장
3. B process 실행
4. B의 실행 상태 저장
5. A의 실행 상태 로딩
6. A process 이어서 실행
7. A의 실행 상태 저장
8. B의 실행 상태 로딩
9. process 이어서 실행
- context switching이 너무 자주 일어난다면 비용이 많이들고 비효율적이다.


