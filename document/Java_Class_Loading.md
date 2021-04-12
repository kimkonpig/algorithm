# Java Class Loading Process(자바 클래스 로딩 과정)
.java 파일로 작성된 소스코드가 JVM 위로 어떤 과정으로 로딩되는지 알아보기 위한 글

## .java & .class 파일
- 자바 파일
  - 확장자가 .java 인 파일이다.
  - 자바언어로 소스코드를 작성할 때 그 내용을 적는 파일이다.
- 클래스 파일
  - 자바 파일을 자바 컴파일러로 컴파일한 파일이다.
  - .class 확장자를 가진다.
  - 이클립스와 같은 IDE 혹은 커맨드라인에서 javac 명령어를 통해 컴파일했을 때 발생되는 파일이다.
  - 자바의 클래스 로더(Class Loader)가 JVM으로 이 클래스 파일을 로딩한다.

## 클래스 로딩 과정
- 클래스 로드(Class Loader)가 .class 파일의 위치를 찾아 그 파일을 JVM 위에 올려놓는 과정을 말한다.
- .class 파일을 JVM에 로딩하기 전에, JVM을 실행하기 위해 여러 클래스 파일들을 사전에 로딩하는 작업이 진행된다.

![image](https://user-images.githubusercontent.com/56284234/114337709-94da6700-9b8c-11eb-9fbc-d9bee59dde2c.png)
- JVM을 실행할 때 각 클래스 로더들은 자신이 호출할 수 있는 클래스들을 호출하여 JVM을 동작시키고 클래스 파일을 JVM에 로딩한다.
- 클래스 로더들은 계층적 구조를 가지고 있다.
- BootStrap <- Extension <- System <- User-defined 과 같은 구조를 가진다.

### Class Loader 특징
1. 계층적 구조(Hierachical) : 클래스 로더들은 부모-자식 관계의 계층적 구조를 가지고 있다.
2. 로딩 요청 위임(Delegate Load Request) : 예를 들어 System Class Loader가 A라는 클래스를 로딩할 때,<br/>
그 로딩 요청은 부모 로더들(Extension, Bootstrap)로 거슬러 올라가서(위임하여) Bootstrap Loader에 다다른 후 그 밑으로 로딩 요청을 수행한다.
- Bootstrap Class Loader가 A라는 클래스를 찾는 데 실패하면 Extension Class Loader에게 요청을 넘긴다.
- Extension Class Loader가 A라는 클래스를 찾는 데 실패하면 System Class Loader에게 요청을 넘긴다.
  - Bootstrap 또는 Extension Class Loader가 A라는 클래스를 찾았다면 A 클래스 파일 정보를 System Class Loader에게 넘겨준다.
- System Class Loader가 A라는 클래스를 찾았다면 User-defined Class Loader로 넘어가지 않는다.
- System Class Loader가 A라는 클래스를 찾는 데 실패하면 Exception을 발생한다.
3. 가시성 제약 조건(Have Visibility Constraint)
- 클래스 로더 간에는 일종의 '범위 룰'이 적용되어 있다.
- 부모 로더에서 찾지 못한 클래스는 자식 로더를 이용해 클래스를 찾지 못한다.
- 하지만 반대로 자식 로더에서 찾지 못한 클래스는 부모 로더에게 위임해서 클래스를 찾을 수 있다.
4. 언로드 불가(Cannot unload classes)
- 클래스 로더에 의해 JVM에 로딩된 클래스는 다시 JVM 상에서 없앨 수 없다.

### Bootstrap Class Loader(부트스트랩 클래스 로더)
- $JAVA_HOME/jre/lib/rt.jar
- rt.jar에 있는 JVM을 실행시키기 위한 핵심 클래스들을 로딩한다.
- Java 어플리케이션 실행 시 -verbose:class JVM 옵션을 주고 실행시키면 rt.jar에 있는 클래스 파일들이 많이 로딩되는 것을 확인할 수 있다.

### Extension Class Loader(확장 클래스 로더)
- $JAVA_HOME/jre/lib/ext/*.jar
- 자바의 확장클래스들을 로딩하는 역할을 한다.

### System Class Loader(시스템 클래스 로더)
- $CLASSPATH에 설정된 경로를 탐색하여 그 곳에 있는 클래스들을 로딩하는 역할을 한다.
- .java 파일을 컴파일하여 만든 .class 파일을 시스템 클래스 로더가 JVM으로 로딩한다.

[출처](https://engkimbs.tistory.com/606)
