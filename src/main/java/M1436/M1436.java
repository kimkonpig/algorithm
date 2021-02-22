package M1436;

import java.io.*;

public class M1436 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.print(num);
    }
}
