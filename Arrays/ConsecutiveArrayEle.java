
public class ConsecutiveArrayEle{

	public static void main(String[] args){
		
		int[] arr = {7, 6, 5, 5, 3, 4};		
		System.out.println(isConsecutive(arr));
	}
	
	static boolean isConsecutive(int[] arr){
		
		int n = arr.length;
		int min = arr[0], max = arr[0];
		for(int i=1; i<n; i++){
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		int range = max - min + 1;
		
		if(range != n)
			return false;
		
		int[] visited = new int[n];
		for(int i=0; i<n; i++)
			if(visited[arr[i]-min] != 1)
				visited[arr[i]-min] = 1;
			else
				return false;
		
		return true;
	}
}
