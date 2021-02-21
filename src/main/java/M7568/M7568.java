package M7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class M7568 {

    //브루트 포스
     public static void main(String[] args) throws IOException {

         //입력 시 Scanner보다 빠르다.
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //전체 사람의 수
        int[][] info = new int[N][2];

        String[] str;
        for(int i=0 ; i<N ; i++){
            str = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(str[0]);
            info[i][1] =Integer.parseInt(str[1]);
        }

        for(int i=0 ; i<N ; i++){
            int rank = 1;

            for(int j=0 ; j<N ; j++){
                if(i!=j){
                    if(info[i][0]<info[j][0] && info[i][1]<info[j][1]){
                        rank++;
                    }
                }
            }
            System.out.print(rank + " ");
        }
    }
}
