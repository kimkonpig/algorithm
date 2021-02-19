package study;

import java.util.*;

public class M2667_BFS {
	
	/*
	 * 1. 2중 for문을 통해 값이 1이고, 방문한 적이 없는 시작 정점을 찾는다.
	 * 2. 찿은 정점을 시작으로 bfs() 재귀 호출해서 아파트 수를 세는 count 변수를 증가시킨다.
	 * 	* bfs() 재귀 호출 조건
	 * 		1) 배열의 범위를 넘지 않는다.
	 * 		2) 상하좌우로 연결되어있다.
	 * 		3) 방문한 적이 없다.
	 * 3. 아파트 수를 다 세면 ArrayList인 result에 넣고, count 변수를 0으로 초기화 시킨다.
	 * 	* result는 각 단지별 아파트 수가 된다.
	 * 	* result.size()는 아파트 단지 총 개수가 된다.
	 */
	
	static int N; //지도의 크기
	static int[][] map; //지도 배열화
	static boolean[][] visit; //방문체크
	static int count = 0; //아파트 수
	
	//result에 각 단지별 아파트 수 저장, result.size()는 아파트 단지 총 개수가 된다.
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	static int[] dx = {-1, 1, 0, 0}; //상하좌우 체크
	static int[] dy = {0, 0, -1, 1}; //상하좌우 체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N]; //지도 초기화
		visit = new boolean[N][N]; //방문체크 초기화
		
		//지도 데이터 셋팅
		for(int i=0 ; i<N ; i++){
			String str = sc.next();
			for(int j=0 ; j<N ; j++){
				map[i][j] = Integer.parseInt(str.substring(j,  j+1));
			}
		}
		
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				if(map[i][j]==1 && !visit[i][j])
					bfs(i, j);
				if(count>0){
					result.add(count);
					count = 0;
				}
			}
		}
		
		System.out.println(result.size());//단지 총 개수 출력
		Collections.sort(result);//오름차순 정렬
		for(int i : result){
			System.out.println(i);
		}
	}
	
	static void bfs(int x, int y){
		Queue<Location> q = new LinkedList<Location>();
		Location loc;
		
		count++;
		visit[x][y] = true; //방문체크
		
		q.add(new Location(x, y));
		
		while(!q.isEmpty()){
			loc = q.poll();
			
			for(int i=0 ; i<4 ; i++){
				int nx = loc.x + dx[i];
				int ny = loc.y + dy[i];
				
				/*
				 * bfs() 재귀 호출 조건
				 *	1) 배열의 범위를 넘지 않는다.
				 *	2) 상하좌우로 연결되어있다.
	  		 	 *	3) 방문한 적이 없다.
				 */
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1 && !visit[nx][ny]){
					bfs(nx, ny);
				}
			}
		}
	}
}

class Location{
	int x, y;
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
}
