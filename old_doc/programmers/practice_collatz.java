class Solution {
    public int solution(int num) {
        int answer = 0;
        long num2 = (long)num;

        while(num2 != 1 && answer < 500){
            num2 = (num2%2==0) ? num2/2 : num2*3+1;
            answer++;

            if(num2 == 1) break;
        }

        return (answer==500 && num2!=1) ? -1 : answer;
    }
}