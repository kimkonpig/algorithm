package main.java.M14889;

import java.io.*;
import java.util.StringTokenizer;

public class M14889_02 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        skillSet(0, 0);
        System.out.print(min);
    }

    private static void skillSet(int idx, int count){

        if(count == N/2){
            int sumA = 0;
            int sumB = 0;

            for(int i=0 ; i<N-1 ; i++){
                for(int j=i+1 ; j<N ; j++){
                    if(visited[i] && visited[j]){
                        sumA += map[i][j] + map[j][i];
                    }else if(!visited[i] && !visited[j]){
                        sumB += map[i][j] + map[j][i];
                    }
                }
            }

            int result = Math.abs(sumA - sumB);

            if(result == 0){
                System.out.print(0);
                System.exit(0);
            }

            min = Math.min(min, result);

            return;
        }

        for(int i=idx ; i<N ; i++){
            if(!visited[i]) {
                visited[i] = true;
                skillSet(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
