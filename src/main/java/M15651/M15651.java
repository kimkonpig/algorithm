package main.java.M15651;

import java.io.*;
import java.util.StringTokenizer;

public class M15651 {
    public static int N;
    public static int M;
    public static int[] rst;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rst = new int[M];

        dfs(0);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int depth) throws IOException{
        if(depth == M){
            for(int a : rst){
                bw.write(a + " ");
            }
            bw.append("\n");
            return;
        }

        for(int i=0 ; i<N ; i++){
            rst[depth] = i+1;
            dfs(depth+1);
        }
    }
}
