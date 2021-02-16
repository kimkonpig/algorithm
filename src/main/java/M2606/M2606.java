
import java.util.*;

public class M2606 {
	//DFS start
	static ArrayList<Integer>[] a;
	static boolean[] visit;
	static int cnt = 0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int totCnt = sc.nextInt(); //컴퓨터의 수
		int totLine = sc.nextInt(); //간선의 수
		
		a = new ArrayList[totCnt+1];
		visit = new boolean[totCnt+1];
		
		for(int i=1 ; i<totCnt+1 ; i++){
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0 ; i<totLine ; i++){
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			a[num1].add(num2);
			a[num2].add(num1);
		}
		
		dfs(1);
		
		for(boolean i : visit){
			if(i==true) cnt++;
		}
		
		System.out.print(cnt-1); //1번컴퓨터 제외
	}
	
	static void dfs(int x){
		visit[x] = true;
		
		for(int i : a[x]){
			if(visit[i] == false) dfs(i);
		}
	}
	//DFS end
	
	//BFS start
	/*
	static int node[][]; //그래프 배열
	static int visit[]; //방문체크 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totCnt = sc.nextInt(); //컴퓨터의 수
		int totLine = sc.nextInt(); //간선의 수
		
		node = new int[totCnt+1][totCnt+1];
		visit = new int[totCnt+1];
		
		for(int i=0 ; i<totLine ; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		bfs(1); //1번 컴퓨터부터 시작
	}
	
	static void bfs(int num){
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0; //감염된 컴퓨터의 수
		
		visit[num] = 1;
		q.add(num);
		
		while(!q.isEmpty()){
			int x = q.poll();
			
			for(int i=1 ; i<node.length ; i++){
				if(node[x][i] == 1 && visit[i] !=1){
					q.add(i);
					visit[i] = 1;
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}
	*/
	//BFS end
}
