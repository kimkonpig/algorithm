class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = (arr1[i] | arr2[i]); //OR연산
        }

        String[] answer = new String[n];
        int cnt;

        for(int i=0 ; i<n ; i++){
            answer[i] = ""; //초기화
            cnt = 0;

            while(arr[i] != 0){//2로 나눈 몫
                answer[i] = (arr[i]%2==0 ? " " : "#") + answer[i];  //정답배열 0=" ", 1="#" 치환
                arr[i] = arr[i] / 2;
                cnt++;
            }

            while(cnt<n){
                answer[i] = " " + answer[i];
                cnt++;
            }
        }

        return answer;
    }
}