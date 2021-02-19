## DFS
- Depth First Search; 깊이 우선 탐색
- Stack 또는 재귀함수를 사용하여 구현
- 모든 노드를 방문하고자 할 때 사용
- 그래프 저장 방법에는 크게 3가지가 있음
  - 인접행렬
  - 인접리스트
  - 간선리스트
  

### 인접리스트 기반 DFS 코드

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class DFS {
 
    static ArrayList<Integer>[] a;
    static boolean[] visit;
     
    public static void main(String args[]) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();   //정점의 수
        int m = sc.nextInt();   //간선의 수
        int start = sc.nextInt();//시작할 정점
 
        a = new ArrayList[n+1];     //인덱스 편의상 n+1를 하고, 0번째 요소는 사용하지 않음
        visit = new boolean[n+1];   //인덱스 편의상 n+1를 하고, 0번째 요소는 사용하지 않음
         
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
 
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();   //간선으로 이어진 정점1
            int v = sc.nextInt();   //정점1과 간선으로 이어진 정점2
            //양뱡향일 경우 양쪽다 저장해준다.
            a[u].add(v);
            a[v].add(u);
        }
 
       
        dfs(start);
         
        System.out.println("");
        System.out.println("a : "+Arrays.toString(a)); //각 정점에서 간선으로 연결된 정점 출력
        System.out.println("visit : "+Arrays.toString(visit)); //각 정점의 방문여부 출력
    }
     
     
    public static void dfs(int x) {
    
        visit[x] = true;
        System.out.print(x + " "); //깊이탐색된 순서 출력
         
        for (int y : a[x]) {
            if (visit[y] == false) {
                dfs(y);
            }
        }
    }
}
```

입력값
>5 4 5<br/>
>5 4<br/>
>4 3<br/>
>4 2<br/>
>1 5<br/>

출력값
>5 4 3 2 1<br/>
>a : [null, [5], [4], [4], [5, 3, 2], [4, 1]]<br/>
>visit : [false, true, true, true, true, true]<br/>

- a 변수에는 ArrayList로 각 정점이 간선으로 연결된 정점들의 정보를 갖고 있다.
  - a[1]은 1정점을 나타내고 1정점은 5정점과 간선으로 연결되어 있으므로 a[1]요소의 값은 5를 갖고 있다.
  - a[4]는 4정점을 나타내고 4정점은 3, 2, 5정점과 간선으로 연결되어 있으므로 a[4]요소의 값은 3, 2, 5를 담고 있는 ArrayList가 있다.

- visit 변수는 정점을 탐색했는지 여부에 대한 정보를 갖고 있다.
  - 별도 초기화 하지 않는 이상 모두 false로 초기화된 상태이다.
  - 재귀함수를 사용하기 때문에 스택을 별도로 사용하지 않아도 스택효과를 낼 수 있다.
  - 각 정점 탐색 시 visit[x] = true가 된다.

출처 : [DFS_깊이탐색](https://limkydev.tistory.com/93?category=974585) 
