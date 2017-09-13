import java.util.*;

public class RearrangeArrInMaxMin{

	public static void main(String[] args){
		
		int[] arr = {1,2,3,4,5,6};
		int[] ans = calc(arr); 

		int n = arr.length;		
		for(int i=0; i<n; i++){
			System.out.print(ans[i]+" ");
		}
	}

	static int[] calc(int[] arr){

		int n = arr.length;
		int[] temp = new int[n];
		int j = 0;
		for(int i=1; i<n; i=i+2,j++){
			temp[i] = arr[j];
		}
		int k = n-1;
		for(int i=0; i<n; i=i+2,k--){
			if(k<j)
				break;
			temp[i] = arr[k];
		}
		return temp;
	}
}
