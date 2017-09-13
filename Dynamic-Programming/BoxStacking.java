import java.util.*;

public class BoxStacking{
	public static void main(String[] args){
		Box[] arr ={new Box(1,2,3), new Box(4,5,6), new Box(4,6,7), new Box(10,12,32)};
		int n = arr.length;
		for(int i=0; i<n; i++)
			System.out.println("h: "+arr[i].h+" d: "+arr[i].d+" w: "+arr[i].w);
		
		calcMaxHeightOfStack(arr);
	}
	
	static int max(int a, int b){	return (a>b)?a:b;	}

	static int min(int a, int b){	return (a<b)?a:b;	}

	static void calcMaxHeightOfStack(Box[] arr){
		int n = arr.length, x = 0;
		Box[] rotArr = new Box[n * 3];
	
		System.out.println("In function:\n\n");
		for(int i=0; i<n; i++){
			Box temp = arr[i];
			
			rotArr[x] = temp;
			
			rotArr[x+1].h = temp.w;
			rotArr[x+1].d = max(temp.h, temp.d);
			rotArr[x+1].w = min(temp.h, temp.d);
			
			rotArr[x+2].h = temp.d;
			rotArr[x+2].d = max(temp.h, temp.w);
			rotArr[x+2].w = min(temp.h, temp.w);
		}
		
		Arrays.sort(rotArr, new MyCompBox());
		int len = 3*n;
		int[] maxHeight = new int[len];
		
		for(int i=0; i<len; i++)
			maxHeight[i] = rotArr[i].h;
		
		for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(rotArr[i].w < rotArr[j].w && rotArr[i].d < rotArr[j].d && maxHeight[i] < maxHeight[j] + rotArr[i].h)
                    maxHeight[i] = maxHeight[j] + rotArr[i].h;
            }
        } 
        
    	int max = maxHeight[0];
        for(int i=1; i<len; i++)
			if(maxHeight[i] > max)
				max = maxHeight[i];
				
		System.out.println(max);
	}
}

class Box{
	int h,d,w;
	Box(int a, int b, int c){
		h = a;
		d = b;
		w = c;
	}
}

class MyCompBox implements Comparator<Box>{
	public int compare(Box b1, Box b2){
		return (b2.d*b2.w - b1.d*b1.w);
	}
}
