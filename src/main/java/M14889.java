package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M14889 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        skillset(0, 0);
        System.out.print(MIN);
    }

    private static void skillset(int idx, int count){
        //팀 조합이 완성되면 탐색을 끝낸다.
        if(count == N/2){
            int sumA = 0;
            int sumB = 0;

            for(int i=0 ; i<N-1 ; i++){
                for(int j=i+1 ; j<N ; j++){
                    //teamA 능력치 합 구하기
                    if(visited[i] && visited[j]){
                        sumA += map[i][j] + map[j][i]; // +=로 안쓰고 =로 써서 계속 실패했다.
                    }
                    //teamB 능력치 합 구하기
                    else if(!visited[i] && !visited[j]){
                        sumB += map[i][j] + map[j][i];
                    }
                }
            }

            int result = Math.abs(sumA - sumB);

            if(result == 0){
                System.out.print(result);
                System.exit(0);
            }

            MIN = Math.min(MIN, result);
            return;
        }

        //팀 조합을 찾는다.
        for(int i=idx ; i<N ; i++){
            //if(!visited[i]){
                visited[i] = true;
                skillset(idx + 1, count + 1);
                visited[i] = false;
            //}
        }
    }
}
