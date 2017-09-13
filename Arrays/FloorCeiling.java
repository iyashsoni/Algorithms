public class FloorCeiling{

	public static void main(String[] args){
		
		int[] arr = {1, 2, 3, 6, 7};
		int x = 5;
		int f = callFloor(arr,0,arr.length-1,x);
		int c = callCeiling(arr,0,arr.length-1,x);
		System.out.println("Floor: "+arr[f]+" Ceiling: "+arr[c]);
	}
	
	static int callFloor(int[] arr, int low, int high, int x){
		
		int mid = (high+low)/2;
		if(arr[mid] == x)
			return mid;
		else if(arr[mid] < x){
			if(mid == arr.length-1)
				return mid;
			return callFloor(arr,mid+1,high,x);
		}	
		else{
			if(mid != 0 && x > arr[mid-1])
				return mid-1;
			return callFloor(arr,low,mid-1,x);
		}
	}
	
	static int callCeiling(int[] arr, int low, int high, int x){
			
		int mid = (high+low)/2;
		if(arr[mid] == x)
			return mid;
		else if(arr[mid] < x)
		{
			if(mid != arr.length-1 && x <= arr[mid+1])
			  	return mid + 1;
			else
			  	return callCeiling(arr, mid+1, high, x);
		}
		else
		{
			if(mid == 0)
			  	return mid;
			else    
			  	return callCeiling(arr, low, mid - 1, x);
  		}			
	}
}
