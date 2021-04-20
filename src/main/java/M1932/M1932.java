package main.java.M1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][n+1];

        for(int i=1 ; i<=n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1 ; j<=i ; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(triangle, n));
    }

    private static long solution(int[][] triangle, int n){
        long memo[][] = new long[n+1][n+1];
        memo[1][1] = triangle[1][1];

        for(int i=2 ; i<=n ; i++){
            for(int j=1 ; j<=i ; j++){
                memo[i][j] = triangle[i][j] + Math.max(memo[i-1][j-1], memo[i-1][j]);
            }
        }

        long max = 0;
        for(int i=1 ; i<=n ; i++){
            max = Math.max(max, memo[n][i]);
        }

        return max;
    }
}
