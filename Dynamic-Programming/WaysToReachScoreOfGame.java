public class WaysToReachScoreOfGame{
	public static void main(String[] args){
		calcWaysToReachScoreOfGame(20);
		calcWaysToReachScoreOfGame(13);
	}
	
	static void calcWaysToReachScoreOfGame(int n){
		int[] ways = new int[n+1];
		ways[0] = 1;
		
		for(int i=3; i<=n; i++)
			ways[i] += ways[i-3];
		for(int i=5; i<=n; i++)
			ways[i] += ways[i-5];
		for(int i=10; i<=n; i++)
			ways[i] += ways[i-10];
		
		System.out.println(ways[n]);
	}
}
