public class TwoNumbersWithOddOccurrences{
	
	public static void main(String[] args){
	
		int[] arr = {4, 4, 3, 6, 6, 2, 1, 1};
		calc(arr);
	}
	
	static void calc(int[] arr){
		int n = arr.length;
		int setBit, xor = 0, x = 0, y = 0;
		for(int i=0; i<n; i++){
			xor = arr[i] ^ xor;
		}
		
		setBit = xor & ~(xor - 1);
		
		for(int i=0; i<n; i++){
			if((arr[i] & setBit) == 0)
				x = x ^ arr[i];
			else 
				y = y ^ arr[i];
		}
			
		System.out.println("Two numbers are: "+x+" & "+y);		
	}
}
