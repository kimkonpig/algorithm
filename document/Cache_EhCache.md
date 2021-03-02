## EhCache

- 캐시는 반복적으로 데이터를 불러올 때 DB 혹은 서버에 계속 요청하는 것이 아니라 메모리에 데이터를 저장하고 불러다가 쓰는 것을 의미한다. 서버나 DB에 부담을 덜어주고 속도도 빠르다.
- 즉, 반복적으로 동일한 결과를 반환하는 작업 또는 작업의 시간이 오래 걸리거나 서버에 부담을 주는 경우 캐시를 사용할 수 있다.
- 웹 개발 시에 적용할 수 있는 캐시는 브라우저 캐시와 서버단에서의 캐시가 있다.
  - 브라우저 캐시 : 이미 받아온 자원들을 캐시에 저장해둔 후 일정 기간동안 같은 리소스 요청은 캐시에 있는 내용을 반환한다. 서버와의 통신에 따른 비용을 줄일 수 있다.
  - 서버에서의 캐시 : DB 조회 비용을 줄이기 위해 많이 사용한다. 쇼핑몰을 예로 들면, 브라우저를 새로 로드할 때마다 상품 리스트를 보여주는 경우에 서버단에 캐시를 두어 일정 기간동안 들어오는 요청에 한해서는 캐시에 있는 내용을 보여준다.
- Spring에는 JCache, Redis, EhCache 등 여러 캐시 엔진이 있다. 



## EhCache

- EhCache는 Spring의 대표적인 캐시 엔진 중 하나이다.

- 경량의 빠른 캐시 엔진이다.

- 확장성이 있다. 메모리, 디스크에 저장 가능하다.

- 서버 간 분산 캐시를 지원한다. (동기/비동기 복제)

- JSR107 JCache 표준을 지원한다. 따라서 JCache에서 제공하는 Annotation을 통해 작성된 코드에 쉽게 기능을 추가할 수 있다.(PSA)

  > JSR-107 : (JCACHE - Java Temporary Caching API) 객체 생성, 공유 액세스, 스풀링, 무효화 및 JVM 전반에 걸친 일관성을 포함하여 Java 객체의 메모리 캐싱에서 사용할 API에 대한 기준으로 볼 수 있다. 해당 Spec으로 구현된 캐시로는 EhCache가 유명하며, Hazelcase, Infinispan, Couchbase, Redis, Caffeine 등도 해당 기준을 따르는 것으로 알려져 있다.

  > PSA(Portable Service Abstraction) : 성격이 비슷한 여러 종류의 기술을 추상화하고 이를 동일한 사용법으로 사용할 수 있도록 지원해주는 것. Spring에서는 서비스 추상화를 위해 다양한 어댑터를 제공한다. 즉 다양한 기술에 대한 API를 제공한다.
  >
  > Cache는 Redis, EhCache, ConcurrentMap 등을 CacheManager 인터페이스로 추상화하고 있다. CacheManager 인터페이스를 이용하여 또 다른 Cache 라이브러리를 사용할 수 있다.

- Spring-boot는 각 Cache API들의 기술 및 변화에 관계없이 일관된 사용을 위한 추상화 인터페이스(CacheManager)를 지원한다.

- Spring-boot에서는 기본적으로 여러 서드파티 Cache 라이브러리를 지원한다. 다양한 Cache를 지원하므로 알맞은 Cache를 골라 사용하면 된다.



### EhCache 설정

#### 1. Maven Dependency 설정

#### 2. ehcache.xml 작성(EhCache 설정 파일)

#### 3. @EnableCaching 작성

#### 4. @Cacheable(value="name") 작성

---

#### 1. Maven Dependency 설정

```xml
<!--Cache-->
<dependency>
    <groupId>net.sf.ehcache</groupId>
    <artifactId>ehcache</artifactId>
    <version>2.9.0</version>
</dependency>
```



#### 2. ehcache.xml 작성

ehcache.xml은 EhCache 설정 파일이다. \<defaultCache\> 태그를 반드시 작성해야한다고 하는데, 일단 내가 작성한 파일 기준으로 설명을 덧붙이겠다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
         updateCheck="false">
    
    <diskStore path="java.io.tmpdir"/>
    
    <cache name="findByCodeAndType"
           maxEntriesLocalHeap="9000"
           maxEntriesLocalDisk="10000"
           eternal="false"
           diskSpoolBufferSizeMB="20"
           timeToIdleSeconds="300" timeToLiveSeconds="600"
           memoryStoreEvictionPolicy="LFU"
           transactionalMode="off">
        <persistence strategy="localTempSwap" />
    </cache>

</ehcache>
```

- **\<diskStore path="java.io.tmpdir"/>**
  - 임시 저장 경로를 설정한다.
- **maxEntriesLocalHeap** (default = 0)
  - 메모리에 생성될 캐시의 최대 개수를 설정한다.
- **maxEntriesLocalDisk** (default = 0)
  - 디스크에 생성될 캐시의 최대 개수를 설정한다.
- **name**
  - 캐시의 이름을 설정한다.
  - java단에서 내가 캐시하고 싶은 메소드에 findByCodeAndType를 지정하면 해당 메소드에 캐시 설정이 적용된다.
- **eternal** (default = false)
  - 영속성 캐시 여부를 설정한다.
  - "true"이면 timeout 관련 설정 무시하고 캐시가 삭제되지 않는다.
- **timeToIdleSeconds** (default = 0)
  - element가 지정한 시간동안 사용(조회)되지 않으면 캐시에서 제거된다.
  - 0으로 지정하는 경우 조회 관련 만료 시간을 지정하지 않는다.
- **timeToLiveSeconds** (default = 0)
  - element가 존재하는 시간을 지정한다. 지정한 시간을 지나면 캐시에서 제거된다. 
  - 0으로 지정하는 경우 만료 시간을 지정하지 않는다.
- **memoryStoreEvictionPolicy** (default = LRU)
  - 객체의 개수가 maxElementsInMemory에 도달했을 때,
    메모리에서 객체를 어떻게 제거할 지에 대한 정책을 지정한다.
  - 기본값은 LRU이며 FIFO와 LFU도 지정할 수 있다.
    - LRU : 가장 오랫동안 호출되지 않은 캐시를 삭제한다.
    - LFU : 호출 빈도가 가장 적은 캐시를 삭제한다.
    - FIFO : 캐시가 생성된 순서대로 가장 오래된 캐시를 삭제한다.
- **transactionalMode**
  - copyOnRead, copyOnWrite 시 트랜잭션 모드를 설정한다.
  - copyOnRead, Write는 캐시로 받아온 객체에 수정이 일어나는 경우 사용한다.
    - copyOnRead : 읽기 시 캐시 요소를 복사할 지 여부
    - copyOnWrite : 쓰기 시 캐시 요소를 복사할 지 여부
- **\<persistence/>**
  - 캐시 영속성 구현 시 설정하는 태그로
  - EhCache에는 빠른 재시작과 캐시 영속성을 위한 옵션을 제공하는 RestartStore가 있다.
    RestartStore는 In-Memory Cache의 On Disk Mirror를 구현한다.
    재시작 시 캐시에 마지막으로 남아있던 데이터가 자동으로 RestartStore의 디스크에 로드된다.
    로드된 데이터를 캐시해서 사용할 수 있다.
  - strategy 옵션(default = none)
    - localRestartable : RestartStore를 활성화하고 모든 캐시 항목을 디스크에 복사한다. ([BigMemory Go](https://documentation.softwareag.com/onlinehelp/Rohan/terracotta_435/bigmemory-go/webhelp/index.html#page/bigmemory-go-webhelp%2Fco-over_what_is_bigmem_go.html%23)에서만 사용할 수 있다.)
    - distributed : [BigMemory Max](https://documentation.softwareag.com/onlinehelp/Rohan/terracotta_438/bigmemory-max/webhelp/index.html#page/bigmemory-max-webhelp/co-over_what_is_bigmem_max.html)에서만 사용할 수 있다.
    - localTempSwap : 임시 로컬 디스크 사용을 활성화한다. 재시작 시 디스크에서 캐시 데이터가 지워진다.
    - none : 캐시 항목을 디스크로 off-load 하지 않는다. none 옵션 사용 시 모든 캐시가 메모리에 보관된다. 
  - synchronousWrites 옵션



#### 3. @EnableCaching 작성

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```

- @EnableCaching 어노테이션을 작성하여 캐시 기능을 사용하겠다고 선언한다.



#### 4. @Cacheable(value="name") 작성

```java
@Cacheable(value="findByCodeAndType")
@Transactional
public TestDto findByCodeAndType(String code, String type){
    TestEntity testEntity = testRepository.findByCodeAndType(code, type);
    TestDto testDto = new TestDto();

    if(testEntity != null) {
        testDto.setPartCnclYn(testDto.getPartCnclYn());
    }

    return testDto;
}
```

- @Cacheable(value="findByCodeAndType")
  - ehcache.xml에서 지정한 findByCodeAndType 캐시를 사용하겠다는 의미이다.
  - 캐시는 기본적으로 key-value 구조로 되어있는데, key값을 지정하지 않는 경우 다음과 같은 알고리즘으로 구현된 KeyGenerator에 의해서 key값을 만들어준다.
    - 파라미터가 없을 경우 : SimpleKey.EMPTY
    - 파라미터가 하나인 경우 : 인스턴스 리턴
    - 파라미터가 하나 이상인 경우 : 모든 파라미터를 포함한 SimpleKey 리턴



#### Cache 사용하는 메소드에서 수행시간 측정

```java
@RestController
public class TestController{
    //...
    
    long start = System.currentTimeMillis(); //수행시간 측정(start)
    TestDto codeDto = codeCacheService.findByCodeAndType(codeDto.getCode(), resDto.getType());
    long end = System.currentTimeMillis(); //수행시간 측정(end)
    
    logger.info("수행시간 : " + Long.toString(end - start));
    //...
}
```

첫번째 수행 시 -<img src="/Users/konpig/Desktop/스크린샷 2021-03-02 오후 9.51.30.png" alt="스크린샷 2021-03-02 오후 9.51.30" style="zoom:50%;" />

두번째 수행 시 - <img src="/Users/konpig/Desktop/스크린샷 2021-03-02 오후 9.51.41.png" alt="스크린샷 2021-03-02 오후 9.51.41" style="zoom:50%;" />



[참고1](https://serverwizard.tistory.com/54) [참고2](https://jaehun2841.github.io/2018/11/07/2018-10-03-spring-ehcache/#ehcache) [참고3](https://jaehun2841.github.io/2018/11/07/2018-11-04-ehcache-config-for-springboot/#ehcachexml-%EC%9E%91%EC%84%B1-ehcache-%EC%84%A4%EC%A0%95%ED%8C%8C%EC%9D%BC) [참고4](https://jojoldu.tistory.com/57) [참고5](http://egloos.zum.com/js7309/v/11143838) [참고6](https://www.ehcache.org/documentation/2.7/configuration/fast-restart.html) [참고7](https://jeong-pro.tistory.com/170)

