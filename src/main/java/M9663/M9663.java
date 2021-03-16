package main.java.M9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이해 안간다.. 다시 보자...
//http://blog.naver.com/potter777777/221024789385
public class M9663 {
	public static int count = 0; //퀸 개수 체크
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=N ; i++){
			int[] row = new int[N+1];
			
			row[1] = i; //1행 i열에 퀸 위치
			
			//1행 1열, 2열, 3열, 4열,,, 반복하여 퀸 놓을 수 있는 자리 확인
			queen(row, 1);
		}
		
		System.out.print(count);
	}
	
	public static void queen(int[] row, int col){
		if(col == N){//열이 체스판 길이와 같아졌다? -> 1행 끝열까지 자리 확인 완료
			count++; //경우의 수 카운트 증가
		}else{
			for(int i=1 ; i<=N ; i++){//1열부터 N열까지
				row[col+1] = i; // (col+1)행 i열에 퀸 위치하고 vali 체크
				if(valiCheck(row, col+1)){
					queen(row, col+1);
				}
			}
		}
	}
	
	public static boolean valiCheck(int[] row, int col){
		for(int i=1 ; i<col ; i++){
			if(row[i] == row[col]){ //같은 행에 퀸 놓을 수 없으므로 false 리턴
				return false;
			}
			/*
			 * 대각선상에 있는지 확인
			 * 대각선에 놓여있는 경우 기울기는 |1| 임을 이용한다.
			 * |(y2 - y1) / (x2 - x1)| = 1 
			*/
			if(Math.abs(i - col) == Math.abs(row[i] - row[col])){
				return false;
			}
		}
		return true;
	}
}
