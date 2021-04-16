# Thread Pool
Java의 Thread Pool 분석 - newFixedThreadPool의 동작 방식

![image](https://user-images.githubusercontent.com/56284234/114986428-f5d8a680-9ece-11eb-9e80-928e1df23082.png)

## Thread Pool 관리
- 자바에서 Thread를 필요한 작업마다 생성하는 것은 자원낭비와 안정성에 문제가 발생할 수 있다. Thread가 많다면 메모리 사용량이 많아지고 JVM의 가비지콜렉터에 많은 부담을 주게 된다.
- 또한 모든 시스템에는 생성할 수 있는 Thread의 개수가 제한되어 있다. 만약 제한된 양을 모두 사용하게 되면 OutOfMemoryError가 발생할 수 있다.

- 이러한 단점을 해소하기 위해 Thread Pool이라는 것을 이용해 Thread를 관리할 수 있다. 자바에서는 java.util.concurrent.Executors에서 스레드풀을 제공하고 있다.
- Executors의 구조는 프로듀서-컨슈머 패턴으로 만들어져 있다. 따라서 Thread가 생성하고 나서 같은 작업을 다시 하는 일이 없다면 Thread가 처리하고 나서 바로 종료 처리해도 되지만,
- 반복적으로 어떤 작업을 어떤 시점에서 해야 한다면 매번 Thread를 생성하고 종료하는 로직보다는 해당 Thread가 계속 대기중인 상태가 되어 작업할 시점이 왔을 때 처리하는 것이 좋다.

- Thread Pool을 사용한다면 매번 Thread를 생성하는 것보다 많은 장점이 있다.
- 즉, 이전의 Thread를 재사용할 수 있으므로 시스템 자원을 줄일 수 있고 작업 요청 시 이미 Thread가 대기중인 상태이기 때문에 작업을 실행하는데 딜레이가 발생하지 않는다.
- Executors에서는 설정에 따른 여러가지 Thread Pool을 제공한다.

## Executors가 제공하는 Thread Pool 설정
### newFixedThreadPool
> 주어진 Thread 개수만큼 Thread를 생성하고 그 수를 유지한다.
> 생성된 Thread 중 일부가 작업시 종료되었다면 Thread를 다시 생성하여 주어진 수를 맞춘다.

### newCachedThreadPool
> 처리할 작업의 Thread가 많아지면 그만큼 Thread를 증가하여 생성한다.
> 만약 작업하지 않는 Thread가 많다면 해당 Thread를 종료시킨다.
> 반면 Thread 개수를 제한두지 않기 때문에 사용 시 주의해야 한다.
 
### newSingleThreadExecutor
> Thread를 단 하나만 생성한다.
> 만약 Thread가 비정상적으로 종료되었다면 다시 하나만 생성한다.
 
### newScheduledThreadPool
> 특정 시간 이후에 실행되거나 주기적으로 작업을 실행할 수 있다.

## 구현방법 1.execute() 메소드
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SimpleThreadPool{
  public static void main(String[] args){
    ExecutorService executor = Executors.newFixedThreadPool(10); //Thread Pool에 Thread 10개 생성
    
    //10번을 반복해서 Thread Pool에 일을 시킨다. (Thread Pool 안에 있는 Thread 하나가 선택되어 일 처리를 하게된다.)
    //execute() 메소드를 사용한다. 이 메소드는 void를 리턴한다. 즉 일처리를 시키기만 하고 결과는 보고 받지 않는다.
    IntStream.range(0, 10).forEach(n -> executor.execute( () -> 
      { // for(int i=0 ; i<10 ; i++) 과 같다.
        try{
          //구현 내용은 300밀리초를 기다렸다가 Hello + thread이름을 출력한다.
          
          TimeUnit.MILLISECONDS.sleep(300);
          String threadName = Thread.currentThread().getName();
          System.out.println("Hello " + threadName);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
      }
    ));
  }
}
```

## 구현방법 2.submit() 메소드
```java
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SimpleThreadPool{
  public static void main(String[] args){
    ExecutorService executor = Executors.newFixedThreadPool(10); //Thread Pool에 Thread 10개 생성
    final List<Integer> integers = Arrays.asList(1,2,3,4,5);
    
    //submit() 메소드는 future를 리턴한다. 즉 일처리를 시키고 그에 따른 결과를 보고받는다.
    //구현내용은 5000밀리초를 기다렸다가 리스트 안의 숫자들의 합을 리턴한다.
    Future<Integer> future = executor.submit( () -> {
      TimeUnit.MILLISECONDS.sleep(5000);
      int result = integers.stream().mapToInt(i -> i.intValue()).sum();
      return result;
    });
    
    try{
      //리턴받은 future 로부터 값을 얻는다. 여기서 get() 메소드는 블럭된다.
      Integer result = future.get();
      System.out.print("result : " + result);
      executor.shutdownNow();
    }catch(InterruptedException e){
      e.printStackTrace();
    }catch(ExecutionException e){
      e.printStackTrace();
    }
  }
}
```
<br/>
<br/>
### 이하 아래 내용은 참고만~~
### 구현상세 - 어떻게 10개의 Thread를 가진 Pool을 만드는가?
> public class Executors {...}<br/>
java/util/concurrent/Executors.java 라는 파일에는 Executors라는 클래스가 있으며,<br/>
정적 메소드로써 newFixedThreadPool이라는 메소드를 제공한다.<br/>
매개변수로는 ThreadPool에 들어갈 Thread의 개수를 넣어준다.<br/>

> public static ExecutorService newFixedThreadPool(int nThreads){<br/>
>   return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());<br/>
> }<br/>
 
퍼사드 역할(Gof의 패턴 중 하나로 내부 시스템의 복잡함을 감추고 사용자가 간편히 사용하도록 하는 의도)을 하고 있다.
그저 팩토리로써 내부의 ThreadPoolExecutor 객체를 대신 만들어준다. 매개변수 설명은 다음과 같다.
- corePoolSize : Pool 안에 유지되는 Thread 개수(시작 시)
- maximumPoolSize : Pool에 유지되는 최대 Thread 개수
- keepAliveTime : corePoolSize보다 Thread 개수가 많아질 때 새로운 Task를 기다리기 위한 시간으로, 이 시간이 지나면 Thread를 종료시켜 corePoolSize를 유지시킨다.
- unit : keepAliveTime 시간 단위
- workQueue : 실행되기 전에 홀드시켜두는 태스크를 유지하는 큐, Thread가 남지 않을 경우 여기에 태스크를 넣는다.

[출처](https://hamait.tistory.com/937)
