public class LIS{

    public static void main(String[] args){
        int[] arr = {1, 8, 3 ,5, 2, 7, 4, 10};
        int ans = calcLIS(arr);
        System.out.println("LIS of given sequence is "+ans);
    }
    
    static int calcLIS(int[] arr){
        int len =arr.length;
        int[] LIS = new int[len];
        for(int i=0; i<len; i++)
            LIS[i] = 1;
            
        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }    
        return LIS[len-1];
    }
}
