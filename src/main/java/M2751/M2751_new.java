package study;

import java.io.*;

//https://www.daleseo.com/sort-merge/
//mergeSort 
public class M2751_new {

	static int[] arr;
	static int[] temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		/* 계속 시간 초과가 나서 merge()메소드에서 메소드 호출 시마다
		 * int[] temp = new int[a.length]로 만들어주던 부분을
		 * static int[] temp로 정적변수로 생성하고 한번만 생성자를 만들어주니
		 * 시간초과가 해결되었다.
		 */
		temp = new int[N];  
		
		for(int i=0 ; i<N ; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, N-1, arr); //start, end index
		
		for(int i : arr){
			sb.append(i + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void mergeSort(int left, int right, int[] a){
		if(left < right){
			int mid = (left+right) / 2;
			
			mergeSort(left, mid, a);
			mergeSort(mid+1, right, a);
			merge(left, right, a);
		}
	}
	
	public static void merge(int left, int right, int[] a){
		int mid = (left + right) / 2;
		int lcur = left;
		int rcur = mid + 1;
		int tcur = left;
		
		while(lcur <= mid && rcur <= right){
			if(a[lcur]<=a[rcur]){
				temp[tcur] = a[lcur];
				tcur++;
				lcur++;
			}else{
				temp[tcur] = a[rcur];
				tcur++;
				rcur++;
			}
		}
		
		if(lcur > mid){
			for(int i=rcur ; i<=right ; i++){
				temp[tcur] = a[i];
				tcur++;
			}
		}else{
			for(int i=lcur ; i<=mid ; i++){
				temp[tcur] = a[i];
				tcur++;
			}
		}
		
		for(int i=left ; i<=right ; i++){
			a[i] = temp[i];
		}
	}
}
