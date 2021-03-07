package M10989;

import java.io.*;

//counting sort
public class M10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringBuffer sb = new StringBuffer();
        //Scanner보다 BufferedReader가, System.out.print보다 StringBuffer가, StringBuffer보다 BufferedWriter가 빠르다.

        int N = Integer.parseInt(br.readLine());
        int[] bfArr = new int[N]; //정렬 전 배열
        int[] afArr = new int[N]; //정렬 후 배열
        for(int i=0 ; i<N ; i++){
            bfArr[i] = Integer.parseInt(br.readLine());
        }

        int max = getMax(bfArr);
        int[] ctArr = new int[max+1]; //누적합 배열

        //과정 1. bfArr의 value와 동일한 ctArr의 index의 value 카운팅
        for(int i=0 ; i<bfArr.length ; i++){
            ctArr[bfArr[i]]++;
        }

        //과정 2. ctArr 누적합 만들기
        for(int i=0 ; i<ctArr.length-1 ; i++){
            ctArr[i+1] += ctArr[i];
        }

        //과정 3. 정렬하여 afArr 채우기
        for(int i=bfArr.length-1 ; i>=0 ; i--){
            int val = bfArr[i];
            ctArr[val]--;
            afArr[ctArr[val]] = val;
        }

        for(int i : afArr){
            //sb.append(i + "\n");
            bw.write(i + "\n");
        }

        //System.out.print(sb.toString());
        bw.flush();

    }
    //주어진 수 중 가장 큰 값 구하기
    private static int getMax(int[] bfArr){
        int max = bfArr[0];

        for(int i=1 ; i<bfArr.length ; i++){
            if(max < bfArr[i]){
                max = bfArr[i];
            }
        }

        return max;
    }
}
