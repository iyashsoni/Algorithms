public class MinCostPath{
    static int R = 3, C = 3;
    public static void main(String[] args){
        int[][] arr = {{1,2,3}, {4,8,2}, {1,5,3}};
        int ans = calcMinCostPath(arr);
        System.out.println("Minimum Cost Path for given matrix is "+ans);
    }
    
    static int calcMinCostPath(int[][] arr){
        
        int[][] MCP = new int[R][C];
        MCP[0][0] =arr[0][0];
        
        for(int i=1; i<R; i++)
            MCP[i][0] = MCP[i-1][0] + arr[i][0];
            
        for(int j=1; j<C; j++)
            MCP[0][j] = MCP[0][j-1] + arr[0][j];
            
        for(int i=1; i<R; i++){
            for(int j=1; j<C; j++)
               MCP[i][j] = arr[i][j] + min(MCP[i][j-1], min(MCP[i-1][j], MCP[i-1][j-1]));
        }            
        return MCP[R-1][C-1];
    }
    
    static int min(int a, int b){
        return (a>b)?b:a;
    }
    
}
