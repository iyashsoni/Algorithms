public class EggDrop{
    public static void main(String[] args){
        int n = 2; // eggs
        int k = 36; // floors
        int ans = minEggDroppings(n,k);
        System.out.println("Min Dropping trials required is "+ ans);
    }
    
    static int minEggDroppings(int n, int k){
        
        int[][] ED = new int[n+1][k+1];
        int res;
        
        for(int i=1; i<k+1; i++)
            ED[1][i] = 1;
            
        for(int i=0; i<n+1; i++){
            ED[i][0] = 0;
            ED[i][1] = 1;    
        }
        
        
        for(int i=2; i<n+1; i++){
            for(int j=2; j<k+1; j++){
                
                ED[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<j; x++){
                    res = 1 + max(ED[i-1][x-1], ED[i][j-x]);
                    if(res < ED[i][j])
                        ED[i][j] = res;
                }        
            }
        }
        
        return ED[n][k];
     }
    
    static int max(int a, int b){   return (a>b)?a:b;   }
}
