package M2178;

import java.util.*;

public class M2178 {

    //BFS 최단경로 찾기
    static int[][] maze; //미로
    static boolean[][] visit; //방문체크
    static int N, M; //미로 크기

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        visit = new boolean[N][M];

        //미로 셋팅
        for(int i=0 ; i<N ; i++){
            String str = sc.next();
            for(int j=0 ; j<M ; j++){
                maze[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        bfs(0, 0);
        System.out.println(maze[N-1][M-1]);
    }

    static int bfs(int x, int y){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(x, y));

        visit[x][y] = true;

        int[] dx = {-1, 1, 0, 0}; //인접체크
        int[] dy = {0, 0, -1, 1}; //인접체크

        while(!queue.isEmpty()){
            Location loc = queue.poll();

            int a = loc.x;
            int b = loc.y;

            for(int i=0 ; i<4 ; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && maze[nx][ny]==1 && !visit[nx][ny]){
                    queue.add(new Location(nx, ny));
                    //System.out.println(nx + " " + ny + " " + maze[nx][ny]);
                    visit[nx][ny] = true;

                    maze[nx][ny] = maze[a][b]+1; //이 부분이 어려웠다.
                }
            }
        }

        return 0;
    }
}

class Location{
    int x, y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
