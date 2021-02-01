import java.util.*;

class Solution {
    public int[] solution(int[] heights) {
        int totCnt = heights.length;
        int[] answer = new int[totCnt];

        //stack 생성
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<totCnt ; i++){
            stack.push(heights[i]);
        }

        while(stack.size()>0){
            int pop = stack.pop();

            for(int i=stack.size() ; i>=0 ; i--){
                if(heights[i]>pop){
                    answer[stack.size()] = i+1;
                    break;
                }
            }
        }

        /*
        for(int sendCnt = totCnt-1 ; sendCnt >0 ; sendCnt--){
            for(int recvCnt = 0 ; recvCnt<sendCnt ; recvCnt++){
                if(heights[recvCnt]>heights[sendCnt]){
                    answer[sendCnt] = recvCnt+1;
                }
            }
        }
        */

        return answer;
    }
}