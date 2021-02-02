package M10872;

import java.util.*;

public class M10872{
    public static void main(String args[]){
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        if(num==0){
            System.out.print(1);
        }else{
            System.out.print(fibo(num));
        }
    }

    static int fibo(int num){
        return num==1 ? 1 : num * fibo(num-1);
    }
}