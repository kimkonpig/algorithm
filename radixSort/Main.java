//Please don't change class name 'Main'
import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cnt = br.readLine();
		int intCnt = Integer.parseInt(cnt); //cnt를 int형으로 받기
			
		String arr = br.readLine();
		String[] strArr = arr.split(" ");
		int[] intArr = new int[intCnt];


		for(int i=0 ; i<intCnt ; i++){
			intArr[i] = Integer.parseInt(strArr[i]); //input할 arr 완성
		}
		
		intArr = sort(intArr);	//배열 중 가장 큰 자리수 찾아서 radixsort 실행
		
		String result = "";
		for(int i=0 ; i<intArr.length ; i++){
			if(i==intArr.length-1){
				result += intArr[i];
			}else{
				result += intArr[i] + " ";
			}
		}
		System.out.println(result);
  }
	
	private static int[] sort(int[] intArr){
		int max = intArr[0];
		for(int i=1 ; i<intArr.length ; i++){	//배열 중 가장 큰 수 찾기
			if(max<intArr[i]){
				max = intArr[i];
			}
		}
		
		for(int i=1 ; max/i>0 ; i*=10){	//1자리수부터 가장 큰 수의 자리수까지 radixsort 실행(1, 10, 100...)
			intArr = radixsort(intArr, i);
		}
		return intArr; 
	}
	
	private static int[] radixsort(int[] intArr, int place){
		int[] out = new int[intArr.length]; //sort 결과 담을 배열
		Queue[] bucket = new Queue[10];	//0~9까지 10개의 자리수
		
		for(int i=0 ; i<10 ; i++){
			bucket[i] = new LinkedList<Integer>();	//각 bucket에 값 넣기 위해 LinkedList셋팅
		}
		
		for(int i=0 ; i<intArr.length ; i++){
			int digit = getDigit(intArr[i], place); //각 자리수(1, 10, 100...)에 들어있는 숫자 구하기
			bucket[digit].offer(intArr[i]);	//자리수에 들어있는 숫자의 큐에 해당 값 저장
		}
		
		int i=0 ;
		int index = 0;
		while(i < 10){
			if(bucket[i].size() != 0){	//버킷에 숫자가 들어있으면
				//결과배열에 차례로 집어넣음, 여기 틀림(int)가 아니라 (Integer)로 cast 해야함
				out[index] = (int)bucket[i].poll();
				index++;	//결과배열 인덱스 증가
			}else{	//버킷에 숫자가 없으면
				i++;	//버킷 인덱스 증가
			}
		}
		
		return out;
	}
	
	private static int getDigit(int value, int digitPlace){
		return ((value/digitPlace)%10);	//값을 자리수(1,10,100...)으로 나눠서 10으로 나눈 나머지
	}
}
