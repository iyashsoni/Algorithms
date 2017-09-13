public class LCS{

    public static void main(String[] args){
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int m = str1.length();
        int n = str2.length();
        int ans = calcLCS(arr1, arr2, m, n);
        System.out.println("LCS of given sequences is "+ans);
    }
    
    static int calcLCS(char[] arr1, char[] arr2, int m, int n){
        
        int[][] LCS = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0)
                    LCS[i][j] = 0;
                else if(arr1[i-1] == arr2[j-1])
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                else
                    LCS[i][j] = max(LCS[i-1][j],LCS[i][j-1]);
            }
        }    
        return LCS[m][n];
    }
    
    static int max(int a, int b){
        return (a>b)?a:b;
    }
    
}
