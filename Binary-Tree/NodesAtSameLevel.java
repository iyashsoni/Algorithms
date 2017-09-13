import java.util.LinkedList;

public class NodesAtSameLevel{
    
    static Queue q = new Queue();
    public static void main(String[] args){
    
        Node root = new Node(1);  
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);
        
        levelOrderMain(root);
        printInPreorder(root);
    }
    
    static void levelOrderMain(Node node){
        node.level = 0;
        node.nextRight = null;
        q.enqueue(node);
    
        while(!q.isEmpty()){
            Node temp = q.dequeue();
            int level = temp.level;
            
            if(temp.left != null){
                temp.left.level = level + 1;
                q.enqueue(temp.left);
            }
            
            if(temp.right != null){
                temp.right.level = level + 1;
                q.enqueue(temp.right);
            }        
            
            if(!q.isEmpty() && level == q.peek().level)
                temp.nextRight = q.peek();
        }
    }
        x
    static void printInPreorder(Node node){
        if(node == null)
            return;
        if(node.nextRight != null)    
            System.out.println("Data is "+node.data+", Level is "+node.level+", nextRight is "+node.nextRight.data);
        else
            System.out.println("Data is "+node.data+", Level is "+node.level+", nextRight is NULL");
        printInPreorder(node.left);
        printInPreorder(node.right);
    }
}

class Node{
    int data, level;
    Node left, right, nextRight;
    
    Node(int key){
        data = key;
        right = null;
        left = null;
        nextRight = null;
    }
}

class Queue{
    LinkedList<Node> list;
    Queue(){
        list = new LinkedList<Node>();
    }
    
    void enqueue(Node n){
        list.add(n);
    }
    
    Node dequeue(){
        Node temp = list.remove(0);
        return temp;
    }
    
    Node peek(){
        Node temp = list.peek();
        return temp;
    }
    
    boolean isEmpty(){
        return (list.size() == 0);            
    }
}
