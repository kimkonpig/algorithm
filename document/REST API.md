### REST API

#### REST<br/>
 - REpresentational State Transfer<br/>
 - 웹서비스를 개발할 때 사용되는 아키텍처의 일종<br/>
 - 특정 언어나 프레임워크 등이 아닌 http를 사용하는 통신에서 고려해야 하는 개발 방법론 또는 구조<br/>
 - RestAPI의 요소 : **Method**(POST, GET, PUT DELETE), **Resource**(URI), **Message**(json, xml 같은 포맷)<br/>
 - 웹사이트의 컨텐츠(텍스트, 이미지, 동영상), DB 내용 등을 전부 하나의 자원으로 파악하여<br/>
 각 자원의 고유한 URI(Uniform Resource Identifier)를 부여한다.<br/>
 - 해당 자원에 대한 CRUD 작업을 HTTP 기본 메소를 통해 처리한다.<br/>
 - 요청 메소드 : get, post, put, delete<br/>
 - 해당 메소드 호출 시 json 또는 xml 형식의 데이터를 요청자에게 전송하여 구현한다.

#### REST API 구현을 위한 6가지 제한 조건
1. http를 사용하여 통신하기 때문에 프로토콜의 기본 메소드만 사용하며, 단일 URI을 통해 고유하게 식별할 수 있어야 한다.
2. 클라이언트/서버 구조 : 클라이언트와 서버는 분리되어야 한다. 어떤 서버가 특정한 클라이언트에서만 사용 가능하다면 RestAPI라고 할 수 없다.
3. 무상태성 : 각 요청 간 클라이언트와 서버는 지속적인 연결이 되지 않으며, 상태정보(쿠키, 세션) 등을 따로 저장하지 않는다.
4. 캐시 처리 기능 : RestAPI는 http 통신을 기본으로 한 아키텍쳐이다. 따라서 http가 기본적으로 가지고 있는 기능들은 전부 사용할 수 있으며, 캐시 기능 또한 마찬가지이다.
5. 계층형 구조 : Rest 서버는 다중 계층으로 구성될 수 있으며 보안, 로드밸런싱, 암호화 계츠을 추가해 구조상 유연성을 둘 수 있다.
6. 자체 표현 구조 : RestAPI는 메시지만 보고도 해당 API 기능에 대한 이해가 쉬운 구조로 되어야 한다.

서버를 RestAPI로 개발하면 http를 사용하는 모든 클라이언트들은 해당 서버와 통신을 할 수 있게 되어 하나의 서버와 클라이언트가 1:N의 관계를 갖게 된다는 장점이 있다.


#### URI vs URL
- 모든 URL은 URI라고 할 수 있지만 모든 URI는 URL이라고 할 수 없다.
- URI : 자원의 식별자(파라미터)<br/>
- URL : 자원의 위치를 알려주는 유일한 주소<br/>
<br/>
https://example.com/123의 경우 URI 이지만 URL은 아님<br/>
https://example.com 까지가 URL, 123이라는 식별자를 이용해 내가 원하는 정보에 도달<br/>
<br/>
https://example.com/one/two/abc.html의 경우 URL이면서 URI<br/>

