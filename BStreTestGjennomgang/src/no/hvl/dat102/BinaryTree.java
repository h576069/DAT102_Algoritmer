package no.hvl.dat102;

public class BinaryTree {
	// Root of Binary Tree 
	Node root; 

	BinaryTree() 
	{ 
		root = null; 
	} 

	/* Given a binary tree, print its nodes according to the 
	"bottom-up" postorder traversal. */
	void printPostorder(Node node) 
	{ 
		if (node == null) 
			return; 

		// first recur on left subtree 
		printPostorder(node.left); 

		// then recur on right subtree 
		printPostorder(node.right); 

		// now deal with the node 
		System.out.print(node.key + " "); 
	} 

	/* Given a binary tree, print its nodes in inorder*/
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.left); 

		/* then print the data of node */
		System.out.print(node.key + " "); 

		/* now recur on right child */
		printInorder(node.right); 
	}

	/* Given a binary tree, print its nodes in preorder*/
	void printPreorder(Node node) { 
		if (node == null) 
			return; 

		/* first print data of node */
		System.out.print(node.key + " "); 

		/* then recur on left sutree */
		printPreorder(node.left); 

		/* now recur on right subtree */
		printPreorder(node.right); 
	}

	// Wrappers over above recursive functions 
	void printPostorder1() {	 printPostorder(root); } 
	void printInorder1() {	 printInorder(root); } 
	void printPreorder1() {	 printPreorder(root); } 

	// Driver method 
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		/*
		 * i)
		 */
//		tree.root = new Node("i"); 
//		tree.root.left = new Node("E"); 
//		tree.root.right = new Node("n"); 
//		tree.root.left.left = new Node("s"); 
//		tree.root.left.right = new Node("t"); 
//		tree.root.right.left = new Node("O");
//		tree.root.right.right = new Node("r");
//		tree.root.left.left.left = new Node("b");
//		tree.root.left.left.right = new Node("å");
//		tree.root.left.right.left = new Node("t");
		
		/*
		 * ii)
		 */
		tree.root = new Node("i"); 
		tree.root.left = new Node("e");
		tree.root.right = new Node("N"); 
		tree.root.left.right = new Node("s"); 
		tree.root.left.right.left = new Node("O");
		tree.root.left.right.left.left = new Node("t");
		tree.root.left.right.right = new Node("r");
		tree.root.right.right = new Node("t");
		tree.root.right.right.left = new Node("b");
		tree.root.right.right.right = new Node("å");

		System.out.println("Preorder traversal of binary tree is "); 
		tree.printPreorder1();

		System.out.println("\nInorder traversal of binary tree is "); 
		tree.printInorder1(); 

		System.out.println("\nPostorder traversal of binary tree is "); 
		tree.printPostorder1(); 
	}
} 
