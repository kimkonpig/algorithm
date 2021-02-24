package study;

import java.io.*;
import java.util.Arrays;

//https://www.daleseo.com/sort-merge/
//mergeSort 
public class M2751 {

	static int[] sorted;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0 ; i<N ; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sorted = new int[N];
		mergeSort(0, N-1);
		for(int i : sorted){
			System.out.println(i);
		}
	}
	
	static void mergeSort(int start, int end){
		if(start < end){
			int mid = (start+end) / 2;
			mergeSort(0, mid);
			mergeSort(mid+1, end);
			
			int p = start;
			int q = mid+1;
			int idx = p;
			
			while(p<=mid || q<=end){
				if(q>end || (p<=mid && arr[p]<arr[q])){
					sorted[idx] = arr[p];
					p++;
					idx++;
				}else{
					sorted[idx] = arr[q];
					q++;
					idx++;
				}
			}
			
			for(int i=start ; i<=end ; i++){
				arr[i] = sorted[i];
			}
		}
	}
}
