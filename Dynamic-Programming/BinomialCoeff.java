public class BinomialCoeff{
    
    public static void main(String[] args){
        int n = 5;
        int k = 2;
        int ans = calcBinomialCoeff(n,k);
        System.out.println("Binomial coefficient of n: "+n+" and k: "+k+" is "+ans); 
    }
    
    static int calcBinomialCoeff(int n, int k){
        int[][] BC = new int[n+1][k+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<= min(i,k); j++){
                if(j == 0 || j == i)
                    BC[i][j] = 1;
                else
                    BC[i][j] = BC[i-1][j-1] + BC[i-1][j];
            }
        }    
        
        return BC[n][k];
    }
    
    static int min(int a, int b){   return (a>b)?b:a;    }
}
