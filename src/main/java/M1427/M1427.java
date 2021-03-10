package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class M1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		Integer[] arr = new Integer[N.length()];
		for(int i=0 ; i<N.length() ; i++){
			arr[i] = Integer.parseInt(N.substring(i, i+1));
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i : arr){
			System.out.print(i);
		}
	}
}
