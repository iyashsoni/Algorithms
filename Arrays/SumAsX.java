import java.util.*;

public class SumAsX
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] a = {10,2,7,3,9,-1};
		
		System.out.println(calc(a,6));
	}
	
	public static boolean calc(int[] a, int sum)
	{
		int i,j;
		
		a = qsort(a,0,a.length-1);
		for(i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		i=0;j=a.length-1;
		while(j >= i)
		{
			if(a[i] + a[j] == sum)
				return true;
			else if(a[i] + a[j] > sum)
				j--;
			else
				i++;
		}
		return false;
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
