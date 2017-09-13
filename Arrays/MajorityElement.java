import java.util.*;

public class MajorityElement{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] a;
		int n = sc.nextInt();
		a = new int[n];
		
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
			
		a= qsort(a,0,n-1);
/*		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
*/		
		int ans = calc(a);
		
		if(ans == -1)
			System.out.println("NONE");
		else
			System.out.println(ans);
	}
	
	public static int calc(int[] a){
		int cnt=1;
		int n = a.length;
		
		for(int i=1;i<n;i++){
			if(a[i] == a[i-1]){
				cnt++;
				if(cnt > n/2)
					return a[i];
			}
			else
				cnt=1;
		}
		return -1;
	}
	
	public static int partition(int A[], int si, int ei)
	{
	    int x = A[ei];
	    int i = (si - 1);
	    int j,temp;
	 
	    for (j = si; j <= ei - 1; j++)
	    {
			if(A[j] <= x)
			{
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;	
			}
	    }

		temp = A[i+1];
		A[i+1] = A[ei];
		A[ei] = temp;	
	
		return (i + 1);
	}
	public static int[] qsort(int A[], int si, int ei)
	{
		int pi;    /* Partitioning index */
		if(si < ei)
		{
		    pi = partition(A, si, ei);
		    qsort(A, si, pi - 1);
		    qsort(A, pi + 1, ei);
		}
		return A;
	}
}
