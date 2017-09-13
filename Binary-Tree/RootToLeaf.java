public class RootToLeaf{
    
    static int[] path;
    public static void main(String[] args){
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        
        printAllRootToLeafPaths(root);
        
        if(hasPathSum(root, 11))
            System.out.println("Yes, sum 6e..");
        else
            System.out.println("Nai la ander..");
            
        int key = 11;
        int ans = getLevelOfKey(root,0, key);
        if(ans >= 0) 
            System.out.println("Level of key "+ key +" is "+ans);
        else        
            System.out.println("Key not present in tree");
    }
    
    static int getLevelOfKey(Node node, int level, int key){
        if(node == null)
            return -1;
        if(node.data == key)
            return level;
        else{
            int temp1 = getLevelOfKey(node.left, level+1, key);
            int temp2 = getLevelOfKey(node.right, level+1, key);
            if(temp1 > 0)
               return temp1;
            return temp2; 
        } 
    }
    
    static boolean hasPathSum(Node node, int sum){
        if(node == null)
            return (sum == 0);
        else{
            boolean ans = false;
            if(sum-node.data == 0 && node.left == null && node.right == null)
                return true;
            if(node.left != null)
                ans = (hasPathSum(node.left, sum-node.data) || ans);
            if(node.right != null)
                ans = (hasPathSum(node.right, sum-node.data) || ans);
            return ans;
        }
    }
    
    static void printAllRootToLeafPaths(Node node){
        path = new int[100];
        recursivePrinting(node, path, 0);
    }
    
    static void recursivePrinting(Node node, int[] path, int pathLength){
        if(node == null)
            return;
        
        path[pathLength++] = node.data;
        if(node.left == null && node.right == null)
            printArr(path, pathLength);
        else{
            recursivePrinting(node.left, path, pathLength);
            recursivePrinting(node.right, path, pathLength);
        }
    }
    
    static void printArr(int[] arr, int len){
        for(int i=0; i<len; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

class Node{
    int data;
    Node left, right;
    
    Node(int key){
        data = key;
        right = null;
        left = null;
    }
}
