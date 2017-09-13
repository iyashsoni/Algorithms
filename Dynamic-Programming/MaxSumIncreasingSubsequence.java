public class MaxSumIncreasingSubsequence{
	public static void main(String[] args){
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		int ans = maxSumIncreasingSubsequence(arr);
		System.out.println(ans);
	}
	
	static int maxSumIncreasingSubsequence(int[] arr){
		int len = arr.length;
		int[] dp = new int[len];
		dp[0] = arr[0];
		int max_sum;
		for(int i=1; i<len; i++){
			max_sum = Integer.MIN_VALUE;
			for(int j=0; j<i; j++)
				if(arr[i] > arr[j] && dp[j] + arr[i] > max_sum)
					max_sum = dp[j] + arr[i];
			dp[i] = max_sum;
		}
		
		int max = dp[0];
		for(int i=1; i<len; i++)
			if(dp[i] > max)
				max = dp[i];
				
		return max;
	}
}
