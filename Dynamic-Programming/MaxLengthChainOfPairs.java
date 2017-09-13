import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs{
	public static void main(String[] args){
		Pair[] arr = new Pair[5];
		arr[0] = new Pair(5, 24);
		arr[1] = new Pair(15, 28);
		arr[2] = new Pair(39, 60);
		arr[3] = new Pair(27, 40);
		arr[4] = new Pair(50, 90);
        System.out.println("maxLengthChainOfPairs: "+maxLengthChainOfPairs(arr));
	}
	
	static int maxLengthChainOfPairs(Pair[] arr){
	   	int len =arr.length;
       	int[] LIS = new int[len];
        for(int i=0; i<len; i++)
            LIS[i] = 1;
           
        Arrays.sort(arr, new MyComp()); 

        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[j].b < arr[i].a && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }    
        
        int max = LIS[0];
        for(int j=1; j<len; j++){
            if(LIS[j] > max)
                max = LIS[j];
        }
        return max;
    }
}

class Pair{
		int a, b;
		Pair(int x, int y){	a = x; b = y;}
}

class MyComp implements Comparator<Pair>{
	public int compare(Pair p1, Pair p2){
		return p1.a - p2.a;
	}
}
