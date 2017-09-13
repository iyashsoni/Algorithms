import java.util.*;

public class MinLenUnsortedSubarray{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
    		int len = sc.nextInt();
    		int[] arr = new int[len];
    		for(int j=0; j<len; j++)
    		    arr[j] = sc.nextInt();
    		calc(arr);
	    }
	}
	
	static void calc(int[] arr){
		int n = arr.length;
		int temp,left,right,i,j;
		
		for(i=1; i<n; i++){
			if(arr[i] < arr[i-1])
				break;
		}
		
		temp = arr[i];
		for(j=i-2; j>=0; j--){
			if(arr[j] < temp)
				break;
		}
		left = j+1;
		
		for(i=n-2; i>=0; i--){
			if(arr[i] > arr[i+1])
				break;
		}
		temp = arr[i];
		
		for(j=i+2; j<n; j++){
			if(arr[j] > temp)
				break;
		}
		right = j-1;
		
		int min = arr[left], max = arr[left];
		for(i=left+1; i<=right; i++){
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(i=0; i<left; i++){
			if(arr[i] > min){
				left = i;
				break;
			}	
		}
		
		for(i=n-1; i>right; i--){
			if(arr[i] < max){
				right = i;
				break;
			}
		}
		
		System.out.println(left+" "+right);
	}
}