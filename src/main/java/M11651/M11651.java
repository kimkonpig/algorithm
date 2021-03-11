package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class M11651 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0 ; i<N ; i++){
			String[] tmp = br.readLine().split(" ");
			for(int j=0 ; j<2 ; j++){
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]){ //y좌표 비교하여 같은 값이면 x좌표 비교
					return o1[0] - o2[0];
				}else{
					return o1[1] - o2[1];
				}
			}
		});
		
		for(int[] rst : arr){
			bw.write(rst[0] + " " + rst[1] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
