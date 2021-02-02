class Solution {
    public boolean solution(int x) {
        char[] charArr = String.valueOf(x).toCharArray();

        int sum = 0, tmp = x;
        for(int i=0 ; i<charArr.length ; i++){
            sum += tmp%10;
            tmp = tmp/10;
        }

        return (x%sum==0) ? true : false;
    }
}