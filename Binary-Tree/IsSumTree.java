public class IsSumTree{

    public static void main(String[] args){
    
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
 
        if(isSumTree(root) == 1)
            System.out.println("Yes, is Sum Tree");
        else
            System.out.println("No");
    }
    
    static int sum(Node node){
        if(node == null)
            return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }
    
    static int isSumTree(Node node){
        if(node == null || (node.left == null && node.right == null))
            return 1;
        int ls,rs;
        ls = sum(node.left);
        rs = sum(node.right);
 
        if(node.data == (ls + rs) && isSumTree(node.left)!=0 && isSumTree(node.right)!=0)
            return 1;
        return 0;
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
