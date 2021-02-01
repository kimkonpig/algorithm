import java.util.*;

class Solution {
    public int[] solution(long n) {

        String str = String.valueOf(n);
        char[] charArr = str.toCharArray();
        int[] answer = new int[charArr.length];
        int length = charArr.length;

        for(int i=length-1 ; i>=0 ; i--){
            answer[length-1 - i] = Integer.parseInt(String.valueOf(charArr[i]));
        }

        return answer;
    }
}