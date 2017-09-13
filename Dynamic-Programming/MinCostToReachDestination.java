public class MinCostToReachDestination{
	final static int INF = Integer.MAX_VALUE;
	 
	public static void main(String[] args){
		int[][] graph = { {0, 15, 80, 90},
						  {INF, 0, 40, 50},
						  {INF, INF, 0, 70},
						  {INF, INF, INF, 0}
						};
		calcMinCost(graph, graph.length, graph[0].length);
	}
	
	static void calcMinCost(int[][] graph, int r, int c){
		int[] cost = new int[c];
		for(int i=1; i<c; i++)
			cost[i] = INF;
		
		// using i as intermediate nodes
		for(int i=0; i<c; i++){
			for(int j=i+1; j<c; j++)
				if(cost[j] > cost[i] + graph[i][j])
					cost[j] = cost[i] + graph[i][j];
		}
		
		System.out.println(cost[c-1]);
	}
}
