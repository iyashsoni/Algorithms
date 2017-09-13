public class LPS{

    public static void main(String[] args){
        String str1 = "ABCDBA";
        String str2 = new StringBuffer(str1).reverse().toString();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int m = str1.length();
        int n = str2.length();
        int ans = calcLPSusingLCS(arr1, arr2, m, n);
        System.out.println("LPS of given sequences using LCS is "+ans);
        ans = calcLPS(arr1,m);
        System.out.println("LPS of given sequences is "+ans);
    }
    
    static int calcLPS(char[] arr, int n){
        
        int j;
        int[][] LPS = new int[n][n];
        for(int i=0; i<n; i++)
            LPS[i][i] = 1;
            
        for(int len=2; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                j = i+len-1;
                if(arr[i] == arr[j] && i == 2)
                    LPS[i][j] = 2;
                else if(arr[i] == arr[j])
                    LPS[i][j] = LPS[i+1][j-1] + 2;
                else
                    LPS[i][j] = max(LPS[i][j-1],LPS[i+1][j]);
            }
        }    
        
        return LPS[0][n-1];
    }
    
    static int calcLPSusingLCS(char[] arr1, char[] arr2, int m, int n){
        
        int[][] LPS = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0)
                    LPS[i][j] = 0;
                else if(arr1[i-1] == arr2[j-1])
                    LPS[i][j] = LPS[i-1][j-1] + 1;
                else
                    LPS[i][j] = max(LPS[i-1][j],LPS[i][j-1]);
            }
        }    
        return LPS[m][n];
    }
    
    static int max(int a, int b){
        return (a>b)?a:b;
    }
    
}
