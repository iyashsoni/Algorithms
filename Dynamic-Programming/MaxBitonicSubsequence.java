public class MaxBitonicSubsequence{
	public static void main(String[] args){
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int ans = maxBitonicSubsequence(arr);
		System.out.println(ans);
	}
	
	static int maxBitonicSubsequence(int[] arr){
		int len = arr.length;
		int[] lis = new int[len];
		int[] lds = new int[len];
		
		for (int i = 0; i < len; i++)
      		lds[i] = lis[i] = 1;
		
		for(int i=1; i<len; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && lis[i] < lis[j]+1)
					lis[i] = lis[j] + 1;
			}
		}
		
		for(int i=len-2; i>=0; i--){
			for(int j=len-1; j>i; j--){
				if(arr[i] > arr[j] && lds[i] < lds[j]+1)
					lds[i] = lds[j] + 1;
			}
		}
		
		int lengthOfLBS = lis[0] + lds[0] - 1;
		for(int j=1; j<len-1; j++)
			if(lis[j] + lds[j] - 1 > lengthOfLBS)
				lengthOfLBS = lis[j] + lds[j] - 1;
			
		return lengthOfLBS;
	}
}
