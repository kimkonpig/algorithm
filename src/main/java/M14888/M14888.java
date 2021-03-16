package main.java.M14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M14888 {

    static int N;
    static int[] arr;
    static int[] op = new int[4]; //연산자
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N]; //수열

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<4 ; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        operate(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void operate(int opNum, int opIndex){

        if(opIndex == N){
            min = Math.min(min, opNum);
            max = Math.max(max, opNum);
            return;
        }

        for(int i=0 ; i<4 ; i++){
            if(op[i] > 0){ //연산자 개수가 1 이상인 경우

                op[i]--; //연산자 개수 1 감소 시킨다.

                switch (i){
                    case 0: operate(opNum + arr[opIndex], opIndex + 1); break;
                    case 1: operate(opNum - arr[opIndex], opIndex + 1); break;
                    case 2: operate(opNum * arr[opIndex], opIndex + 1); break;
                    case 3: operate(opNum / arr[opIndex], opIndex + 1); break;
                }

                op[i]++; //연산자 개수 복귀 시킨다.
            }
        }
    }
}
