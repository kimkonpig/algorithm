import java.util.*;

//진행중
public class M1012 {

	static int M; //가로길이(1~50)
	static int N; //세로길이(1~50)
	static int K; //배추가 심어져 있는 위치의 개수(1~2500)
	
	static int[][] map; //지도 배열화
	static boolean[][] visit; //방문체크
	
	//result에 각 테스트케이스별 배추흰지렁이 마리 수 저장
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int count; //각 테스트케이스별 배추흰지렁이 카운트
	
	static int[] dx = {-1, 1, 0, 0}; //상하좌우 체크
	static int[] dy = {0, 0, -1, 1}; //상하좌우 체크
	
	static int[] totResult;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 개수
		
		totResult = new int[T];
		
		for(int tc=0 ; tc<T ; tc++){
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[M][N]; //지도 초기화
			visit = new boolean[M][N]; //방문체크 초기화
			
			//방문체크 false 초기화
			for(int i=0 ; i<M ; i++){
				for(int j=0 ; j<N ; j++){
					visit[i][j] = false;
				}
			}
			
			
			//카운트 0 초기화
			count = 0;
			
			//지도 데이터 셋팅
			for(int i=0 ; i<K ; i++){
				int a = sc.nextInt(); //0<= a <=M-1
				int b = sc.nextInt(); //0<= b <=N-1
				
				map[a][b] = 1;
			}

			for(int i=0 ; i<M ; i++){
				for(int j=0 ; j<N ; j++){
					if(map[i][j]==1 && !visit[i][j])
						dfs(i, j);
					if(count>0){
						result.add(count);
						count = 0;
					}
				}
			}
			totResult[tc] = result.size();
		}
		
		for(int i=0 ; i<totResult.length ; i++){
			System.out.println(totResult[i]);
		}
	}
	
	static void dfs(int x, int y){
		visit[x][y] = true;
		count++;
		
		for(int i=0 ; i<4 ; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny]==1 && !visit[nx][ny]){
				dfs(nx, ny);
			}
		}
		
	}
}
