public class IsFoldable{

    public static void main(String[] args){
    
        Node root = new Node(1);  
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        
        if(isFoldable(root))
            System.out.println("Yes, foldable");
        else
            System.out.println("No");
    }
    
    static boolean isFoldable(Node node){
        mirror(node.left);
        boolean ans = isStructSame(node.left, node.right);
        mirror(node.left);
        return ans;
    }
    
    static boolean isStructSame(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 != null && node2 != null && isStructSame(node1.left, node2.left) && isStructSame(node1.right, node2.right))
            return true;
        else
            return false;
    }
    
    static void mirror(Node node){
        if(node == null)
            return;
            
        mirror(node.left);
        mirror(node.right);
        
        Node n = node.left;
        node.left = node.right;
        node.right = n;   
    }
    
    static int search(int[] in, int start, int end, int key){
        int i;
        for(i=start; i<=end; i++)
            if(in[i] == key)
                return i;
        return i;
    }
    
    static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
    static void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
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
