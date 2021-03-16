package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M9663_02 {

	/*
	 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
	 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
	 * 입력 : 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
	 * 출력 : 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
	 * 예제입력 : 8 / 예제출력 : 92
	 * https://articles09.tistory.com/91
	 */
	
	public static int N;
	public static int count = 0;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		queen(map, 0);
		
		System.out.print(count);
	}

	public static void queen(int[][] map, int line){
		if(line == N){
			count++;
			return;
		}
		for(int i=0 ; i<N ; i++){
			if(valiCheck(map, line, i)){
				map[line][i] = 1;
				queen(map, line+1);
				map[line][i] = 0;
			}
		}
	}
	
	private static boolean valiCheck(int[][] map, int line, int col){
		//0~line행 직선위 체크
		for(int i=line ; i>=0 ; i--){
			if(map[i][col] == 1){
				return false;
			}
		}
		
		//왼쪽 위 대각선
		for(int i=line-1, j=col-1 ; i>=0&&j>=0 ; i--, j--){
			if(map[i][j] == 1){
				return false;
			}
		}
		
		//오른쪽 위 대각선
		for(int i=line-1, j=col+1 ; i>=0&&j<N ; i--, j++){
			if(map[i][j] == 1){
				return false;
			}
		}
		
		return true;
	}
}
