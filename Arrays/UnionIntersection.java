public class UnionIntersection{

	public static void main(String[] args){
		
		int[] arr1 = {1, 3, 4, 5, 7};
		int[] arr2 = {2, 3, 5, 6};
		callUnion(arr1,arr2);
		callIntersection(arr1,arr2);
	}
	
	static void callUnion(int[] arr1, int[] arr2){
		
		int m = arr1.length;
		int n = arr2.length;
		int i,j;
		for(i=0,j=0; i<m && j<n;){
			if(arr1[i] < arr2[j])
				System.out.print(arr1[i++]+" ");
			else if(arr1[i] > arr2[j])
				System.out.print(arr2[j++]+" ");
			else{
				System.out.print(arr2[j++]+" ");
				i++;	
			}
		}
		
		while(i<m)
			System.out.print(arr1[i++]+" ");
		while(j<n)
			System.out.print(arr2[j++]+" ");
			
		System.out.println();		
	}
	
	static void callIntersection(int[] arr1, int[] arr2){
		
		int m = arr1.length;
		int n = arr2.length;
		
		for(int i=0,j=0; i<m && j<n;){
			if(arr1[i] < arr2[j])
				i++;
			else if(arr1[i] > arr2[j])
				j++;
			else{
				System.out.print(arr2[j++]+" ");
				i++;	
			}
		}
		System.out.println();
	}
}
