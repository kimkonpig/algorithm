import java.util.*;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        //이분탐색을 위한 변수
        int start = 0, end = 0;
        
        for(int i=0 ; i<budgets.length ; i++){
            end = Math.max(budgets[i], end);//최대값구하기
        }
        
        //이분탐색 시작
        while(true){
            if(start > end){
                break;
            }
            
            //임의 상한액
            int mid = (start + end) / 2;
            
            //조건 확인
            int tmpSum = 0;
            for(int i=0 ; i<budgets.length ; i++){
                if(budgets[i] > mid){//요청한 예산이 상한액보다 큰 경우, 상한액 배정
                    tmpSum += mid;
                }else{//요청한 예산이 상한액보다 작은 경우, 요청한 예산 배정
                    tmpSum += budgets[i];
                }
            }
            
            if(tmpSum > M){//예상금액이 총 예산보다 큰 경우
                end = mid - 1;
            }else{//예상금액이 총 예산보다 작은 경우
                start = mid + 1;
                answer = Math.max(answer, mid);//정답 업데이트
            }
        }
        return answer;
    }
}
