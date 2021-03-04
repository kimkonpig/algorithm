## SpringBoot
###  1. JUnit 테스트 시 사용하는 annotation을 정리해보았다.
 
#### @SpringBootTest
- 통합테스트를 제공하는 기본적인 SpringBoot Test annotation이다.
- Application이 실행될 때 설정을 임의로 바꾸어 테스트를 진행할 수 있다.
- 여러 단위 테스트를 하나의 통합된 테스트로 수행할 때 적합하다.
- @SpringBootTest annotation을 사용하면 실제 구동되는 Application과 동일하게 Application Context를 로드하여 테스트한다.
- @Configuration annotation을 사용하는 클래스가 있다면 클래스 내부에서 @Bean annotation을 통해 생성되는 Bean도 모두 등록 가능하다.
- Application의 규모가 클수록 테스트 속도가 느려진다.
- Test Scope Dependencies(자동으로 갖는 의존성)
  - Junit
  - Spring Test & Spring Boot Test
  - AssertJ
  - Hamcrest
  - Mockito
  - JSONassert
  - JsonPath
- 속성
  - properties : {key=value} 형식으로 프로퍼티를 추가할 수 있다.
  - classes : Application Context에 로드할 클래스를 지정한다. 따로 지정하지 않으면 @SpringBootConfiguration을 찾아 로드한다.
  - webEnvironment : Application이 실행될 때의 웹 환경을 설정할 수 있다.
                     기본값은 @SpringBootTest.WebEnvironment.MOCK이다.
                     WebEnvironment.MOCK 설정 시 - 실제 서블릿 컨테이너를 띄우지 않고, 서블릿 컨테이너를 mocking한 것이 실행된다.
                                                 - 서버 입장에서 구현한 API를 통해 비즈니스 로직이 문제없이 수행되는지 테스트한다.(@MockMvc)
                     WebEnvironment.RANDOM_PORT 설정 시 - SpringBoot의 내장 서버를 랜덤 포트로 띄운다. 실제 서블릿 컨테이너를 띄운다.
                                                        - 클라이언트 입장에서 RestTemplate을 사용하듯이 테스트한다.(@TestRestTemplate)
  - ex) 
        @SpringBootTest(
          propertiex = {
            "property.value=propertyTest",
            "value=test"
          },
           classes = {AppConfig.class},
           webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        )

#### @RunWith(SpringRunner.class)
- @RunWith annotation 사용 시 JUnit에 내장된 Runner를 사용하는 대신 annotation에 정의된 Runner 클래스를 사용한다.
- @SpringBootTest annotation 사용하려면 JUnit의 SpringJUnit4ClassRunner 클래스를 상속받는 @RunWith(SpringRunner.class)를 꼭 붙여서 사용해야 정상 동작한다.

#### @ContextConfiguration(classes = AppConfig.class)
- 자동으로 만들어줄 Application Context의 설정 파일 위치를 지정한다.
- classes 옵션으로 .class파일을 지정하거나 locations 옵션으로 .xml 파일을 지정할 수 있다.
- @Autowired가 붙은 인스턴스 변수가 있으면 테스트 Context는 변수 타입과 일치하는 Bean을 탐색한다.
- 만약 @Autowired가 TestController testController; 변수에 붙어있다면 AppConfig.java내에 구현되어 있는 @Bean TestController를 찾아 인스턴스 변수에 주입한다.

#### @FixMethodOrder(MethodSorters.NAME_ASCENDING)

#### @WebAppConfiguration

#### @AutoConfigureMockMvc

#### @TestPropertySource("classpath:application.yml")

#### @Sql({"classpath:schema.sql", "classpath:data.sql"})

#### @Rollback(false)

#### @Transactional
- 테스트에서 @Transactional annotation을 사용하면 테스트가 종료된 후 수정된 데이터가 롤백된다.
- WebEnvironment.RANDOM_PORT / DEFINED_PORT를 사용하면 실제 테스트 서버는 별도의 스레드에서 테스트를 수행하므로 트랜잭션이 롤백되지 않는다.


[참고1](https://cheese10yun.github.io/spring-boot-test/)
[참고2](https://lalwr.blogspot.com/2019/09/spring-test.html)
