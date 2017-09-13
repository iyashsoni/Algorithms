public class MinNumStepsToGetDesiredArray{

	public static void main(String[] args){
	
		int[] arr = {2,3};
		int n = arr.length;
		calc(arr,n);
	}
	
	static void calc(int[] arr, int n){
	
		int zeroes, evens, oprn = 0;
		
		while(true){
			zeroes = 0;
			evens=0;
			for(int i=0; i<n; i++){
				if(arr[i] == 0)
					zeroes++;
				if(arr[i] % 2 ==0)
					evens++;
			}
			
			if(zeroes == n)
				break;
			
			if(evens == n){
				for(int i=0; i<n; i++){
					arr[i] /= 2;
				}
				oprn++;		
			}
			
			for(int i=0; i<n; i++){
				if(arr[i] % 2 == 1){
					arr[i] -= 1;
					oprn++;
				}
			}	
			
		}
		System.out.println(oprn);
	}
}

