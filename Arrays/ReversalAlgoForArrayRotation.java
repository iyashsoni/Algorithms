public class ReversalAlgoForArrayRotation
{
	static int[] a;
	public static void main(String[] args)
	{
		a = new int[6];
		
		for(int i=0; i<6; i++){
			a[i] = i;	
		}
		
		rotate(a,2);
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");	
		}
	}
	
	public static void rotate(int[] a, int d){
		reverse(a,0,d-1);
		reverse(a,d,a.length-1);
		reverse(a,0,a.length-1);
	}
	
	public static void reverse(int[] a, int start, int end){
		int temp;
		while(start<end){
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
}
