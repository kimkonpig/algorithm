package main.java.M15652;

import java.io.*;
import java.util.StringTokenizer;

public class M15652 {

    public static int N;
    public static int M;
    public static int[] rst;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rst = new int[M];

        dfs(0, 1);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int next) throws IOException{
        if(depth == M){
            for(int a : rst){
                bw.write(a + " ");
            }
            bw.append("\n");
            return;
        }

        for(int i=next ; i<=N ; i++){
            rst[depth] = i;
            dfs(depth+1, i);
        }
    }
}
