import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0; //각 문자열의 인덱스(공백이면 0으로 초기화)

        char[] charArray = s.toCharArray();
        for(int i=0 ; i<s.length() ; i++){
            if(charArray[i] == ' '){//공백이면 그대로
                answer += charArray[i];
                index = 0;
            }else if(index%2 == 0 || index==0){//첫번째 인덱스 또는 짝수
                answer += Character.toUpperCase(charArray[i]);
                index++;
            }else{//홀수
                answer += Character.toLowerCase(charArray[i]);
                index++;
            }
        }

        return answer;
    }
}