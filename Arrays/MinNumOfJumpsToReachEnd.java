public class MinNumOfJumpsToReachEnd{
	
	public static void main(String[] args){
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int ans = calc(arr);
		System.out.println(ans);
	}
	
	static int calc(int[] arr){
		int n = arr.length;
		int[] dp = new int[n];
		dp[n-1] = 0;
		
		for(int i=n-2; i>=0; i--){
			if(arr[i] >= (n-1 - i))
				dp[i] = 1;
			else{
				int temp = arr[i], min = Integer.MAX_VALUE;
				for(int j = i+1; j<=(i+temp); j++){
					if(dp[j] < min)
						min = dp[j];
				}
				dp[i] = 1+min;
			}
		}
		return dp[0];
	}
}
