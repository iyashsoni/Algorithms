public class Sort012{

	static int[] arr
	public static void main(String[] args){
		
		arr = {0,1,0,2,2,1,1,1,2};
		arr = sort(arr);
		printArr(arr);
	}
	
	static void printArr(int[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	static int[] sort(int[] arr){
		
		int n = arr.length;
		int l=0,mid=0,h=n-1;

		while(mid<=h){
		
			switch(a[mid]){
				
				case 0:
					swap(arr,l,mid);
					l++;
					mid++;
					break;
				
				case 1:
					mid++;
					break;
					
				case 2:
					swap(arr,mid,h);
					h--;
					break;
			}
		}
		return arr;
	}
}
