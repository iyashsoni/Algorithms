public class MaxEleIncAndDec{
	
	public static void main(String[] args){
	
		int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int ans = calc(arr);
		System.out.println(ans);
	}
	
	static int calc(int[] arr){
		int n = arr.length;
		int[] inc = new int[n];
		int[] dec = new int[n];
		
		inc[0] = 1;
		dec[n-1] = 1;
		for(int i=1; i<n; i++){
			if(arr[i] > arr[i-1])
				inc[i] = inc[i-1] + 1;
			else
				inc[i] = 1;
		}	
		
		for(int i=n-2; i>=0; i--){
			if(arr[i] > arr[i+1])
				dec[i] = dec[i+1] + 1;
			else
				dec[i] = 1;
		}	
				
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			if((inc[i] + dec[i] - 1) > max)
				max = inc[i] + dec[i] - 1;
		}	
		return max;
	}
}
