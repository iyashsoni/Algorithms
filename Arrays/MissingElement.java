import java.util.*;

public class MissingElement{

	public static void main(String[] args){
	
		int[] arr1 = {10, 12, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1};
        int[] arr2 = {10, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1};
		int n1 = arr1.length;
		int n2 = arr2.length;
		calc(arr1, arr2, n1, n2);
	}
	
	static void calc(int[] arr1, int[] arr2, int n1, int n2){
	
		int xor=0;
		
		for(int i=0; i<n1; i++){
			xor = xor^arr1[i]; 		
		}
		
		for(int i=0; i<n2; i++){
			xor = xor^arr2[i]; 		
		}
		
		System.out.println(xor);
	}
}

