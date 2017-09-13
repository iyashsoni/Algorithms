import java.lang.*;

public class EleAsIndexAndMarkVisited{

	public static void main(String[] args){
	
		int[] arr = {4, 3, 6, 2, 1, 1};
		calc(arr);
	}
	
	static void calc(int[] arr){
		int n = arr.length;
		
		for(int i=0; i<n; i++){
			if(arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			else 
				System.out.println("Repeated: "+Math.abs(arr[i]));
		}
		
		for(int i=0; i<n; i++){
			if(arr[i] > 0)
				System.out.println("Missing: "+(i+1));
		}
		
	}
} 
