public class SmallestPositiveNumFromUnsortedArray{
	
	public static void main(String[] args){
		int[] arr = {2, 3, -7, 6, 8, 1, -10, 15};
		printArray(arr);
		find(arr);
	}
	
	static void find(int[] arr){
		int index = segregate(arr);
		findSmallestPositive(arr, index);
	}
	
	static int segregate(int[] arr){
		int i=0, j=arr.length-1, temp;
		while(i<j){
			while(arr[i]<0)
				i++;
			while(arr[j]>=0)
				j--;
				
			if(j < i)
				break;
			
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		
		 	System.out.println(arr[i] + " swapped with " + arr[j]);
			printArray(arr);
		}
		return i;
	}
	
	static void printArray(int[] arr) {
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	static void findSmallestPositive(int[] arr, int index){
		System.out.println(index + " is Index of positive start!");

		int n = arr.length;

		for(int i=index; i<n; i++){
			
			if((Math.abs(arr[i])) < n-index && arr[Math.abs(arr[i]) + index -1] > 0)
				arr[Math.abs(arr[i]) + index -1] = -arr[Math.abs(arr[i]) + index - 1];
		}
		
		for(int i=index; i<n; i++){
			if(arr[i] > 0){
				System.out.println("Smallest postive number is: "+(i+1-index));
				return;
			}
		}
		
		System.out.println("Smallest postive number is: "+(n+1-index));
	}
}
