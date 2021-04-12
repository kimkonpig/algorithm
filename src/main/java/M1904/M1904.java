package main.java.M1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M1904 {
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3 ; i<dp.length ; i++){
            dp[i] = -1;
        }
        System.out.print(fibo(N));
    }

    private static int fibo(int num){
        if(dp[num] == -1){
            dp[num] = (fibo(num-1) + fibo(num-2)) % 15746;
        }
        return dp[num];
    }
}

/*
    1 N=1 -> 1
    2 N=2 -> 00, 11
    3 N=3 -> 001, 100, 111
    5 N=4 -> 0011, 1001, 1100, 0000, 1111
    8 N=5 -> 00001, 00100, 10000, 11100, 00111, 11111, 10011, 11001

    피보나치 수열과 동일!
*/
