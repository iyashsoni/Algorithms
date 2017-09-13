public class OBST{

	public static void main(String[] args){
		int[] keys = {8, 12, 16};
		int[] freq = {34, 8, 50};
		calcOptimalCost(freq);
	}
	
	static void calcOptimalCost(int[] freq){
		System.out.println(calcOptimalCostUtil(freq, 0, freq.length-1));
	}
	
	static int calcOptimalCostUtil(int[] freq, int i, int j){
		int n = freq.length;
		int[][] cost = new int[n][n];
		int[][] freqSum = new int[n][n];
		
		for(int k=0; k<n; k++){
			for(int l=k; l<n; l++){
				if(k == l){
					freqSum[k][l] = freq[l];
					cost[k][l] = freq[l];
				}
				else
					freqSum[k][l] = freqSum[k][l-1] + freq[l];
			}
		}
			
		for(int Len=2; Len<=n; Len++){
			for(int k=0; k<n-Len+1; k++){
				int l = Len + k - 1;
				
				cost[k][l] = Integer.MAX_VALUE;
				for(int r=k; r<=l; r++){
					int c = ((r>k)?cost[k][r-1]:0) + ((r<l)?cost[r+1][l]:0) + freqSum[k][l];
					if(cost[k][l] > c)
						cost[k][l] = c;
				}
			}
		}
		return cost[0][n-1];
	}
}
