public class PrintAncestors{

    public static void main(String[] args){
    
        Node root = new Node(1);  
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        
        printAllAncestors(root,7);
    }
    
    static void printAllAncestors(Node node, int key){
        if(isNodeAncestor(node, key))
            System.out.print("\n");
        else
            System.out.print("Node not in tree\n");
    }
    
    static boolean isNodeAncestor(Node node, int key){
        if(node == null)
            return false;
        if(node.data == key)
            return true;
        if(isNodeAncestor(node.left, key) || isNodeAncestor(node.right, key)){
            System.out.print(node.data+" ");
            return true;
        }
        return false;
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
