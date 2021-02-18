package study;

import java.util.*;

/*
* 진행중
*/

public class M2667 {

	static int totDanji = 0; //총 단지 수
	static int[] danji; //단지 내 집의 수;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //지도의 크기(정사각형, 5<=N<=25)
		ArrayList<Character>[] al = new ArrayList[N];
		boolean[] visit = new boolean[N];
		
		danji = new int[N*N];
		
		for(int i=0 ; i<N ; i++){
			al[i] = new ArrayList<Character>();
		}
		
		for(int i=0 ; i<N ; i++){
			String input = sc.next();
			for(int j=0 ; j<N ; j++){
				al[i].add(input.charAt(j));
			}
			//System.out.println(al[i]);
		}
		
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				//System.out.println(al[i].get(j));
				if(al[i].get(j).equals('1') && visit[j]==false){
					totDanji++;
					dfs(j, al, visit);
				}
			}
		}
		
		Arrays.sort(danji);
		
		System.out.println(totDanji);
		
		for(int i=0 ; i<danji.length ; i++){
			if(danji[i] != 0)
				System.out.println(danji[i]);
		}
	}
	
	static void dfs(int j, ArrayList<Character>[] al, boolean[] visit){
		visit[j] = true;
		danji[totDanji]++;
		
		for(int k=0 ; k<al.length ; k++){
			if(visit[k]==false){
				dfs(k, al, visit);
			}
		}
	}
}
