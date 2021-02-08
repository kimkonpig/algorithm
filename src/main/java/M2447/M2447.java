import java.util.*;

//수정필요 2021.02.08
public class M2447 {
	public static void main(String[] args) throws Exception{
		int n;
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		 for(int i=0 ; i<n ; i++){
			 for(int j=0 ; j<n ; j++){
				 int x = i;
				 int y = j;
				 
				 while(x>0){
					 if(x%3==1 && y%3==1){
						 sb.append(" ");
						 break;
					 }
					 x = x/3;
					 y = y/3;
				 }
				 sb.append("*");
			 }
			 sb.append("\n");
		 }
		 System.out.println(sb);
    }
}
