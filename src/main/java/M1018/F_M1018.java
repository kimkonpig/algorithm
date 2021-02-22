package M1018;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
* 너무 어렵다!
* F는 Fail의 F다!
*  */
public class F_M1018 {

	//arr1 : 맨 왼쪽 위 칸이 검은색인 체스판
	//arr2 : 맨 왼쪽 위 칸이 하얀색인 체스판
	static String[] arr1 = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};
	static String[] arr2 = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 8 <= N, M <= 50
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		String[] board = new String[N];

		int min = 64; //8*8 체스판에서 색칠해야하는 칸이 가장 많은 경우 = 64칸
		int count = 0;

		for(int i=0 ; i<N ; i++){
			board[i] = br.readLine();
		}

		for(int i=0 ; i<N-7 ; i++){ //8*8 정사각형으로 잘라서 확인해야하므로 N-7, M-7
			for(int j=0 ; j<M-7 ; j++){
				count = compare(board, i, j);
				if(count < min){
					min = count;
				}
			}
		}

		System.out.print(min);
	}

	public static int compare(String[] board, int x, int y){
		int arrNum1 = 0;
		int arrNum2 = 0;

		//가로, 세로가 8인 입력받은 정사각형 칸을 제대로 된 arr1, arr2 체스판과 비교
		for(int i=x ; i<x+8 ; i++){
			for(int j=y ; j<y+8 ; j++){
				if(board[i].charAt(j) != arr1[i-x].charAt(j-y)){
					arrNum1++;
				}
				if(board[i].charAt(j) != arr2[i-x].charAt(j-y)){
					arrNum2++;
				}
			}
		}
		if(arrNum1 > arrNum2){
			return arrNum2;
		}else{
			return arrNum1;
		}
	}

}
