/*
 * 타겟 넘버를 만들기 위해서는 주어진 숫자의 부호를 +나 -로 정해서 모든 경우의 수를 탐색해봐야 답을 찾을 수 있다.
 * 연산과정을 하나의 트리로 생각했을 때, +연산자를 왼쪽 자식노드로, -연산자를 오른쪽 자식노드로 내려가는 과정을 재귀함수로 표현
 */

class Solution {
    int answer = 0;

    void dfs(int[] numbers, int sum, int target, int idx){
        if(idx==numbers.length){//인덱스가 배열사이즈랑 같아졌을 때
            if(sum==target){//총 합이 타겟넘버와 같으면
                answer++;//방법의 수 +1
            }
            return;
        }

        dfs(numbers, sum+numbers[idx], target, idx+1);//더했을 때 방법의 수 확인
        dfs(numbers, sum-numbers[idx], target, idx+1);//뺐을 때 방법의 수 확인
    }

    public int solution(int[] numbers, int target) {
        int idx=0, sum=0;
        dfs(numbers, sum, target, idx);
        return answer;
    }
}