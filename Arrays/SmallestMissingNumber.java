public class SmallestMissingNumber{

	public static void main(String[] args){
		
		int[] arr = {0, 1, 2, 3};
		int n = arr.length;
		int m = 5;		
		System.out.println(calc(arr,0,n-1,m));
	}
	
	static int calc(int[] arr, int left, int right, int m){
		
		if(left > right)
			return right+1;
			
		if(arr[left] != left)
			return left;
			
		int mid = (left+right)/2;	
		if(arr[mid] > mid)
			return calc(arr,left,mid,m);
		else
			return calc(arr,mid+1,right,m);	
	}
}
