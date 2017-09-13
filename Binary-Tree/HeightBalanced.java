import java.util.LinkedList;
import java.lang.*;

public class HeightBalanced{
    static int ltr = 0;
    public static void main(String[] args){
    
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        root.right.right.left = new Node(17);
        
        if(isHeightBalanced(root) == 1)
            System.out.println("Yes, height balanced...");
        else
            System.out.println("Not height balanced...");
    }
    
    static int height(Node node){
        if(node == null)
            return 0;
        else{
            return (max(height(node.left),height(node.right)) + 1);
        }
    }
    
    static int max(int a, int b){
        return (a>b)?a:b;
    }
    
    static int isHeightBalanced(Node root){
        if(root == null || (root.left == null && root.right == null))
            return 1;
        else{
            if(isHeightBalanced(root.left) == 1 && isHeightBalanced(root.right) == 1 && Math.abs(height(root.left)-height(root.right)) <= 1)
                return 1;
            else
                return 0;
        }
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
