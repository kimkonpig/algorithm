package main.java.M15649;

import java.io.*;
import java.util.StringTokenizer;

//백트래킹 : 어떤 노드의 유망성을 판단한 뒤, 해당 노드가 유망하지 않다면 부모 노드로 돌아가
//다른 자식 노드를 찾는 방법이다.
//즉, 모든 경우의 수를 찾아보지만, 그 중에서도 가능성 있는 경우의 수만 찾아보는 방법이다.
public class M15649 {

    public static boolean[] visited;
    public static int[] rst;
    public static int N;
    public static int M;

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //백트래킹의 방법 중 하나인 DFS 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //1<=M<=N<=8
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        rst = new int[M];

        dfs(0);
        br.close();
        bw.close();

    }

    public static void dfs(int depth) throws IOException{
        if(depth == M){
            //결과 출력
            for(int a : rst){
                bw.write(a + " ");
            }

            bw.append("\n");
            bw.flush();
            return;
        }

        for(int i=0 ; i<N ; i++){
            if(!visited[i]){
                visited[i] = true;
                rst[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
