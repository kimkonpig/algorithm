class Solution {
    public long solution(int n, int[] times) {
        
        //모든 사람이 심사를 받는데 걸리는 시간의 최솟값
        long answer = Long.MAX_VALUE;
        
        long start = 0, end = 0;//최소시간, 최대시간
        
        for(int i=0 ; i<times.length ; i++){
            end = Math.max(times[i], end); //배열값 중 최대값 지정
        }
        
        //최대로 소요될 수 있는 시간(최대값 * 사람 수)
        end *= n;
        
        while(true){
            if(start > end){
                break;
            }
            
            //임의 상한액 지정
            long mid = (start + end) / 2;
            
            //임의 상한액까지 심사할 수 있는 인원수
            long done = 0;
            
            for(int i=0 ; i<times.length ; i++){
                done += mid / times[i];
            }
            
            if(done < n){
            //임의 심사가능 인원수가 주어진 인원수보다 작으면(해당 시간동안 심사 다 못하면)
                start = mid + 1;//심사시간 늘리기
            }else{
            //해당 시간동안 심사 완료가능 시
                if(mid < answer){//시간 남으면 임의 상한액이 최소시간
                    answer = mid;
                }
                end = mid - 1; //타이트한 수를 찾기위해 심사시간 줄이기
            }
        }
        return answer;
    }
}