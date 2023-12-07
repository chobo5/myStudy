# Terms
<br>
<br>
***관계형 데이터베이스(RDB)***
 - 여러 데이터가 들어있는 여러 테이블을 조인하여 데이터, 테이블간의 관계 또는 링크를 설정할 수 있는 DB

***포트포워딩***
- https://nordvpn.com/ko/blog/port-forwarding-vpn/
- 특정한 포트로 들어오는 데이터 패킷을 다른 포트로 바꿔서 다시 전송해 주는 것.


***패킷(Pack + Bucket = Packet)***
- 정보를 보낼때 특정 형태를 맞춘 데이터 조각
- ex) 큰 사진을 보낼떄 사진은 작은 패킷들로 분할되며, 각 패킷에는 번호가 붙는다.

***DOM(Document Object Model)***
- https://poiemaweb.com/js-dom
- 브라우저 렌더링 엔진은 웹 문서를 로드한 후, 파싱하여 웹 문서를 브라우저가 이해할 수 있는 구조로 구성하여 메모리에 적재한다. 이때 문서의 모든 요소와 요소의 어트리뷰트, 텍스트 각각의 객체로 만들고 이들 객체를 부자관계로 표현할 수 있는 트리구조로 구성한 것이 DOM이다 

***Rendering(Web)***
- 웹브라우저의 렌더링 엔진이 HTML, CSS를 파싱하여 화면에 그려주는 것 

***TCP***

***Protocol***

***SCM(Software Configuration Management)***
- 소프트웨의 변경사항을 관리하는 프로세스, 변경사항(소스, 버전, 개발환경, 빌드구조, 문서) 이 통제되고 조직적인 방식으로 이루지도록 한다.
- 팀이 일관성을 유지하고 변경사항을 추적하며, 소프트웨어가 적절하게 문서화 되도록 돕는다.

***버전 관리 시스템***
- 형상관리 분야에서 소스코드, 버전관리를 처리하는 시스템
1. 로컬 버전관리 시스템(RCS-Revision Control System)
    - RCS는 파일에서 변경되는 부분(Patch)만 기억해 용량 문제를 해결한다
    - RCS에서의 버전 변경은 해당 버전까지의 일련의 변화들(Patch Set)을 적용/해제하는 식으로 동작한다.
    - 로컬에서만 동작 -> CVCS 등장
2. 중앙 집중식 버전 관리 시스템 (CVCS, Centralized Version Control System)
    - 파일 및 변경 이력 등을 서버로 옮긴 것
    - CVCS에서는 모든 클라이언트들이 단 하나의 데이터베이스만을 바라보므로 동기화 문제가 없고 관리가 편하다는 장점이
3. 분산식 버전 관리 시스템 (DVCS, Distributed Version Control System)
    - 각 클라이언트들이 모두 서버의 백업본을 가진다.
    - 서버가 죽거나 오프라인 상태에서도 버전 관리를 할 수 있고, 대부분의 버전 관리가 로컬에서 이루어지므로 속도도 빠르다

***git***
- .git - 변경기록을 보관하는 폴더

***Text File***
- 텍스트 편집기를 이용해 편집할 수 있다.
- .txt, .md, .html, .java, .css, .js, .xml, .yml....

***Binary File***
- 전용 편집기를 사용해야 편집할 수 있다.
- .jpg, .png, .mp4, .xls, .ppt, .pdf....

***JIT(Just In Time) Compile 방식***
- 실행사점(just in time)에 자주 실행하는 코들르 진짜 기계어로 바꿔놓고 그 기계어를 실행하여 실행속도를 높이는 방식.
- 실행시점에 컴파일하기 때문에 일시적으로 실행이 느려지는 문제가 있다.

***AOT(Ahead Of Time) Compile 방식***


***Maven***
- Maven은 빌드 도구이다.

***Build Script File***

***현업에서 사용하는 빌드도구***
 - Ant -> build.xml
 - \+ 의존 라이브러리(컴파일 또는 되지않은 코드들의 모임) 관리 기능
 - => Maven -> pom.xml
 - \+ 빌드스크립트를 작성 할 때 xml대신 groovy 언어 사용 -> 프로그래밍언어를 사용함으로써 보다 정밀하게 빌드 과정을 제어할 수 있다.
 - Gradle -> build.gradle



