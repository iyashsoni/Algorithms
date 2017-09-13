import java.util.LinkedList;

public class ChildrenSum{
    static int ltr = 0;
    public static void main(String[] args){
    
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        
        if(satisfiesChildrenSum(root) == 1)
            System.out.println("Yes, satisfies...");
        else
            System.out.println("No, not satisfies...");
       
    }
    
    static int satisfiesChildrenSum(Node root){
        int l = 0, r = 0;
        if(root == null || (root.left == null && root.right == null))
            return 1;
        else{
            if(root.left != null)
                l = root.left.data;
            
            if(root.right != null)
                r = root.right.data;
            
            if(root.data == (l+r) && satisfiesChildrenSum(root.left) != 0 && satisfiesChildrenSum(root.right) != 0)
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
