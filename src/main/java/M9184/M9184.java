package main.java.M9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M9184 {

    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        memo = new int[101][101][101];

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a, b, c;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1){
                return;
            }else
                wFunc(a, b, c);
        }
    }

    private static int wFunc(int a1, int b1, int c1){
        if(a1<=0 || b1<=0 || c1<=0){
            memo[a1][b1][c1] = 1;
        }else if(a1>20 || b1>20 || c1>20){
            memo[20][20][20] = wFunc(20, 20, 20);
        }else if(a1<b1 && b1<c1){
            memo[a1][b1][c1-1] = wFunc(a1, b1, c1 - 1);
            memo[a1][b1-1][c1-1] = wFunc(a1, b1 - 1, c1 - 1);
            memo[a1][b1-1][c1] = wFunc(a1, b1 - 1, c1);
        }else{
            //w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)


        }
    }
}
