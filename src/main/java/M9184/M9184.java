package main.java.M9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M9184 {

    static int[][][] memo;
    static int sum = 0;
    static int a2 = 0;
    static int b2 = 0;
    static int c2 = 0;

    public static void main(String[] args) throws IOException {
        memo = new int[101][101][101];

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a, b, c;
            int result = 0;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1){
                return;
            }else {
                result = wFunc(a, b, c);
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
            }
        }
    }

    private static int wFunc(int a1, int b1, int c1){
        if(a1<=0 || b1<=0 || c1<=0){
            memo[a1][b1][c1] = 1;
            sum += 1;
        }else if(a1>20 || b1>20 || c1>20){
            if(memo[a1][b1][c1] == 0){
                memo[a1][b1][c1] = wFunc(20, 20, 20);
            }
            sum += memo[a1][b1][c1];
        }else if(a1<b1 && b1<c1){
            b2 = b1-1;
            c2 = c1-1;
            if(memo[a1][b1][c2] == 0) {
                memo[a1][b1][c2] = wFunc(a1, b1, c2);
            }else if(memo[a1][b2][c2] == 0) {
                memo[a1][b2][c2] = wFunc(a1, b2, c2);
            }else if(memo[a1][b2][c1] == 0) {
                memo[a1][b2][c1] = wFunc(a1, b2, c1);
            }
            sum += memo[a1][b1][c2] + memo[a1][b2][c2] + memo[a1][b2][c1];
        }else{
            a2 = a1-1;
            b2 = b1-1;
            c2 = c1-1;
            if(memo[a2][b1][c1] == 0) {
                memo[a2][b1][c1] = wFunc(a2, b1, c1);
            }else if(memo[a2][b2][c1] == 0) {
                memo[a2][b2][c1] = wFunc(a2, b2, c1);
            }else if(memo[a2][b1][c2] == 0) {
                memo[a2][b1][c2] = wFunc(a2, b1, c2);
            }else if(memo[a2][b2][c2] == 0) {
                memo[a2][b2][c2] = wFunc(a2, b2, c2);
            }
            sum += memo[a2][b1][c1] + memo[a2][b2][c1] + memo[a2][b1][c2] - memo[a2][b2][c2];
        }
        return sum;
    }
}
