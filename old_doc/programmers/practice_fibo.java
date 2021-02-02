import java.util.*;

class Solution {
    int[] dp = new int[100001];

    public int solution(int n) {
        return fibo(n);
    }

    int fibo(int i){
        if(i<=2){
            dp[i] = 1;
        }
        if(dp[i] == 0){
            dp[i] = fibo(i-1) + fibo(i-2);
        }
        return dp[i] % 1234567;
    }
}