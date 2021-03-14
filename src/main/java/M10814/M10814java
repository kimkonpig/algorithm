package main.java.M10814;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class M10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //회원 수

        //카운팅 정렬 사용


        //나이의 범위 : 1~200
        StringBuilder[] sb = new StringBuilder[201];
        for(int i=0 ; i<sb.length ; i++){
            sb[i] = new StringBuilder();
        }

        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sb[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder rst = new StringBuilder();
        for(StringBuilder p : sb){
            rst.append(p);
        }

        System.out.print(rst);
/*

        //Comparator Interface 사용


        //회원의 나이와 이름이 공백으로 구분
        //가입순으로 입력 데이터 주어짐
        String[][] arr = new String[N][2];

        for(int i=0 ; i<N ; i++){
            arr[i] = br.readLine().split(" ");
        }

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
        bw.close();*/
    }
}
