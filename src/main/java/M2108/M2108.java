import java.util.*;
import java.io.*;

/*
 * 계속 틀리다고 떠서 다른 블로그 글에 있는 코드를 전체  ㅠㅠ
 * https://coder9084.tistory.com/57
 * 카운터정렬 사용
*/
public class M2108 {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        int sum=0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
      //누적합 배열로는 만들지 않았음
        int[] countArr = new int[8001];
        for(int n : arr) {
            countArr[n+4000]++;
        }
        
        int[] ansArr = new int[N];
        int tempMax = 0, tempNum=0 , index=0;
        
        for(int i=0; i<countArr.length; i++) {
            tempNum = countArr[i];
            if(tempNum>0) {
                if(tempNum > tempMax) {
                    tempMax = tempNum;
                }
                
                while(tempNum>0) {
                    ansArr[index] = i-4000;
                    tempNum--;
                    index++;
                }
            }
        }
        
        //최빈값이 여러개가 있을 때 두번째로 작은 값을 출력하기 위해 List를 사용했다.
        ArrayList<Integer> list = new ArrayList<Integer>();
        int most;
        for(int i=0; i<countArr.length; i++) {
            if(countArr[i]==tempMax) {
                list.add(i-4000);
            }
        }
        
        if(list.size()>1) {
            most = list.get(1);
        } else {
            most = list.get(0);
        }
        
        bw.write((int)Math.round((double)sum/N)+"\n");
        bw.write(ansArr[ansArr.length/2]+"\n");
        bw.write(most+"\n");
        bw.write(ansArr[ansArr.length-1]-ansArr[0]+"\n");
     
        bw.flush();
    }
}
