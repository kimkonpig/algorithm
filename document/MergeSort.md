## 병합정렬(Merge Sort)
- 대표적인 O(logN) 알고리즘
- 분할 정복(Devide and Conquer) 기법과 재귀호출을 이용한 정렬 알고리즘
- 주어진 배열을 원소가 하나 밖에 남지 않을 때까지 계속 둘로 쪼갠 후, 다시 크기 순으로 재배열하여 원래 크기의 배열로 합친다.

0. 1부터 8까지 총 8개의 숫자가 들어있는 배열이 있다.<br/>
```java
[6, 5, 3, 1, 8, 7, 2, 4]
```
1. 하나의 배열을 두 개로 쪼갠다.
```java
[6, 5, 3, 1] [8, 7, 2, 4]
```
2. 다시 두 개의 배열을 네 개로 쪼갠다.
```java
[6, 5] [3, 1] [8, 7] [2, 4]
```
3. 마지막으로 네 개의 배열을 여덟 개로 쪼갠다.
```java
[6] [5] [3] [1] [8] [7] [2] [4]
```
4. 더이상 쪼갤 수 없으니 두 개씩 합친다. 합칠 때는 작은 숫자, 큰 숫자 순으로 위치시킨다.
```java
[5, 6] [1, 3] [7, 8] [2, 4]
```
5. 네 개의 배열을 두 개로 합친다. 각 배열에서 작은 값 두 개를 비교하여 더 작은 값을 앞에 위치시킨다.
```java
[5, 6] [1, 3] [7, 8] [2, 4]
-> [5, 6] [1, 3]에서 작은 값 두 개씩 비교 : 5, 1 / 5, 3
-> [7, 8] [2, 4]에서 작은 값 두 개씩 비교 : 7, 2 / 7, 4
=> [1, 3, 5, 6] [2, 4, 7, 8]
```
6. 남은 두 개의 배열을 하나로 합친다. 5번처럼 각 배열에서 작은 값 두 개를 비교하며 더 작은 값을 앞에 위치시킨다.
```java
[1, 3, 5, 6] [2, 4, 7, 8]
-> 1, 2 / 2, 3 / 3, 4 / 4, 5 / 5, 7 / 6, 7
=> [1, 2, 3, 4, 5, 6, 7, 8]
```

### 특징
- 병합정렬 알고리즘을 큰 그림에서 보면 분할(split)과 병합(merge) 단계로 나눌 수 있다.
- 반복의 수는 점점 절반으로 줄어들기 때문에 O(logN) 시간이 필요하고, 각 단계에서 병합할 때 모든 값들을 비교해야 하므로 O(N) 시간이 필요하다.
- 즉, 총 시간복잡도는 O(NlogN)이다.
- 두 개의 배열을 병합할 때 저장할 배열이 추가로 필요하므로 공간복잡도는 O(N)이다.
- 다른 정렬 알고리즘과 달리 인접한 값들 간의 상호 자리 교대(swap)이 일어나지 않는다.

### 코드 예제1
[링크 참고](src/main/java/M2751/M2751.java)

### 코드 예제2
```java
public class merge {

	final static int n = 8;

	public static void _merge(int left, int right, int[] a) {
		int mid = (left + right) / 2;
		int lcur = left;
		int rcur = mid + 1;

		int temp[] = new int[n];
		int tcur = left;

		while (lcur <= mid && rcur <= right) {
			if (a[lcur] <= a[rcur]) {
				temp[tcur] = a[lcur];
				tcur++;
				lcur++;
			} else {
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

	public static void mergeSort(int left, int right, int a[]) {
		if (left < right) {
			int mid = (left + right) / 2; // Divide

			mergeSort(left, mid, a); // Conquer
			mergeSort(mid + 1, right, a); // Conquer
			_merge(left, right, a); // Merge
		}
	}

	public static void main(String[] args) {
		int a[] = { 4, 7, 3, 1, 8, 2, 5, 6 };

		mergeSort(0, n - 1, a);

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
```
