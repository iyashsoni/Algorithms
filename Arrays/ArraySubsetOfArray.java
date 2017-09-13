import java.util.*;

public class ArraySubsetOfArray{

	public static void main(String[] args){
	
		int[] arr1 = {10, 5, 2, 23, 19}, arr2 = {19, 5, 3};
		if(calc(arr1, arr2) == 1)
			System.out.println("Yes, 2 is subset of 1");
		else
			System.out.println("No, 2 is not a subset of 1");
	}
	
	static int calc(int[] arr1, int[] arr2){
		int n = arr1.length;
		
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for(int i=0; i<n; i++){
			if(ht.containsKey(arr1[i]))
				ht.put(arr1[i], (Integer)ht.get(arr1[i])+1);
			else
				ht.put(arr1[i], 1);
		}
		
		/*for(Map.Entry m : ht.entrySet()){  
			System.out.println(m.getKey()+" "+m.getValue());  
		}  */
		
		n = arr2.length;
		for(int i=0; i<n; i++){
			if(ht.containsKey(arr2[i]) && !ht.get(arr1[i]).equals(Integer.valueOf(0)))
				ht.put(arr2[i], (Integer)ht.get(arr1[i])-1);
			else
				return 0;
		}
		
		return 1;
	}
}
