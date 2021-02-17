import java.util.*;

public class M1260 {
	
	static StringBuilder dfsRst = new StringBuilder();
	static StringBuilder bfsRst = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer>[] a; //인접리스트로 구현
		boolean[] visit; //방문정점 체크
		
		int N = sc.nextInt(); //정점의 개수
		int M = sc.nextInt(); //간선의 개수
		int V = sc.nextInt(); // 탐색 시작 정점
		
		a = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=1 ; i<N+1 ; i++){
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0 ; i<M ; i++){
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			//양방향 간선
			a[num1].add(num2);
			a[num2].add(num1);
		}
		
		for(int i=1 ; i<N+1 ; i++){
			Collections.sort(a[i]);
		}
		
		dfs(V, visit, a);
		System.out.println(dfsRst.toString().trim());
		
		Arrays.fill(visit, false);
		
		bfs(V, visit, a);
		System.out.println(bfsRst.toString().trim());
		
	}
	
	static void dfs(int v, boolean[] visit, ArrayList<Integer>[] a){
		visit[v] = true; //방문정점 체크
		dfsRst.append(v + " ");
		
		for(int i : a[v]){
			if(visit[i]==false)
				dfs(i, visit, a);
		}
	}
	
	static void bfs(int v, boolean[] visit, ArrayList<Integer>[] a){
		Queue<Integer> q = new LinkedList<Integer>();
		
		visit[v] = true; //방문정점 체크
		
		q.add(v); //시작 정점 큐에 삽입
		
		while(!q.isEmpty()){
			int x = q.poll();
			bfsRst.append(x + " ");
			
			for(int i=0 ; i<a[x].size() ; i++){
				if(visit[a[x].get(i)]==false){
					q.add(a[x].get(i));
					visit[a[x].get(i)] = true;
				}
			}
		}
	}
}
