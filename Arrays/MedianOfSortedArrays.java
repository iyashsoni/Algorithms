public class MedianOfSortedArrays{

	public static void main(String[] args){
		int[] arr1 = {1, 12, 15, 26, 38}, arr2 = {2, 13, 17, 30, 45};
		int ans = getMedian(arr1, 0, 4, arr2, 0, 4);
		System.out.println(ans);
	}
	static int max(int a, int b){	return (a>b)?a:b;	}
	
	static int min(int a, int b){	return (a>b)?b:a;	}
	
	static int getMedian(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2){
		int n = e1-s1+1;
		int m1, m2;
		
		if(n == 1)
			return (arr1[s1]+ arr2[s2]) / 2;
		if(n == 2)
			return (max(arr1[s1],arr2[s2]) + min(arr1[e1],arr2[e2])) / 2;
			
		m1 = median(arr1,s1,e1);
		m2 = median(arr2,s2,e2);
	
		if(m1 == m2)
			return m2;
		else if(m1 < m2){
			if(n%2 == 0)
				return getMedian(arr1, s1 + n/2 - 1, e1, arr2, s2, e2 - n/2 +1);
			return getMedian(arr1, s1 + n/2, e1, arr2, s2, e2 - n/2); 
		}
		else{
			if(n%2 == 0)
				return getMedian(arr1, s1, e1 - n/2 +1, arr2, s2 + n/2 - 1, e2);
			return getMedian(arr1, s1, e1 - n/2, arr2, s2 + n/2, e2); 
		}
	}
	
	static int median(int[] arr, int start, int end){
		int n = end - start + 1;
		if(n%2 == 0)
			return (arr[start + n/2] + arr[start + n/2 - 1])/2;
		else
			return arr[start + n/2];
	}
}
