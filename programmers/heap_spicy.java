import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        /* 우선순위큐 자료구조 사용 */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        /*
            우선순위큐에 스코빌지수 담기
            오름차순 자동 정렬
            -> poll() 할때 작은 value 부터
        */

        for(int i=0 ; i<scoville.length ; i++){
            pq.add(scoville[i]);
        }

        /*
            만약 우선순위를 큰 value 로 정렬하고 싶다면 우선순위큐 선언 시 다음과 같이 Collections 사용
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Collections.reverseOrder()));
        */

        int tmp1, tmp2;

        while(pq.size() > 0){
            tmp1 = pq.poll(); /*가장 맵지 않은 음식의 스코빌 지수*/

            if(tmp1 < K){ /*기준지수랑 비교*/
                if(pq.size() == 0){
             /*큐 원소가 더이상 없으면 = 섞을 음식 없음
               (제한사항4) 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없으므로 -1 반환
             */
                    answer = -1;
                    break;
                }
                tmp2 = pq.poll(); /*두번째로 맵지 않은 음식의 지수*/
                pq.add(tmp1 + (tmp2 * 2));
                answer++;
            }
        }
        return answer;
    }
}