import java.util.*;

public class GetOddOccurence{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++)
			a[i] = sc.nextInt();
	
		int ans = calc(a);
		System.out.println(ans);
	}
 	public static int calc(int[] a){
 		int temp = 0;
 		int n = a.length;
 		
 		for(int i=0; i<n; i++)
			temp = temp ^ a[i];
			
		return temp; 		
 	}
 	
}
