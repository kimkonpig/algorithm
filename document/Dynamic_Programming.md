## 동적계획법(Dynamic Programming)
큰 문제를 작은 문제로 나누어 풀이하는 방법이다. 모든 작은 문제들은 중복없이 한 번만 풀이된다.<br/>
따라서 정답을 구한 작은 문제들은 그 답을 어딘가에 메모를 해놓는다.<br/>
그보다 큰 문제를 풀어나갈 때 이미 풀이했던 작은 문제가 나타나면 앞서 메모한 작은 문제의 결과값을 이용한다.<br/>
모든 방법을 일일이 검토하여 최적의 해를 찾아내는 방식의 알고리즘이다.<br/>
그리디 알고리즘(탐욕 알고리즘)은 모든 방법(모든 해)을 구하지 않고 순간마다 그 순간에서의 최적의 해를 찾는다.<br/>
따라서 그리디 알고리즘은 항상 최적의 해를 도출한다고 볼 순 없다.<br/>
동적계획법은 그리디 알고리즘에 비해 시간은 오래 걸릴 수 있지만 결과적으로는 항상 최적의 해를 구할 수 있다.

## 메모이제이션(Memoization)
동적계획법에서는 작은 문제들이 반복되고 이 작은 문제들의 결과값이 항상 같다.<br/>
이 점을 이용하여 한 번 계산한 작은 문제(결과값)를 저장해놓고 다시 사용한다.<br/>
이를 메모이제이션(Memoization)이라고 한다.<br/>

피보나치 수열을 예로 들어보면, 피보나치 수열은 1, 1, 2, 3, 5, 8 ... 의 수를 이룬다.<br/>
즉 (다음 수열) = (전 수열) + (전전 수열) 이라는 점화식을 갖게 된다.<br/>
재귀함수로 풀게 되면 간단하게 풀 수 있지만,
구하고자 하는 N이 커짐에 따라 호출하는 함수의 수가 기하급수적으로 증가하기 때문에 일정 수 이상의 순열을 구하기가 어렵다.
또한 피보나치를 재귀함수로 풀게될 경우, 했던 작업을 또 하게 된다. 이 때 동적계획법을 이용하면 중복 작업을 피할 수 있다.<br/>
![image](https://user-images.githubusercontent.com/56284234/111902080-e2c4e900-8a7e-11eb-8c82-5a80dc82110a.png)

### 동적계획법의 조건
1. 작은 문제들이 반복된다.
위 이미지에서 F(5)를 구하기 위해서는 F(4), F(3)이 필요하고 다시 F(4)를 구하기 위해서는 F(3), F(2)가 필요하다.<br/>
이 경우 F(5)와 F(4)에서 모두 F(3)이 필요하다. 즉 작은 문제가 반복되는 구조이다.

2. 같은 문제는 구할때 마다 답이 같다.
피보나치 수열의 경우 첫번째와 두번째 수는 각각 1로 고정되어 있고, 세번째 수는 언제나 결과가 2이다.<br/>
또한 네번째 수는 세번째와 두번째 수를 이용해 구하므로 언제나 같은 답이 나온다.

```java
//재귀함수를 이용한 피보나치 수열(N번째 수 구하기)
int fibo(int N){
  if(N<=2){
    return 1;
  }else{
    return fibo(N-1) + fibo(N-2);
  } 
}
```

### TOP-DOWN
문제 풀이가 위에서 아래로 진행되는 방식이다.<br/>
예를 들어 fibo(6)을 호출하면 fibo(6)부터 작은 수까지 도달하게 되는 방식이다.<br/>

```java
int memo[100] = {0, };

int fibo(int N){
  if(N<=2){
    return 1;
  }
  if(memo[N] == 0){
    memo[N] = fibo(N-1) + fibo(N-2); //메모이제이션
  }
  
  return memo[N];
}
```

### BOTTOM-UP
문제 풀이가 아래에서 위로 진행되는 방식이다.<br/>

```java
int memo[100] = {0, };

int fibo(int N){
  memo[0] = 0;
  memo[1] = 1;
  for(int i=2 ; i<=N ; i++){
    memo[i] = memo[i-1] + memo[i-2];
  }
  
  return memo[N];
}
```