import java.util.*;

public class M2447 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int n;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		 for(int i=0 ; i<n ; i++){
			 for(int j=0 ; j<n ; j++){
				 int x = i;
				 int y = j;
				 
				 while(x>0){
					 if(x%3==1 && y%3==1){
						 break;
					 }
					 x = x/3;
					 y = y/3;
				 }
				 sb.append(x==0 ? "*" : " ");
			 }
			 sb.append("\n");
		 }
		 System.out.print(sb);
    }
}

