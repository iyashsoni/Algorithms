public class Leaders{

	public static void main(String[] args){
		
		int[] a = {5,  5, 10, 40, 50, 35};
		findAndPrintLeaders(a);
	}
	
	static void findAndPrintLeaders(int[] a){
	
		int temp;
		int i = a.length-1;
		temp = a[i];
		System.out.print(temp+" ");
		i--;
		
		while(i >= 0){
			if(temp < a[i]){
				temp = a[i];
				System.out.print(temp+" ");		
			}
			i--;
		}
	}
}
