public class MaxSizeSquareSubmatrix{
	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		int[][] mat = {	{0, 1, 1, 0, 1}, 
			           		{1, 1, 0, 1, 0}, 
						   	{0, 1, 1, 1, 0},
						   	{1, 1, 1, 1, 0},
						   	{1, 1, 1, 1, 1},
						   	{0, 0, 0, 0, 0}	};
        maxSizeSquareSubmatrix(mat);
	}
	
	static void maxSizeSquareSubmatrix(int[][] mat){
		int C = mat[0].length;
		int R = mat.length;
		
		int[][] dp = new int[R][C];
		
		for(int i=0; i<R; i++)
			dp[i][0] = mat[i][0];
			
		for(int j=0; j<C; j++)
			dp[0][j] = mat[0][j];
		
		for(int i=1; i<R; i++)
			for(int j=1; j<C; j++)
				if(mat[i][j] == 1)
					dp[i][j] = min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1])) + 1;
				else
					dp[i][j] = 0;

		System.out.println();
		print(dp, mat);
	}
	
	static int min(int a, int b){	return (a>b)?b:a;	}
	
	static void print(int[][] dp, int[][] mat){
		int C = dp[0].length;
		int R = dp.length;
		int i,j,x=0,y=0;
		for(i=0; i<R; i++)
			for(j=0; j<C; j++)
				if(dp[i][j] > dp[x][y]){
					x = i;
					y = j;
				}
				
		for(i=x-dp[x][y]+1; i<=x; i++){
			for(j=y-dp[x][y]+1; j<=y; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
}
