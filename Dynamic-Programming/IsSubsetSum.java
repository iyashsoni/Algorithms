public class IsSubsetSum{
	public static void main(String[] args){
		int arr[] = {3, 1, 1, 2, 2,1};
        int n = arr.length;
        if (findPartition(arr, n))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");
	}
	
	static boolean findPartition(int[] arr, int n){
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += arr[i];
		if(sum%2 == 0)
			return isSubsetSum(arr,n,sum);
		return false;
	}
	
	static boolean isSubsetSum(int[] arr, int n, int sum){
	
		boolean[][] table = new boolean[sum/2 + 1][n + 1];
		
		for(int i=1; i<=sum/2; i++)
			table[i][0] = false;
		for(int i=0; i<=n; i++)
			table[0][i] = true;
		
		for(int i=1; i<=sum/2; i++){
			for(int j=1; j<=n; j++){
				table[i][j] = table[i][j-1];
				if(i >= arr[j-1])
					table[i][j] = table[i][j] || table[i-arr[j-1]][j-1];
			}
		}
		return table[sum/2][n];
	}
}
