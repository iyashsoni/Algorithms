public class MinMergePalin{

	public static void main(String[] args){
		int[] arr = {11, 14, 15, 99};
		int ans = calc(arr);	
		System.out.println(ans);
	}
	
	static int calc(int[] arr){
	
		int cnt = 0;
		for(int i=0,j=arr.length-1; i<=j;){
			if(arr[i] == arr[j]){
				i++;
				j--;
			}
		
			else if(arr[i] < arr[j]){
				arr[i+1] += arr[i];
				i++;
				cnt++;
			}
		
			else{
				arr[j-1] += arr[j];
				j--;
				cnt++;
			}
		}
		return cnt;
	}
}
