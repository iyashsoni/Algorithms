import java.util.*;

public class MergeArrays{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m,n;
		m = sc.nextInt();
		n = sc.nextInt();
		int[] mn = new int[m+n];
		int[] input = new int[n];
		
		for(int i=0; i<m; i++){
			mn[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			input[i] = sc.nextInt();
		}	
		
		mn = merge(mn, input,m,n);
		for(int  i=0;i<m+n;i++)
			System.out.print(mn[i]+" ");
	
	}
	
	public static int[] merge(int[] mn, int[] input, int m, int n){
		int temp1,temp2;
		
		// moving all elements to the end in mn 
		for(int  i=n;i<m+n;i++)
			mn[i] = mn[i-n];
		
		temp1 = 0;
		temp2 = n;
		for(int  i=0;i<m+n;i++){
			if(temp1<n && temp2<(m+n)){
				if(mn[temp2]<=input[temp1]){		
					mn[i] = mn[temp2];
					temp2++;
				}
				else{
					mn[i] = input[temp1];
					temp1++;
				}
			}
			else {
				if(temp1 == n){
					mn[i] = mn[temp2];
					temp2++;
				}
				else{
					mn[i] = input[temp1];
					temp1++;
				}
			}
		}
		
		return mn;	
	}
}
