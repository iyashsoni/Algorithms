public class IsSubTree{

    public static void main(String[] args){
    
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
 
        Node st = new Node(3);
        st.right = new Node(3);
        
        if(isSubTree(root, st))
            System.out.println("yes its a subtree");
        else
            System.out.println("not a subtree");
    }
    
    static boolean areIdentical(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (node1.data == node2.data && areIdentical(node1.left, node2.left) && areIdentical(node1.right, node2.right));
    }
    
    static boolean isSubTree(Node root, Node st){
        
        if(st == null)
            return true;
        if(root == null)
            return false;
        if(areIdentical(root, st))
            return true;
        return isSubTree(root.left, st) || isSubTree(root.right, st);
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
