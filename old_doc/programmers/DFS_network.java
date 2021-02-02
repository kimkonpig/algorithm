class Solution {
    boolean[] check;
    int answer = 0;

    void dfs(int[][] computers, int n, int i){
        check[i] = true;
        for(int k=0 ; k<computers.length ; k++){
            if(i!=k && check[k]==false && computers[i][k]==1){
                //self노드 아니고, 방문한적없고, 연결된 네트워크일때 탐색
                dfs(computers, n, k);
            }
        }
    }

    public int solution(int n, int[][] computers) {

        check = new boolean[computers.length];  //각 노드 방문 체크

        for(int i=0 ; i<computers.length ; i++){
            if(check[i]==false){
                //방문한적없는 노드일때
                dfs(computers, n, i);
                answer++;
            }
        }

        return answer;
    }
}