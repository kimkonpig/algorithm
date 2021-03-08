package main.java.M2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M2108 {

    static int mode = 0;

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer(); //출력을 위한 변수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력을 위한 변수

        int N = Integer.parseInt(br.readLine()); //수의 개수 입력

        //입력받은 정수로 배열 생성
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* 1. 산술평균 start */
        double sum = 0;
        for(int i=0 ; i<N ; i++){
            sum += arr[i];
        }

        //sum을 나누면 소수점 발생할 수 있으니까 sum은 double타입으로 설정, 반올림한 결과는 (int)로 형변환 해준다.
        sb.append(Math.round(sum / (double)N)).append("\n");
        /* 1. 산술평균 end */

        /* 2. 중앙값 start */
        int[] rstArr; //정렬 후 배열
        rstArr = countingSort(arr); //10989 문제에서 사용한 카운팅정렬을 사용해보았다.
        sb.append(rstArr[N / 2]).append("\n"); //N은 홀수이므로 나누기 2하여 중앙값을 구할 수 있다.
        /* 2. 중앙값 end */

        /* 3. 최빈값 start */
        /*int[] freq = new int[8001]; //빈도 계산용 변수, -4000~4000범위를 위해 사용, 인덱스 4000을 0으로 사용
        for(int num : arr){
            freq[num+4000]++; //빈도 설정
        }

        int maxFreq = 0; //최대 빈도
        int maxIndex = 0; //최대 빈도 값을 가진 인덱스
        for(int i=0 ; i<freq.length ; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
            }
        }
        boolean flag = false; //두번째를 구별하기 위한 변수

        for(int i=0 ; i<freq.length ; i++){
            if(freq[i] == maxFreq){ //최빈값이면
                if(flag){ //두번째면
                    maxIndex = i-4000;
                    break;
                }
                maxIndex = i-4000;
                flag = true;
            }
        }*/

        //sb.append(maxIndex + "\n");
        sb.append(mode).append("\n");
        /* 3. 최빈값 end */

        /* 4. 범위 start */
        sb.append(Math.abs(rstArr[N-1]-rstArr[0]));
        /* 4. 범위 end */

        System.out.print(sb.toString());

    }

    //정해진 범위에서 빠른 정렬인 카운팅 정렬
    private static int[] countingSort(int[] arr){
        //int max = getMax(arr); //음수값 없으면 max를 사용해서 카운팅 배열 크기를 설정한다.
        //int[] countArr = new int[max + 1]; //누적합 배열
        int[] countArr = new int[8001]; //카운팅 배열(음수값 있어서 -4000~4000범위 지정)
        int[] rstArr = new int[arr.length]; //정렬 후 배열

        /*
            Counting Sort 1.
            정렬 전 arr 배열의 value와 동일한 countArr 배열의 index의 value에 +1
         */
        for (int value : arr) {
            //arr에는 음수값이 있을 수 있으므로 +4000을 해준다. 4000을 0번째 index라고 생각하면 된다.
            countArr[value + 4000]++;
        }

        //최빈값 구하기 포함
        int maxCount = 0;
        int count = 0;


        for(int i=0 ; i<countArr.length ; i++){
            if(countArr[i] == maxCount && count == 0){
                count++;
                mode = i-4000;
            }
            if(count == 2) break;
        }

        //Counting Sort 2. countArr 배열을 누적합 배열로 변경
        for(int i=1 ; i<countArr.length-1 ; i++){
            countArr[i] += countArr[i-1];
        }

        //Counting Sort 3. 정렬 전 arr 배열과 countArr 배열로 rstArr 채우기
        for(int i=arr.length-1 ; i>=0 ; i--){
            int val = arr[i];
            countArr[val+4000]--;
            rstArr[countArr[val+4000]] = val;
        }

        /*for(int num : rstArr)
            System.out.print("rstArr: " + num + " ");*/

        return rstArr;
    }

    //주어진 수 중 가장 큰 값 구하기
    private static int getMax(int[] arr){
        int max = arr[0];

        for(int i=1 ; i<arr.length ; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
