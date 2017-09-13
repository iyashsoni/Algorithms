public class EditDistance{

    public static void main(String[] args){
        String str1 = "saturday";
        String str2 = "sunday";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int m = str1.length();
        int n = str2.length();
        int ans = calcEditDistance(arr1, arr2, m, n);
        System.out.println("Edit Distance of given sequences is "+ans);
    }
    
    static int calcEditDistance(char[] arr1, char[] arr2, int m, int n){
        
        int[][] ED = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0){
                    if(i == 0)
                       ED[i][j] = j;
                    else
                        ED[i][j] = i;
                }
                else if(arr1[i-1] == arr2[j-1])
                    ED[i][j] = ED[i-1][j-1];
                else
                    ED[i][j] = 1+min(ED[i-1][j],min(ED[i][j-1],ED[i-1][j-1]));
            }
        }    
        return ED[m][n];
    }
    
    static int min(int a, int b){
        return (a>b)?b:a;
    }
    
}
