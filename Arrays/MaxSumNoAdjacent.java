public class MaxSumNoAdjacent{

	public static void main(String[] args){
		
		int[] a = {5,  5, 10, 40, 50, 35};
		int ans = findMaxSum(a);
		System.out.println(ans);
	}
	
	static int findMaxSum(int[] a){
	
		int incl = a[0];
		int excl = 0;
		int n = a.length;
		int i = 1;
		int temp;
		
		while(i < n){
			temp = excl;
			excl = max(incl, excl);
			incl = temp + a[i];
			i++;
		}
		return max(incl,excl);
	}
	
	static int max(int a, int b){
		return (a>b)?a:b;
	}
}
