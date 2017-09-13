public class MatrixChainMultiplication{
	public static void main(String[] args){
		int[] p = {1, 2, 3, 4};
		calcMinCostOfMultiplication(p);
	}
	
	static void calcMinCostOfMultiplication(int[] p){
		int n = p.length;
		int[][] mat = new int[n][n];
		int i,j,k;
		int L,min;
		
		for(i=1; i<n; i++)
			mat[i][i] = 0;
		
		for(L=2; L<n; L++){
			for(i=1; i<=n-L+1; i++){
				j = i+L-1;
				if(j == n)
					continue;
				mat[i][j] = Integer.MAX_VALUE;
				for(k=i; k<j; k++){
					min = mat[i][k] + mat[k+1][j] + p[i-1]*p[k]*p[j];
					if(min<mat[i][j])
						mat[i][j] = min;
				}
			}
		}
		System.out.println(mat[1][n-1]);
	}
}
