public class FloydWarshall{
	final static int INF = Integer.MAX_VALUE;
	public static void main(String[] args){
		int[][] graph = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
                        };
        print(graph);
        floydWarshall(graph);
	}
	
	static void floydWarshall(int[][] graph){
		int V = graph[0].length;
		int[][] dp = new int[V][V];
		
		for(int i=0; i<V; i++)
			for(int j=0; j<V; j++)
				dp[i][j] = graph[i][j];
		
			
		for(int k=0; k<V; k++)
			for(int i=0; i<V; i++)
				for(int j=0; j<V; j++)
					if(dp[i][k] != INF && dp[k][j] != INF && dp[i][j] > dp[i][k] + dp[k][j])
						dp[i][j] = dp[i][k] + dp[k][j];

		System.out.println();
		print(dp);
	}
	
	static void print(int[][] dp){
		int V = dp[0].length;
		for(int i=0; i<V; i++){
			for(int j=0; j<V; j++)
				if(dp[i][j] != INF)
					System.out.print(dp[i][j]+"   ");
				else
					System.out.print("INF ");
			System.out.println();
		}
	}
}
