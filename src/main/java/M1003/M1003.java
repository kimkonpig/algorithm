package main.java.M1003;

import java.io.*;
import java.util.ArrayList;

//https://fbtmdwhd33.tistory.com/45
public class M1003 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] fiboArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0 ; i<T ; i++){
            int N = Integer.parseInt(br.readLine());
            fiboArr = new int[41];
            int[][] dp = new int[41][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            //fibonacci(N);

            for(int j=2 ; j<=N ; j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }

            System.out.println(dp[N][0] + " " + dp[N][1]);

        }

        bw.flush();
        bw.close();
        br.close();
    }

    /*private static int fibonacci(int num){
        if(num == 0){
            return 0;
        }else if(num == 1){
            return 1;
        }

        if (fiboArr[num] != 0) {
            return fiboArr[num];
        }else{
            fiboArr[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }

        return fiboArr[num];
    }*/
}
