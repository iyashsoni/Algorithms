public class ArrayProduct{

	public static void main(String[] args){
		
		int[] arr = {1, 2, 3, 6, 7};
		int[] prod = calcProductArr(arr);
		printArr(arr);
		printArr(prod);
	}
	
	static void printArr(int[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	static int[] calcProductArr(int[] arr){
		
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		
		left[0] = 1;
		for(int i=1; i<n; i++)
			left[i] = left[i-1]*arr[i-1];
			
		right[n-1] = 1;
		for(int i=n-2; i>=0; i--)
			right[i] = right[i+1]*arr[i+1];
			
		int[] prod = new int[n];
		for(int i=0; i<n; i++)
			prod[i] = left[i]*right[i];
		
		return prod;
	}
}
