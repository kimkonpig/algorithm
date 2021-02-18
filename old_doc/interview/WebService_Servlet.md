# Web Service & Servlet
>Web Service 동작 과정 이해하기<br/>
>Servlet 이해하기

## Web Service의 기본적인 동작 과정
### HTML Form -> Servlet -> HTML Web Page
 1. 사용자가 웹 페이지 form(HTML Form)을 통해 정보를 입력한다.(Input)
 2. Servlet의 doGet() 또는 doPost() 메소드는 입력한 form data에 맞게 DB 또는 다른 소스에서 관련된 정보를 검색한다.
 3. 검색한 data를 이용하여 사용자의 요청에 맞는 동적 컨텐츠(HTML Web Page)를 만들어서 제공한다.(Output)
  
### HTML Form 예시
 ```html
 <form name="loginForm" method="post" action="loginServlet">
   Username: <input type="text" name="username"/> <br/>
   Password: <input type="password" name="password"/> <br/>
   <input type="submit" value="Login" />
 </form>
 ```
  - method
    - form data를 서버에 전송하는 방식이다.
    - 사용할 HTTP method를 입력한다.(GET 또는 POST)
  - action
    - Servlet의 URL을 입력한다.
    - 입력한 URL로 request가 전달된다. 
    - 즉, WAS에서의 어떤 Servlet인지 지정하는 것이다.
  - submit
    - 버튼을 누르면 form data가 Servlet으로 넘어간다.
    
### Form Method
 form data를 서버에 전송하는 방식으로 GET, POST 두 가지의 HTTP Method가 있다.
  
#### 1. GET Method
  - form data(사용자가 입력한 정보)가 URL 뒤에 텍스트 문자열로 추가된다.(쿼리스트링)
  - data는 '?'를 기준으로 actionURL과 분리된다.
  - 1024byte 길이 제한이 있다.
  - 브라우저에서 웹 서버로 정보를 전달할 때 사용하는 기본 Method이다.
    - HTTP Method를 지정하지 않으면 GET Method을 사용한다.
  - 전달하는 data에 암호와 같은 민감한 정보가 있는 경우 GET Method를 사용해선 안된다.
    - URL은 노출되는 정보이므로 보안상 적절하지 않다.
  - 불필요한 요청을 제한하기 위해 캐시를 사용한다.
    - 정적 컨텐츠를 요청하고 나면 브라우저에 요청을 캐시 저장해둔다.
    - 같은 요청이 발생하면 서버로 요청을 보내지 않고 캐시된 데이터를 사용한다.
  - 사용 예
    - 읽기 또는 검색 위주의 작업에 사용한다.(DB에 영향 없음)
    - 같은 요청을 여러번 보내도 항상 같은 응답이 온다.(Idempotent)
  
#### 2. POST Method
  - RequestBody에 data를 입력하여 전달한다.
    - URL에 data가 노출되지 않기 때문에 GET Method보다 보안상 안전하다.
    - data가 브라우저 히스토리에 저장되지 않는다.
    - 사용 예
      - 주로 새로운 리소스를 생성할 때 사용한다.(DB에 영향 있음)
      - 같은 요청을 여러번 보내면 각각 다른 응답이 올 수 있다.(Non-Idempotent)
      - 뒤로가기/새로고침 시 데이터가 다시 전달된다.

## Servlet은 뭐야?
웹 기반 요청에 대한 동적인 처리가 가능한 하나의 클래스이다.
- Server Side에서 돌아가는 Java Program
- 개발자가 작성해야 하는 부분!

### Servlet의 기본적인 동작 과정
![image](https://user-images.githubusercontent.com/56284234/108310571-ee5e8f00-71f6-11eb-8fde-a09482eaedc7.png)<br/>
1. 웹 서버는 HTTP Request를 Web Container(=Servlet Container)에게 전달한다.
2. 요청 전달받은 Web Container는 HttpServletRequest, HttpServletResponse 객체를 생성한다.
3. web.xml 기반으로 HTTP Request가 어떤 URL과 매핑되어 있는지(어느 Servlet에 대한 요청인지) 확인한다.
4. Web Container는 service() 메소드 호출하기 전, Servlet 객체를 메모리에 올린다.
- Web Container는 해당 Servlet 파일을 컴파일한다.(.class 파일 생성)
- .class 파일을 메모리에 올려 Servlet 객체 생성한다.
- 메모리에 로드될 때 init() 메소드가 실행된다.(Servlet 객체 초기화)
5. Web Container는 Request가 올 때마다 Thread를 생성하여 처리한다.
- 각 Thread는 Servlet의 단일 객체에 대한 service() 메소드를 실행한다.
6. 해당 Servlet에서 service() 메소드를 호출한 후,<br/>
클라이언트의 GET, POST 여부에 따라 doGet() 또는 doPost()를 호출한다.
7. doGet() 또는 doPost() 메소드는 동적 페이지를 생성한 후 HttpServletResponse 객체에 응답을 보낸다.
8. 응답이 끝나면 HttpServletRequest, HttpServletResponse 두 객체를 소멸시킨다.

### Web Container(=Servlet Container)는 뭐야?
서블릿을 관리해주는 컨테이너다
- 클라이언트의 Request을 받고 Response를 할 수 있도록 웹서버와 통신한다.
- 대표적인 예) 톰캣(Tomcat) : 웹 서버와 통신하며 JSP와 Servlet이 작동하는 환경 제공

#### Web Container(=Servlet Container)의 역할
1. Servlet과 웹 서버와의 통신을 지원한다.
- 소켓 생성, listen, accept 등의 복잡한 과정을 Web Container는 API로 손쉽게 통신할 수 있게 한다.
- 개발자는 Servlet 구현에만 신경쓰면 된다.
2. Servlet 생명주기를 관리한다.
- Servlet 파일을 로드하여 객체화하고, init() -> service() 메소드를 호출한다.
- Servlet 종료 시 적절하게 GC 실행한다.
3. 멀티Thread 지원 및 관리
- Web Container는 Request당 새로운 자바 Thread를 생성한다.
- Request에 해당하는 Servlet 메소드가 실행되고 나면(service()가 return하면) Thread는 제거된다.

#### Servlet 생명주기(init -> service -> destroy)
1. 클라이언트의 Request가 들어오면 Web Container는 해당 Servlet이 메모리에 있는지 확인한다.
2. 해당 Servlet이 메모리에 없는 경우 init() 메소드를 호출하여 메모리에 로드한다.
- init() 메소드는 처음 한번만 실행된다.
- 실행 중 Servlet이 변경될 경우, 기존 Servlet을 파괴하고 init() 메소드를 통해 변경내용을 다시 메모리에 로드한다.
3. init() 메소드가 호출된 후 Request에 따라 service() 메소드를 통해 doGet() 또는 doPost()로 응답을 분기한다.
- Web Container가 Request를 받으면 가장 먼저 HttpServletRequest, HttpServletResponse 객체를 생성하는데 이 객체를 사용한다.
4. Web Container가 Servlet에 종료 요청하면 destroy() 메소드가 호출된다.
- Web Application이 갱신되거나 WAS가 종료될 때 Servlet에 종료 요청 **(확인필요!!)**
- destroy() 메소드는 한번만 실행된다.
- 종료 시 처리해야하는 작업은 destroy() 메소드를 오버라이딩하여 구현한다.


[출처1](https://blog.naver.com/dhboys92/222214149201)<br/>
[출처2](https://gmlwjd9405.github.io/2018/10/28/servlet.html)
