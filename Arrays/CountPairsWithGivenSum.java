import java.util.*;
public class CountPairsWithGivenSum{

	public static void main(String[] args){
	
		int arr[] = {1, 5, 7, -1, 5} ;
		int n = 5;
		int sum = 6;
		System.out.println("Count of pairs is "+getPairsCount(arr, n, sum));
	}
	
	static int getPairsCount(int arr[], int n, int sum)
	{
		Map m = new HashMap();
		for (int i=0; i<n; i++)
		    if(m.containsKey(arr[i])){
		    	int temp = (int)m.get(arr[i]);
			    m.put(arr[i], ++temp);
			}
			else
			    m.put(arr[i],1);

		int twice_count = 0;
		for (int i=0; i<n; i++)
		{
		    twice_count += (int)m.get(sum-arr[i]);
			if (sum-arr[i] == arr[i])
		        twice_count--;
		}
		return twice_count/2;
	}
}
