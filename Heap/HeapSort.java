public class HeapSort{
    
    public static void main(String[] args){
      int[] arr = {4,10,5,15,6,1};
      print(arr);  
      sort(arr,6);
      print(arr);  
    }
    
    // n is for keeping track of size of array to heapify
    static void maxHeapify(int[] arr, int n, int i){
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;
        
        if(l<n && arr[l] > arr[i])
            largest = l;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            swap(arr, i,largest);
            maxHeapify(arr, n, largest);
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

    static void sort(int arr[], int n){

		// this will create a maxHeap (Not necessarily sorted in decerasing order, but satisfies Max Heap property)
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);
        
        for (int i=n-1; i>=0; i--){
            swap(arr, 0, i);
            // note that the middle parameter that we are sending in maxHeapify 'i' is having current value (size - 1), so it won't affect the last element. So it is already in its correct position.
            maxHeapify(arr, i, 0);
        }
    }
}
