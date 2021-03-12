package main.java.M10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class M10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //회원 수

        //회원의 나이와 이름이 공백으로 구분
        //가입순으로 입력 데이터 주어짐
        String[][] arr = new String[N][2];

        for(int i=0 ; i<N ; i++){
            arr[i] = br.readLine().split(" ");
        }

      //Comparator Interface 사용
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(String[] result : arr){
            bw.write(result[0] + " " + result[1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
