public class CoinChange{

//calculates number of ways to pay given sum using available coins

    public static void main(String[] args){
        int[] denominations = {2, 5, 3, 6};
        int N = 10;
        int ans = calcCoinChange(denominations, N);
        System.out.println("Coin Change is "+ans);
    }
    
    static int calcCoinChange(int[] denominations, int N){
        int len = denominations.length;
        int[][] CC = new int[len][N+1];
        
        for(int i=0; i<len; i++)
            CC[i][0] = 1;
            
        for(int i=0; i<N+1; i++)
            if(i%(denominations[0]) == 0)
               CC[0][i] = 1;
               
        for(int i=1; i<len; i++){
            for(int j=1; j<N+1; j++){
                if(denominations[i] <= j)
                    CC[i][j] = CC[i][j-denominations[i]] + CC[i-1][j];
                else
                    CC[i][j] = CC[i-1][j];
            }
        }
        
        return CC[len-1][N];
    }
}
