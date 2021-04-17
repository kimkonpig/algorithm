package main.java.M9184;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M9184 {

    static int[][][] memo = new int[21][21][21]; //20이상이면 w(20, 20, 20)호출하므로 메모이제이션 배열 크기 (0~20)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a, b, c;
            int result;


            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1){
                break;
            }else {
                result = wFunc(a, b, c);
                bw.append("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int wFunc(int a, int b, int c){
        if(rangeCheck(a, b, c) && memo[a][b][c] != 0){
            return memo[a][b][c];
        }

        if(a<=0 || b<=0 || c<=0){
            return 1;
        }else if(a>20 || b>20 || c>20){
            memo[20][20][20] = wFunc(20, 20, 20);
            return memo[20][20][20];
        }else if(a<b && b<c){
            memo[a][b][c] = wFunc(a, b, c-1) + wFunc(a, b-1, c-1) - wFunc(a, b-1, c);
            return memo[a][b][c];
        }

        memo[a][b][c] = wFunc(a-1, b, c) + wFunc(a-1, b-1, c)
                + wFunc(a-1, b, c-1) - wFunc(a-1, b-1, c-1);

        return memo[a][b][c];
    }

    private static boolean rangeCheck(int a, int b, int c){
        return 0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20;
    }
}
