<h1> RFC(Remote Function Call) </h1>

- 같은 시스템(SAP SW, ABAP 프로그래밍) 또는 다른 시스템(C++, JAVA 등의 프로그래밍)의 호출지로부터 Function Module을 불러와 실행하는 Function Tools<br/>
- 다른 시스템의 실행 파일을 실행하거나 상호 데이터 교류 등으로 활용 가능<br/>
- RFC 호출 시에는 SAP이 클라이언트 및 서버 역할을 수행<br/>


<h1> SOAP(Simple Object Access Protocol) </h1>

- HTTP, HTTPS, SMTP 등을 사용하여 XML 기반의 메시지를 컴퓨터 네트워크 상에서 교환하는 형태의 프로토콜(통신규약)<br/>
- 즉, 다른 컴퓨터에 있는 데이터나 서비스를 호출하기 위한 통신규약으로 SOAP는 웹 서비스에서 기본적인 메시지를 전달하는 기반이 된다.<br/>
- SOAP에는 몇가지 형태의 메시지 패턴이 있지만, 보통의 경우 원격 프로시져 호출(Remote Procedure Call; RPC) 패턴으로, 네트워크 노드(클라이언트)에서 다른 쪽 노드(서버)로 메시지를 요청하고 서버는 메시지를 즉시 응답한다.
- SOAP는 XML을 근간으로 헤더와 바디를 조합하는 디자인 패턴으로 설계되어 있다.
- 헤더는 선택사항으로, 반복이나 보안 및 트랜젝션을 정보로 하는 메타 정보를 가지고 있다.
- 바디는 주요한 내용의 정보를 가지고 있다.

|구분|SOAP 기반 웹 서비스|RESTful 웹 서비스|
|----|-------------------|-----------------|
|배경 및 현황|1. 기업을 위한 비즈니스 응용에서부터 출발<br/> 2. IBM, Oracle 등을 선두로 하는 웹서버 벤더에서 주창<br/> 3. SOA 서비스는 대부분이 비즈니스 컴포넌트로서의 의미를 가짐|1. WEB2.0은 서비스 애플리케이션에서부터 시작<br/>2. 구글, 아마존과 같은 인터넷 서비스에서 주창<br/>3. 맵이나 뉴스, 가젯 등과 같이 UI 성격을 갖는 서비스가 대다수임|
|특징|1. The Machine-Readable Web : 사람보다는 기계가 해석할 수 있는 웹 <br/> 2. Stateful : 오퍼레이션 중 서비스 상태가 일관되게 유지, 관리되어야 함 <br/> 3. 엄격한 문법 검사, 서비스 계약에 충실 <br/> 4. 웹 서버 등 웹서비스 개발 환경이 지원되어야 함 |1. The Human-Readable Web : 사람이 해석할 수 있는 웹<br/> 2. Stateless : 오퍼레이션 중 서비스/리소스의 상태를 관리하지 않음(HTTP의 기본 메커니즘임), 필요한 경우에 직접 관리해야 함<br/> 3. 기본 XML만으로 서비스 개발 가능<br/> 4. 별도의 개발 환경 지원이 필요 없음<br/> |
|전달 메커니즘|Remote Procedure Call(RPC)|Publish/Syndicate Pattern|
|전달 프로토콜|SOAP/HTTP, SMTP|HTTP|
|서비스 명세|WSDL|WADL, XML, JSON, hREST(시맨틱 REST) 등|
|서비스 레지스트리|UDDI|-|
|필요스택|W3C의 WS-* 스택(WS-addressing, WS-security 등)|-|
|주요 적용 분야|트랜잭션 프로세싱|데이터와 UI프로세싱|
|현재의 문제점|어려운 사용법, 무거운 프로토콜|표준의 부재, 어려운 관리|


<h1> REST API </h1>


<h1> JDBC-MESSAGE </h1>


[SOAP, RESTful WebService 참고](https://helloworld-88.tistory.com/62)
