import java.util.LinkedList;

public class InorderSuccessor{
    static Node next = null;
    public static void main(String[] args){
    
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        inOrderSuccessor(root);
        print(root);
    
    }
    
    static void inOrderSuccessor(Node root){
        if(root == null)
            return;
        inOrderSuccessor(root.right);
        root.next = next;
        next = root;
        inOrderSuccessor(root.left);
    }
    
    static void print(Node node){
        if(node == null)
            return;
        if(node.next != null)
            System.out.println("Inorder successor of "+node.data+" is "+node.next.data);
        else    
            System.out.println("Inorder successor of "+node.data+" is NULL");
        print(node.left);
        print(node.right);
    }
}

class Node{
    int data;
    Node left, right, next;
    
    Node(int key){
        data = key;
        right = null;
        left = null;
    }
}
