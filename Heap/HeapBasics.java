class HeapBasics{
    
    public static void main(String[] args){
        
        MinHeap mh =new MinHeap(11);
        mh.insertKey(3);
        mh.insertKey(2);
        mh.print();
        mh.deleteKey(1);
        mh.print();
        mh.insertKey(15);
        mh.insertKey(5);
        mh.insertKey(4);
        mh.insertKey(45);
        mh.print();
        System.out.println("Extract min: "+mh.extractMin());
        System.out.println("Get min: "+mh.getMin());
        mh.decreaseKey(2,1);
        mh.print();
        System.out.println("Get min: "+mh.getMin());
    }
}

class MinHeap{
    
    int[] arr;
    int heap_size;    
    MinHeap(int cap){
        arr = new int[cap];
        heap_size = 0;
    }
    
    int parent(int i){
        return (i-1)/2;
    }
    
    int lChild(int i){
        return 2*i + 1;
    }
    
    int rChild(int i){
        return 2*i + 2;
    }
    
    int getMin(){
        return arr[0];
    }
    
    int extractMin(){
        //Base cases
        if(heap_size == 0)
            return Integer.MAX_VALUE;
        if(heap_size == 1){
            heap_size--;
            return arr[0];
        }
        
        int temp = arr[0];
        arr[0] = arr[heap_size -1];
        heap_size--;
        minHeapify(0);
        return temp;
    }
    
    void decreaseKey(int i, int newVal){
        arr[i] = newVal;
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(i,parent(i));
            i = parent(i);
        }
    }
    
    void deleteKey(int i){
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }
    
    void insertKey(int key){
        if(heap_size == arr.length){
            System.out.println("FULL");
            return;
        }
        
        heap_size++;
        int i = heap_size-1;
        arr[i] = key;
        System.out.println("Inserted key: "+key);
        while(i != 0 && arr[parent(i)] > arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    void minHeapify(int i){
        int l = lChild(i);
        int r = rChild(i);
        int smallest = i;
        
        if(l<heap_size && arr[l] < arr[i])
            smallest = l;
        if(r<heap_size && arr[r] < arr[smallest])
            smallest = r;
        if(smallest != i){
            swap(i,smallest);
            minHeapify(smallest);
        }
    }
    
    void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void print(){
        for(int i=0; i<heap_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
