public class KthLargest{
    
    public static void main(String[] args){
      int[] arr = {4,10,5,15,6,1};
      print(arr);  
      findKthLargest(arr,3);
    }
    
    // n is for keeping track of size of array to heapify
    static void minHeapify(int[] arr, int n, int i){
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        
        if(l<n && arr[l] < arr[i])
            smallest = l;
        if(r<n && arr[r] < arr[smallest])
            smallest = r;
        if(smallest != i){
            swap(arr, i,smallest);
            minHeapify(arr, n, smallest);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

	static int[] buildMinHeap(int[] arr, int k){
	    int[] minHeap = new int[k];
	    for (int i = 0; i < k; i++)
        	minHeap[i] = arr[i];
        	
	    for (int i = k / 2 - 1; i >= 0; i--)
        	minHeapify(minHeap, k, i);
        	
        return minHeap;
	}
	
    static void findKthLargest(int arr[], int k){
        int len = arr.length;
        int[] minHeap = buildMinHeap(arr, k);
        for (int i=k; i<len; i++){
            if(arr[i] > minHeap[0]){
            	int temp = minHeap[0];
            	minHeap[0] = arr[i];
            	arr[i] = temp;
            	minHeapify(minHeap, k, 0);
            }
        }
        print(minHeap);
    }
}
