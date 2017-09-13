public class NumbersWithSumEqualsSum{
	public static void main(String[] args){
		int len = 3;
		int sum = 6;
		calcFinalCount(len, sum);
	}
	
	static void calcFinalCount(int len, int sum){
		int[][] lookup = new int[len+1][sum+1];
		for(int i=0; i<=len; i++)
			for(int j=0; j<=len; j++)
				lookup[i][j] = -1;
		int ans = 0;
		for(int i=1; i<10; i++)
			if(sum-i >= 0)
				ans += calcCountUtil(len-1, sum-i);
		System.out.println(ans);
	}
	
	static int calcCountUtil(int len, int sum){
		if(len == 0)
			return 0;
		
	}
	
}
