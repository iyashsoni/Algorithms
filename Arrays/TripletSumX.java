import java.util.*;

public class TripletSumX{
	
	public static void main(String[] args){
	
		int[] arr = {1, 4, 45, 6, 10, 8};
		int x = 21;
		calc(arr, x);
	}
	
	static void calc(int[] arr, int sum){
	
		Arrays.sort(arr);
		int n = arr.length;
		int l, r;
		for(int i=0; i<n-2; i++){
			l = i+1;
			r = n-1;
			while(l<r){
				
				if(arr[i] + arr[l] + arr[r] == sum){
					System.out.println("Three numbers are: "+arr[i]+", "+arr[l]+" & "+arr[r]);
					return;
				}
				else if(arr[i] + arr[l] + arr[r] < sum)
					l++;
				else
					r--;
			}
		}
		System.out.println("No triplet found!");		
	}
}
