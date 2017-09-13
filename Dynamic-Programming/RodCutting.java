public class RodCutting{
	public static void main(String[] args){
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int ans = maxValueOfRodCutting(prices, prices.length);
		System.out.println(ans);
	}
	
	static int maxValueOfRodCutting(int[] prices, int size){
		int[] val = new int[size + 1];
		for(int i=1; i<=size; i++){
			int max_val = Integer.MIN_VALUE;
			for(int j=0; j<i; j++)
				max_val = max(max_val, val[j] + prices[i-j-1]);
			val[i] = max_val;
		}
		return val[size];
	}
	
	static int max(int a, int b){	return (a>b)?a:b;	}
}
