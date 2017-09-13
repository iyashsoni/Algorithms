public class LongestEvenLegthWithEqualSum{
	public static void main(String[] args){
		String str = "123123";
		int[] arr = toIntArray(str, str.length());
		calcLength(arr, arr.length);
	}
	static int[] toIntArray(String s, int n){
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(s.charAt(i)+"");
		}
		return arr;
	}
	static void calcLength(int[] arr, int n){
		
		int[][] sum = new int[n][n];
		int[] table = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++){
			sum[i][i] = arr[i];
		}
		
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				sum[i][j] = sum[i][j-1] + arr[j];
			}
		}
		
		
		//
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(sum[i][j]+"   ");
			}
			System.out.println();
		}
		//
		for(int Len=2; Len<=n; Len+=2){
			for(int i=0; i<n-Len+1; i++){
				int j = i+Len-1;
				if(Len == 2){
					if(arr[i] == arr[j] && max < Len)
						max = Len;
				}
				else{
					int mid = (i + j)/2;
					if(sum[i][mid] == sum[mid+1][j] && max < Len)
						max = Len;
				}
			}
		}
		System.out.println(max);
	}
	
}
