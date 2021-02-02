import java.util.*;

class Solution {
    public long solution(long n) {
        //Math.sqrt의 리턴타입은 double
        long answer = 0;

        double sqrt = Math.sqrt(n);
        int intSqrt = (int)sqrt;

        if(sqrt == intSqrt){
            answer = (long)Math.pow(sqrt+1, 2);
        }else{
            answer = -1;
        }

        return answer;
    }
}