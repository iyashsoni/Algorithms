
/*

Building a Tree using in-order and pre-order
Building a double Tree
Printing nodes at k-distance from root
Printing the width of the tree i.e. maximum number of nodes on any level
*/

public class TreeConstruction{

    static int[] in = {4, 2, 5, 1, 6, 3};
    static int[] pre = {1, 2, 4, 5, 3, 6};
    static int preindex = 0, max = 0;
    static int[] width = new int[100];
    
    public static void main(String[] args){
    
        Node root = buildTree(in, pre, 0, in.length -1);  
        
        System.out.println("In order: ");
        inOrder(root);
        System.out.println("\nPre order: ");
        preOrder(root);
        
        doubleTree(root);
        
        System.out.println("In order: ");
        inOrder(root);
        System.out.println("\nPre order: ");
        preOrder(root);
        
        System.out.println();
        printNodesAtKDistance(root,2);
        System.out.println();
        
        getTreeWidth(root);
    }
    
    static void printNodesAtKDistance(Node node, int k){
        if(node == null)
            return;
        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }
        else{
            printNodesAtKDistance(node.left,k-1);
            printNodesAtKDistance(node.right,k-1);
        }
    }
    
    static void getTreeWidth(Node node){
        widthAtAllLevels(node,0);
        System.out.println("Max width is " + max);
    }
     
    static void widthAtAllLevels(Node node, int k){
        if(node == null)
            return;
        width[k]++; 
        if(width[k] > max)
            max = width[k];
        if(node.left != null)
            widthAtAllLevels(node.left, k+1);
    
        if(node.right != null)
            widthAtAllLevels(node.right, k+1);
    }
    
    
    static Node buildTree(int[] in, int[] pre, int start, int end){
        if (start > end) {
            return null;
        }
        
        Node node = new Node(pre[preindex++]);
        if(start == end)
            return node;
        
        int index = search(in, start, end, node.data);
        node.left = buildTree(in, pre, start, index-1);
        node.right = buildTree(in, pre, index+1, end);
        return node;
    }
    
    static void doubleTree(Node node){
        if(node == null)
            return;
        doubleTree(node.left);
        doubleTree(node.right);
        
        Node n = new Node(node.data);
        n.left = node.left;
        node.left = n;   
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
