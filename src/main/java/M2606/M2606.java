import java.util.*;

public class M2606 {
	//BFS

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
}
