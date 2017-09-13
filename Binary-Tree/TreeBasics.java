    import java.util.LinkedList;

public class TreeBasics{
    static int ltr = 0;
    public static void main(String[] args){
    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
                
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        
        
        if(isIdentical(root, root1))
            System.out.println("Yes, identical...");
        else
            System.out.println("No, not identical...");
            
        System.out.println("Size of Tree 1: "+sizeOfTree(root));
        System.out.println("Size of Tree 2: "+sizeOfTree(root1));  
     
       /* deleteTree(root1);
        root1 = null;*/
        
        System.out.println("Height of Tree 1: "+heightOfTree(root));
        System.out.println("Height of Tree 2: "+heightOfTree(root1));  
     
        preOrder(root);
        System.out.println();
        mirrorTree(root);
        preOrder(root);
        
        System.out.println();
        System.out.println("Leaf Nodes: "+getLeafNodes(root));
     /*   System.out.println("In order: ");
        inOrder(root);
        System.out.println("\nPre order: ");
        preOrder(root);
        System.out.println("\nPost order: ");
        postOrder(root);
        System.out.println("\nLevel order: ");
        levelOrder(root);*/
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
        int h = heightOfTree(root);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
            ltr = (ltr==1)?0:1;
            System.out.println();
        }
    }
 
    static void printGivenLevel(Node root ,int level){
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1){
            if(ltr == 0){
                printGivenLevel(root.right, level-1);
                printGivenLevel(root.left, level-1);
            }
            else{
                printGivenLevel(root.left, level-1);
                printGivenLevel(root.right, level-1);
            }
        }
    }
        
    static int sizeOfTree(Node root){
        if(root == null)
            return 0;
        
        return (sizeOfTree(root.left) + sizeOfTree(root.right) + 1);
    }
    
    static int getLeafNodes(Node root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else
            return (getLeafNodes(root.left) + getLeafNodes(root.right));
    }
    
    static boolean isIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        else if(root1 != null && root2 != null){
            if(root1.data != root2.data)
                return false;
            else
                return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
        }
        else
            return false;
    }
    
    static int heightOfTree(Node root){
        if(root == null)
            return 0;
        return max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
    
    static int max(int a, int b){
        return (a>b)?a:b;
    }
    
    static void deleteTree(Node root){
        if(root == null)
            return;
        
        deleteTree(root.left);
        deleteTree(root.right);
        System.out.println("Deleting "+root.data);
        root = null;
    }
    
    static void mirrorTree(Node root){
        if(root == null)
            return;
        mirrorTree(root.left);
        mirrorTree(root.right);
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
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
