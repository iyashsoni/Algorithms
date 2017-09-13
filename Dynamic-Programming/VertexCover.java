public class VertexCover{
	public static void main(String[] args){
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.left.right.left = new Node(60);
		root.left.right.right = new Node(70);
		root.right.right = new Node(80);
		calcVC(root);
	}
	
	static void calcVC(Node root){
		root.vc = calcVCutil(root);
		System.out.println("Min Vertex Cover is "+root.vc);
	}
	
	static int calcVCutil(Node root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 0;
		if (root.vc != 0)
        	return root.vc;
        
		int incl = 1 + calcVCutil(root.left) + calcVCutil(root.right);
		int excl = 0;
		if(root.left != null)
			excl += 1 + calcVCutil(root.left.left) + calcVCutil(root.left.right);
		if(root.right != null)
			excl += 1 + calcVCutil(root.right.left) + calcVCutil(root.right.right);
			
		return (root.vc = min(incl, excl));
	}
	
	static int min(int a, int b){	return (a>b)?b:a;	}
}
class Node{
	int data;
	int vc;
	Node left, right;
	Node(int key){
		left = right = null;
		data = key;
		vc = 0;
	}
}
