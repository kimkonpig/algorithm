package main.java.M14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M14888_02 {

    static int N;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        op = new int[4];
        for(int i=0 ; i<4 ; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        operate(arr[0], 1);
        System.out.print(max + "\n" + min);
    }

    private static void operate(int num, int idx){
        if(idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0 ; i<4 ; i++){
            if(op[i] > 0){
                op[i]--;
                switch(i){
                    case 0: operate(num + arr[idx], idx+1); break;
                    case 1: operate(num - arr[idx], idx+1); break;
                    case 2: operate(num * arr[idx], idx+1); break;
                    case 3: operate(num / arr[idx], idx+1); break;
                }
                op[i]++;
            }
        }

    }
}
