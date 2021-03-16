package main.java.M2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M2580 {
	
	public static int[][] map = new int[9][9];
	public static int[] isFill = new int[9];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		/* 스도쿠 판 채우기
		 * 값이 0인 경우 빈 칸이다.
		 */
		for(int i=0 ; i<9 ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<9 ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
		br.close();

	}
	
	private static void sudoku(int row, int col){

		//한 행을 다 채웠을 경우 다음 행의 첫 번째 열부터 탐색
		if(col==9){
			sudoku(row+1, 0);
			return;
		}
		
		//행과 열을 모두 탐색하여 채웠을 경우 답 출력 후 시스템 종료
		if(row==9){
			for(int i=0 ; i<9 ; i++){
				for(int j=0 ; j<9 ; j++){
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		//빈 칸이면 1~9까지 입력 가능한 숫자 체크
		if(map[row][col] == 0){
			for(int i=1 ; i<=9 ; i++){
				if(isPossible(row, col, i)){
					//겹치지 않는, 입력 가능한 숫자이면 세팅
					map[row][col] = i;
					sudoku(row, col+1);
				}
			}
		}else{
			sudoku(row, col+1);
		}
		
	}
	
	private static boolean isPossible(int row, int col, int value){
		//같은 행에 겹치는 숫자가 있는지 확인한다.
		for(int i=0 ; i<9 ; i++){
			if(map[row][i] == value){
				return false;
			}
		}
		
		//같은 열에 겹치는 숫자가 있는지 확인한다.
		for(int i=0 ; i<9 ; i++){
			if(map[i][col] == value){
				return false;
			}
		}
		
		//3*3에 겹치는 숫자가 있는지 확인한다.
		int set_row = (row/3)*3;
		int set_col = (col/3)*3;
		for(int i=set_row ; i<set_row+3 ; i++){
			for(int j=set_col ; j<set_col+3 ; j++){
				if(map[i][j] == value){
					return false;
				}
			}
		}
		
		return true;
	}

}
