import java.io.*;

public class M2231 {

	//1) 브루트포스 : 0부터 N-1까지 모든 경우의 수 따져보기 -> 148ms
	//2) start 변수를 두고 탐색 시작값을 설정한다. -> 128ms
	//	  - 분해합으로 N을 만들 수 있는 최소범위는 N에서 자리수의 최대값인 9를 자리수만큼 뺀 값이다.(N - N의자리수 * 9)
	//	  - 최대범위는 N이다. 분해합으로 N을 만들고자 할 때 N보다 큰 값의 분해합으로 N을 만들 수 없다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int N = Integer.parseInt(str);
		int start = N - (str.length() * 9);
		int result = 0;
		
		for(int i=start ; i<N ; i++){
			int num = i;
			int sum = 0; //자리수별 합
			
			while(num != 0){
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == N){
				result = i;
				break;
			}
		}
		
		System.out.print(result);
	}
}
