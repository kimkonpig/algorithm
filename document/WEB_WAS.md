## Apache?
- Apache는 소프트웨어 단체 이름
- Apache Server는 이 단체에서 후원하는 오픈소스 프로젝트 커뮤니티에서 만든 'http web server'를 지칭하는 말이다.
- http web server는 http 요청을 처리할 수 있는 web server이다.
- 즉 Apache Server는 http 요청을 처리하는 web server를 말한다.
- 클라이언트가 http method(get, post, delete 등)를 이용해 작업 요청을 하면 web server에서 요청에 대한 응답을 보낸다.

## Tomcat?
- Tomcat은 WAS의 종류중 하나이다.
- WAS는 Web Application Server의 줄임말이다. WAS는 웹서버와 웹 컨테이너가 결합된 서버이다.

## WEB / WAS
### Web Server와 WAS 관련 내용은 기존 블로그 포스팅에서 볼 수 있다.
아래 내용과 동일(https://blog.naver.com/kon_pig/222110015908)

### WEB(Web Server)
- 웹브라우저(클라이언트)에게 정적인 콘텐츠를 제공하는 서버
- HTML, CSS, 이미지 등의 파일을 HTTP 프로토콜을 통해 서비스한다.

### WAS(Web Application Server)
- 웹 애플리케이션이 동작하는 미들웨어
- DB조회, 다양한 로직 처리를 요구하는 동적인 콘텐츠를 제공하는 서버
- 웹 컨테이너 혹은 서블릿 컨테이너로도 불림

### WEB / WAS 차이점
- Web Container 유무<br/>
(Container : JSP, Servlet을 실행시킬 수 있는 소프트웨어)<br/>
(Servlet : 자바를 사용하여 웹을 만들기 위해 필요한 기술, 웹프로그래밍에서 클라이언트의 요청을 처리하고 그 결과를 다시 클라이언트에게 전송하는 Servlet 클래스의 구현 규칙을 지킨 자바 프로그래밍 기술)

- WAS는 정적, 동적 처리 둘 다 가능하지만 WEB, WAS를 분리하여 사용하는 게 좋음
  - 정적 처리는 WEB, 동적 처리는 WAS 분리하여 서버 부하 방지
  - 물리적으로 분리하여 보안 강화
  - 여러대의 WAS 연결 가능
  - 여러 웹 애플리케이션 서비스 가능
