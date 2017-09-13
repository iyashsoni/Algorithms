public class SubsetSum{
	public static void main(String[] args){
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		calc(arr, arr.length, sum);
	}
	
	static void calc(int[] arr, int n, int sum){
		boolean[][] mat = new boolean[sum+1][n+1];
		for(int i=0; i<=n; i++)
			mat[0][i] = true;
			
		for(int i=1; i<=sum; i++)
			mat[i][0] = false;
		
		for(int i=1; i<=sum; i++){
			for(int j=1; j<=n; j++){
				mat[i][j] = mat[i][j-1];
				if(i >= arr[j-1])
					mat[i][j] = mat[i][j] || mat[i-arr[j-1]][j-1];
			}
		}
		System.out.println(mat[sum][n]);
	}
}
