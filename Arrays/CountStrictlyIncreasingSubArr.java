import java.util.*;

public class CountStrictlyIncreasingSubArr{

	public static void main(String[] args){
		
		int[] arr = {1,2,10,7,8,3,6,4,5};
		int ans = calc(arr); 
		System.out.println(ans);
	}

	static int calc(int[] arr){
		int cnt = 0;
		int len = 1;
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			
			if(arr[i+1] > arr[i])
				len++;
			else{
				cnt += ((len - 1)*len)/2;
				len = 1;
			}
		}
		// on exit of loop, the last element "if it is increasing, then it is not added yet" so check and add to count
		if (len > 1)
        	cnt += ((len - 1)*len)/2;
		return cnt;
	}
}
