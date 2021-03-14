package main.java.M15650;

import java.io.*;
import java.util.StringTokenizer;

public class M15650 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int[] rst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rst = new int[M];

        dfs(0, 1);

        br.close();

    }

    /*
        >> 고른 수열은 오름차순이어야 한다.
        재귀dfs호출 시 오름차순으로 탐색하기 위해 next를 1 증가시킨 2를 인자로 넘겨주면서
        다음 재귀 반복문이 2부터 시작하도록 한다.
        중복체크를 위한 visited 배열을 만들 필요 없다.
     */
    public static void dfs(int depth, int next) throws IOException{
        if(depth == M) {
            for (int a : rst) {
                bw.write(a + " ");
            }
            bw.append("\n");
            bw.flush();
            return;
        }

        for(int i=next ; i<=N ; i++){
            rst[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}
