# 객체의 정렬 기준을 명시하는 두 가지 방법
  - Comparable Interface
  - Comparator Interface

## Comparable
- 정렬 수행 시 기본적으로 적용되는 정렬이 기준이 되는 메소드를 정의한 인터페이스
- package : java.lang.Comparable
  - Java에서 제공하는, 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있다.
  - Integer class, Double class(오름차순 정렬) String class(사전순 정렬) 등...
- 구현 방법
  - 정렬할 객체에 Comparable Interface를 implements한 후, compareTo() 메소드를 오버라이드하여 작성한다.
  - compareTo() 메소드 작성 방법
    - (현재 객체) < (parameter 객체) => 음수 리턴
    - (현재 객체) == (parameter 객체) => 0 리턴
    - (현재 객체) > (parameter 객체) => 양수 리턴
  - 음수 또는 0 리턴 시 객체 자리가 그대로 유지된다.
  - 양수 리턴 시 두 객체의 자리가 바뀐다.
- 사용 방법
  - Arrays.sort(array)
  - Collections.sort(list)

>참고 사항 : Arrays.sort()와 Collections.sort()의 차이
>1. Arrays.sort()
>  - 배열 정렬 시 사용한다.
>  - byte[], char[], double[], int[], Object[], T[] 등 Object Array(기본 자료형에 대한 배열)에서는 TimSort(Merge Sort + Insertion Sort)를 사용한다.
>  - Primitive Array(새로 정의한 클래스에 대한 배열)에서는 Dual Pivot QuickSort(QuickSort + Insertion Sort)를 사용
>2. Collections.sort()
>  - List Collection 정렬 시 사용한다.
>  - ArrayList, LinkedList, Vector 등 내부적으로 Arrays.sort()를 사용한다.

## Comparator
- 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스)들의 기본 정렬 기준과 다르게 정렬하고 싶을 때 사용하는 인터페이스
- package : java.util.Comparator
  - 기본적인 정렬 방법인 오름차순 정렬과 반대로 내림차순으로 정렬할 때 많이 사용한다.
- 구현 방법
  - Comparator Interface를 implements한 후 compare() 메소드를 오버라이드하여 작성한다.
  - compare() 메소드 작성 방법
    - (첫 번째 parameter 객체) < (두 번째 parameter 객체) => 음수 리턴
    - (첫 번째 parameter 객체) == (두 번째 parameter 객체) => 0 리턴
    - (첫 번째 parameter 객체) > (두 번째 parameter 객체) => 양수 리턴
  - 음수 또는 0 리턴 시 객체의 자리가 그대로 유지된다.
  - 양수 리턴 시 두 객체의 자리가 변경된다.
    - Integer.compare(x, y) (오름차순 정렬)과 동일한 개념이다.
    - return(x < y) ? -1 : ((x==y) ? 0 : 1);
    - 내림차순 정렬의 경우 Integer.compare(y, x) (내림차순 정렬)
- 사용 방법
  - Arrays.sort(array, new Comparator<>(){...})
  - Collections.sort(array, new Comparator<>(){...})
  - Arrays.sort(), Collections.sort() 메소드는 두 번째 인자로 Comparator interface 받을 수 있다.

### 예시
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class M11650{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0 ; i<arr.length ; i++){
			String[] tmp = br.readLine().split(" ");
			for(int j=0 ; j<arr[i].length ; j++){
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		//기준에 따라 정렬해야 하므로 Comparator 인터페이스 오버라이딩 후 재정의 필요
		Arrays.sort(arr, new Comparator<int[]>(){
			//int[]는 2차원 배열에서 하나의 행을 기준으로 비교한다는 의미

			//인터페이스 오버라이딩
			@Override
			public int compare(int[] o1, int[] o2) {
				 /*
				 * 파라미터 o1, o2는 최초 1번째 행과 0번째 행을 의미한다.
				 * 다시말해 o1은 다음 행, o2는 기준이 되는 행을 의미한다. 
				 */
				//Integer.compare()메소드는 java7 이상 사용 가능				
				/*if(o1[0] == o2[0]){ //x좌표가 동일하면 y좌표 기준으로 정렬
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);*/
				
				if(o1[0] != o2[0]){//x좌표 다르면 x좌표 비교
					return o1[0] - o2[0];
				}else{//x좌표 같다면 y좌표 비교
					return o1[1] - o2[1];
				}
			}			
		});
		
		for(int[] rst : arr){
			sb.append(rst[0] + " " + rst[1] + "\n");
		}

		System.out.print(sb.toString());
	}
}
```
