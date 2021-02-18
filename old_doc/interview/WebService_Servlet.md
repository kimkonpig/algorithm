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
        
[출처1](https://blog.naver.com/dhboys92/222214149201)<br/>
[출처2](https://gmlwjd9405.github.io/2018/10/28/servlet.html)
