package M2798;

import java.io.*;
import java.util.Arrays;

public class M2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = new int[N];
        str = br.readLine().split(" ");
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int result = 0;

        //인자의 범위를 잘 설정해야 한다.
        //3개의 카드를 선택하기 때문에 첫번째 카드는 N-2 까지 탐색
        for(int i=0 ; i<N-2 ; i++){
            //두번째 카드는 첫번째 카드 다음부터 N-1 까지 탐색
            for(int j=i+1 ; j<N-1 ; j++){
                //세번째 카드는 두번째 카드 다음부터 N 까지 탐색
                for(int k=j+1 ; k<N ; k++){
                    int tmpSum = arr[i] + arr[j] + arr[k];

                    if(tmpSum == M){
                        result = tmpSum;
                        break;
                    }
                    if(tmpSum < M && tmpSum > result){
                        result = tmpSum;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
