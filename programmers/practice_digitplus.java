import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int length = Integer.toString(n).length();

        for(int i=0 ; i<length ; i++){
            int target = n % 10;
            n = n / 10;
            answer += target;
        }
        return answer;
    }
}