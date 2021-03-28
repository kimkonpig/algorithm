package main.java.M1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1149 {

    static int[][] map = new int[1001][3];
    static int[][] sum = new int[1001][3]; //누적합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //집의 수

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        sum[0][0] = map[0][0];
        sum[0][1] = map[0][1];
        sum[0][2] = map[0][2];

        System.out.print(Math.min(Math.min(dp(N-1, 0), dp(N-1, 1)), dp(N-1, 2)));
    }

    private static int dp(int N, int color){
        if(sum[N][color] == 0){
            if(color == 0){//red
                sum[N][0] = map[N][0] + Math.min(dp(N-1, 1), dp(N-1, 2));
            }else if(color == 1){//green
                sum[N][1] = map[N][1] + Math.min(dp(N-1, 0), dp(N-1, 2));
            }else if(color == 2){//blue
                sum[N][2] = map[N][2] + Math.min(dp(N-1, 0), dp(N-1, 1));
            }
        }

        return sum[N][color];
    }
}
