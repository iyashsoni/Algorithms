public class UglyNumbers{
	public static void main(String[] arg){
		int N = 150;
		calcNthUglyNumber(N);
	}

	static void calcNthUglyNumber(int N){
		int[] un = new int[N];
		int i2,i3,i5;
		un[0] = 1;
		i2 = i3 = i5 = 0;
		
		for(int i=1; i<N; i++){
			un[i] = min(un[i2] * 2, un[i3] * 3, un[i5] * 5);
			
			if(un[i] == un[i2] * 2)
				i2++;
			if(un[i] == un[i3] * 3)
				i3++;
			if(un[i] == un[i5] * 5)
				i5++;
		}
		
		System.out.println(un[N-1]);
	}
	
	static int min(int a, int b, int c){
		return min(a, min(b,c));
	}
	
	static int min(int a, int b){
		return (a<b)?a:b;
	}
}
