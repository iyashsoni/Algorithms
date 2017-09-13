public class MaxContiguousSum{
	public static void main(String[] args){
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		calcSum(arr);
	}
	
	static void calcSum(int[] arr){
		int max_ending_here, max_so_far;
		max_ending_here = max_so_far = 0;
		
		int N = arr.length;
		for(int i=0; i<N; i++){
			if(max_ending_here + arr[i] > 0)
				max_ending_here += arr[i];
			if(max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}
		
		System.out.println(max_so_far);
	}
}
