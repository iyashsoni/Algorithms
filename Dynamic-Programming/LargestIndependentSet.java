public class LargestIndependentSet{
	public static void main(String[] args){
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		calcLISS(root);
	}
	
	static void calcLISS(Node root){
		System.out.println(calcLISSutil(root));
	}
	
	static int calcLISSutil(Node root){
		if(root == null)
			return 0;
		if(root.liss > 0)
			return root.liss;
		if(root.left == null && root.right == null)
			return (root.liss = 1);
		
		int excl = calcLISSutil(root.left) + calcLISSutil(root.right);
		int incl = 1;
		
		if(root.left != null)
			incl += calcLISSutil(root.left.left) + calcLISSutil(root.left.right);
		if(root.right != null)
			incl += calcLISSutil(root.right.left) + calcLISSutil(root.right.right);
		
		return (root.liss = max(excl, incl));
	}
	
	static int max(int a, int b){	return (a>b)?a:b;	}
}

class Node{
	int data, liss;
	Node left, right;
	Node(int key){
		data = key;
		left = null;
		right = null;
		liss = 0;
	}
}
