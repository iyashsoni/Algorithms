import java.util.*;

public class MinDistanceBetweenTwoNumbers{

	public static void main(String[] args){
	
		int[] arr = {2, 5, 3, 5, 4, 4, 2, 3};
		int x = 3, y = 2;		
		System.out.println(calc(arr,x,y));
	}
	
	static int calc(int[] arr, int x, int y){
		int n = arr.length;
		int i,j,prev=0,min=Integer.MAX_VALUE;		
		for(i=0; i<n; i++){
			if(arr[i] == x || arr[i] == y){
				prev = i;
				break;	
			}		
		}
		
		for(j=i+1; j<n; j++){
			if(arr[j] == x || arr[j] == y){
				if(arr[j] != arr[prev] && min > (j-prev))
						min = j-prev;
				prev = j;	
			}
		}
		return min;
	}
}
