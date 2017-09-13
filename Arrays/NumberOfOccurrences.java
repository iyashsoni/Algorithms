public class NumberOfOccurrences{

	public static void main(String[] args){
		
		int[] arr = {1, 1, 2, 2, 2, 2, 3};
		int x = 2;		
		int start = calcStart(arr,0,arr.length-1,x);
		int finish = calcFinish(arr,0,arr.length-1,x);
		System.out.println(finish-start+1);
	}
	
	static int calcStart(int[] arr, int left, int right, int x){
		
		if(left <= right){
			int mid = (left+right)/2;
			
		if(arr[mid] == x && (mid == 0 || arr[mid-1] < x))
				return mid;	
	
			else if(arr[mid] >= x)
				return calcStart(arr,left,(mid-1),x);
			else
				return calcStart(arr,(mid+1),right,x);	
		}
		return -1;
	}
	
	static int first(int arr[], int low, int high, int x, int n)
	{
	  if(high >= low)
	  {
		int mid = (low + high)/2;  /*low + (high - low)/2;*/
		if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
		  return mid;
		else if(x > arr[mid])
		  return first(arr, (mid + 1), high, x, n);
		else
		  return first(arr, low, (mid -1), x, n);
	  }
	  return -1;
	}
	
	static int calcFinish(int[] arr, int left, int right, int x){
		
		if(left <= right){
			int mid = (left+right)/2;
			
			if(arr[mid] == x && (arr[mid+1] > x || mid == arr.length-1))
				return mid;	
	
			else if(arr[mid] > x)
				return calcFinish(arr,left,(mid-1),x);
			else
				return calcFinish(arr,(mid+1),right,x);	
		}
		return -1;
	}
}
