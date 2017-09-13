public class NoConsecutiveOnes{
	public static void main(String[] args){
		int len = 5;
		calc(len);
	}
	
	static void calc(int len){
		int a, b;
		a = b = 1;
		
		for(int i=1; i<len; i++){
			a = a + b;
			b = a - b;
		}
		System.out.println(a+b);
	}
}
