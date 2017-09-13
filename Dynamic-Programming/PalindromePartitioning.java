public class PalindromePartitioning{
	public static void main(String[] args){
		String p = "ababbbabbababa";
		System.out.println(p);
		calcPalindromePartitioning(p);
		System.out.println();

		p = "forgeeksskeegfor";
		System.out.println(p);
		calcPalindromePartitioning(p);
	}
	
	static void calcPalindromePartitioning(String str){
		int n = str.length();
		boolean[][] P = new boolean[n][n];
		int[] C = new int[n];
		int maxLen = 1;
		
		for(int i=0; i<n; i++)
			P[i][i] = true;
			
		for(int L=2; L<n; L++){
			for(int i=0; i<n-L+1; i++){
				int j = i+L-1;
				if(L == 2)
					P[i][j] = (str.charAt(i) == str.charAt(j));
				else
					P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i+1][j-1];
					
				if(P[i][j] && maxLen<(j-i+1))
					maxLen = (j-i+1);
			}
		}
		System.out.println("Maximum length of Palindromic Substring: "+maxLen);
		
		for(int i=0; i<n; i++){
			if(P[0][i])
				C[i] = 0;
			else{
				C[i] = Integer.MAX_VALUE;
				for(int k=0; k<i; k++){
					if(P[k+1][i] && 1+C[k] < C[i])
						C[i] = 1+C[k];
				}
			}
		}
		System.out.println("Number of partitions: "+C[n-1]);
	}
}
