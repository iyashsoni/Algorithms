public class MinJumpsToReachEnd{
	public static void main(String[] args){
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        minJumpsToReachEnd(arr);
	}
	
	static void minJumpsToReachEnd(int[] arr){
		int len = arr.length;
		int[] dp = new int[len];
		dp[len-1] = 0;
		for(int i=len-2; i>=0; i--){
			if(i + arr[i] >= len-1)
				dp[i] = 1;
			else{
				int min = Integer.MAX_VALUE;
				
				if(i == 0)
					System.out.println("When i is 0, arr[i]: "+arr[0]+"   min: "+min);
					
				for(int j=i+1; j<=(i+arr[i]); j++){
					if(i == 0)
						System.out.println("When i is 0, j: "+j);
					if(dp[j] < min)
						min = dp[j];
				}
				dp[i] = min + 1;
			}
		}
		
		for(int i=0; i<len; i++)		
			System.out.println(i+"   "+ arr[i]+"   "+dp[i]);
	}
}
