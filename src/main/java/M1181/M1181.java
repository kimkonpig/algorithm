//Fail !!!

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i=0 ; i<N ; i++){
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()){//단어 길이 같은 경우
					return o1.compareTo(o2); //사전 순 정렬
				}else{ //단어 길이가 짧은 순으로
					//o1의 길이가 길면 순서 바꿈, 그 외 순서 안바꿈
					return o1.length() - o2.length();
				}
			}
		});
		
		for(int i=0 ; i<arr.length-1 ; i++){
			if(!arr[i].equals(arr[i+1])){
				bw.write(arr[i] + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
