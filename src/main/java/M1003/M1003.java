package main.java.M1003;

import java.io.*;
import java.util.ArrayList;

public class M1003 {
    static int[] sum;
    static int[] sumA;
    static int[] sumB;

    static ArrayList<int[]> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] fiboArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0 ; i<T ; i++){
            //sum = new int[T];
            int N = Integer.parseInt(br.readLine());
            sumA = new int[N+1];
            sumB = new int[N+1];

            fiboArr = new int[N+1];

            fibonacci(N);
            list.add(sum);
        }

        for(int i=0 ; i<T ; i++){
            bw.write(list.get(i)[0] + " " + list.get(i)[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int fibonacci(int num){
        if(num == 0){
            sum[0]++;
            return 0;
        }else if(num == 1){
            sum[1]++;
            return 1;
        }

        if (fiboArr[num] != 0) {
            return fiboArr[num];
        }else{
            fiboArr[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }

        /*sumA[num] = sumA[num-1] + sumA[num-2];
        sumB[num] = sumB[num-1] + sumB[num-2];*/

        return fiboArr[num];
    }
}
