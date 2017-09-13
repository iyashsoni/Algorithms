public class BinaryKnapsack{
    
    public static void main(String[] args){
        int W = 50;
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int ans = calcMaxProfit(W, wt, val, val.length);
        System.out.println("Max Profit is "+ans); 
    }
    
    static int calcMaxProfit(int W, int[] wt, int[] val, int len){
        int[][] MP = new int[len+1][W+1];
        
        for(int i=0; i<=len; i++){
            for(int j=0; j< W+1; j++){
                if(i == 0 || j == 0)
                    MP[i][j] = 0;
                else if(j >= wt[i-1])
                    MP[i][j] = max(val[i-1] + MP[i-1][j-wt[i-1]], MP[i-1][j]);
                else
                    MP[i][j] = MP[i-1][j];
            }
        }    
        
        return MP[len][W];
    }
    
    static int max(int a, int b){   return (a<b)?b:a;    }
}
