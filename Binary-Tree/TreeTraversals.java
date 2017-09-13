import java.util.LinkedList;

public class TreeTraversals{

    public static void main(String[] args){
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        
        System.out.println("In order: ");
        inOrder(root);
        System.out.println("\nPre order: ");
        preOrder(root);
        System.out.println("\nPost order: ");
        postOrder(root);
        System.out.println("\nLevel order: ");
        levelOrder(root);
        System.out.println("\nLevel order line by line: ");
        printLevelOrder(root);
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
    
    static void postOrder(Node root){
         if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);   
        System.out.print(root.data+" ");
    }
    
    static void levelOrder(Node root){
        Queue q = new Queue();
        q.enqueue(root);
        while(!q.isEmpty()){
            Node temp = q.dequeue();
            System.out.print(temp.data+" ");
            if(temp.left != null)
                q.enqueue(temp.left);
            if(temp.right != null)
                q.enqueue(temp.right);
        }
        System.out.println();
    }
    
    static void printLevelOrder(Node root){
        int h = height(root);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    
    static int height(Node root){
        if (root == null)
           return 0;
        else{ 
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            if (lheight > rheight)
                return(lheight+1);
            else 
                return(rheight+1); 
        }
    }
 
    static void printGivenLevel(Node root ,int level){
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
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

class Queue{
    private LinkedList<Node> list;
	
	public Queue(){
		list = new LinkedList();
	}

	public boolean isEmpty(){
		return (list.size() == 0);
	}

	public void enqueue(Node item){
		list.add(item);
	}

	public Node dequeue(){
		Node item = list.get(0);
		list.remove(0);
		return item;
	}

	public Node peek(){
		return list.get(0);
	}
}
