package study;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//진행중
public class M1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 8 <= N, M <= 50
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		String[][] str = new String[N+1][M+1];
		for(int i=1 ; i<N+1 ; i++){
			String board = br.readLine();
			for(int j=1 ; j<M+1 ; j++){
				str[i][j] = board.substring(j-1, j);
			}
		}
		
		int result = 0; //다시 칠해야 하는 정사각형 개수의 최솟값
		
		int px = 1;
		int py = 1;

		while(N+1 - px > 7 && M+1 - py > 7){
			int tmp = 0;
			//System.out.println(str[px][py]);
			for(int i=1 ; i<N ; i++){
				for(int j=1 ; j<M-1 ; j++){
					//System.out.println(str[i][j] + " " + str[i][j+1]);
					if(str[i][j].equals(str[i][j+1]) && str[i][j+1].equals(str[i][j+2]) ){
						tmp++;
						//System.out.println(">>>> " + tmp);
					}
				}
			}
			
			al.add(tmp);
			
			px++;
			py++;
		}
		
		Collections.sort(al);
		System.out.print(al.get(0));
		
	}

}
