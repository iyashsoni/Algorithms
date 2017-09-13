public class WordWrap{
	final static int INF = Integer.MAX_VALUE; 
	public static void main(String[] args){
		int[] l = {3, 2, 2, 5};
		int n = l.length;
		int M = 6; // line width
		solveWordWrap (l, n, M);
	}
	
	static void solveWordWrap (int[] l, int n, int M){
		int[][] extras = new int[n+1][n+1];
		int[][] lc = new int[n+1][n+1];
		int[] c = new int[n+1];
		int[] p = new int[n+1];
		
		for(int i=1; i<=n; i++){
			extras[i][i] = M - l[i-1];
			for(int j=i+1; j<=n; j++)
				extras[i][j] = extras[i][j-1] - l[j-1] - 1;
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(extras[i][j] < 0)
					lc[i][j] = INF;
				else if(j == n && extras[i][j] >= 0)
					lc[i][j] = 0;
				else
					lc[i][j] = extras[i][j] * extras[i][j];
			}
		}
		
		c[0] = 0;
		for(int j=1; j<=n; j++){
			c[j] = INF;
			for(int i=1; i<=j; i++){
				if(c[i-1] != INF && lc[i][j] != INF && c[i-1] + lc[i][j] < c[j]){
					c[j] = c[i-1] + lc[i][j];
					p[j] = i;
				}
			}
		}

		// total min cost
		for(int i=0; i<=n; i++)
			System.out.print(c[i] + " ");
		System.out.println();
		
		// Printing arrangement
		printSolution(p, n);
	}
	
	static int printSolution(int[] p, int n){
		int k;
		if (p[n] == 1)
		    k = 1;
		else
		    k = printSolution (p, p[n]-1) + 1;
		System.out.println("Line number : "+ k +" From word no. "+ p[n] +" to "+ n);
		return k;
	}
}
