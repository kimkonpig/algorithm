package main.java.M9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class M9461 {

    static long[] padoban = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
        Arrays.fill(padoban, -1);
        padoban[0] = 0;
        padoban[1] = 1;
        padoban[2] = 1;
        padoban[3] = 1;

        for(int i=0 ; i<T ; i++){
            int N = Integer.parseInt(br.readLine()); //파도반 수열 N

            System.out.println(solution(N));
        }
    }

    private static long solution(int N){
        if(padoban[N] == -1){
            padoban[N] = solution(N-3) + solution(N-2);
        }

        return padoban[N];
    }
}
