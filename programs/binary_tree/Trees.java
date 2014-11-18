package binary_tree;


/**
 * @author ankugarg
 * 							*********DO NOT AUTO INDENT THIS FILE, AS IT CONTAINS TREE DIAGRAMS********* 
 */
public class Trees {

	private StringBuilder preOrder;
	private StringBuilder inOrder;
	private StringBuilder postOrder;
	
	public Trees(){
		preOrder = new StringBuilder();
		inOrder = new StringBuilder();
		postOrder = new StringBuilder();
	}
	
	/**
	 * TC : O(n)
	 * @question: Given a binary tree and two level numbers ‘low’ and ‘high’,
	 *            print nodes from level low to level high.
	 * 
	 *            For example[/Algorithms/tree_samples/binary_search_tree.gif]
	 *            consider the binary tree given in below diagram.
	 * 
	 *            Input: Root of below tree, low = 2, high = 4
	 * 
	 *            Output: 8 22 4 12 10 14<>
	 * @param n
	 * @param low
	 * @param high
	 * 
	 *            implement below function to return list of nodes that fall
	 *            between specified low-high level
	 */
	public static java.util.List<Node> printNodesBetweenLevels(Node n, int low,
			int high) {
		return null;
	}
	
	/**
	 * TC : O(n)
	 * SC : O(n)
	 * @question: A given array represents a tree in such a way that the array
	 *            value gives the parent node of that particular index. The
	 *            value of the root node index would always be -1. Find the
	 *            height of the tree. Height of a Binary Tree is number of nodes
	 *            on the path from root to the deepest leaf node, the number
	 *            includes both root and leaf.
	 * 
	 *            Input: parent[] = {1 5 5 2 2 -1 3} Output: 4
	 *            The given array represents following Binary Tree 
         5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 
        
        Input: parent[] = {-1, 0, 0, 1, 1, 3, 5};
Output: 5
The given array represents following Binary Tree 
         0
       /   \
      1     2
     / \
    3   4
   /
  5 
 /
6
	 */
	public static int heightOfTreeUsingParentArray(int[] parent){
		int height = 0;
		return height;
	}

	/**
	 * TC : O(n) 
	 * SC : O(n)
	 * @param n
	 * @return
	 * @question Given a Binary Tree where every node has following structure.

struct node {  
    int key; 
    struct node *left,*right,*random;
} 
The random pointer points to any random node of the binary tree and can even point to NULL, clone the given binary tree.
	 */
	public static Node cloneTreeWithRandomPointer(Node n){
		return null;
	}
	
	/**
	 * @param t
	 * @param a
	 * @param b
	 * @return
	 * @question
	 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.

Two nodes are cousins of each other if they are at same level and have different parents.

Example

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.
	 */
	public static boolean areCousins(Node t, Node a, Node b){
		if(t == null || a == null || b == null)
			return false;
		Integer aLevel = getLevel(t, a);
		Integer bLevel = getLevel(t, b);
		if(aLevel.compareTo(bLevel) != 0){
			return false;
		}
		return ! areSiblings(t, a, b);
	}
	
	/**
	 * 
	 * @param t : Big/parent tree who is compared against
	 * @param s : small tree which is checked to be as a subtree of 't'
	 * @return
	 * @question: Check if a binary tree is subtree of another binary tree
	 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.

The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.

For example, in the following case, Tree1 is a subtree of Tree2.


        Tree1
          x 
        /    \
      a       b
       \
        c


        Tree2
              z
            /   \
          x      e
        /    \     \
      a       b      k
       \
        c
	 */
	public static boolean isSubtree(Node t, Node s){
		//there are two implementations for checking subtree
		
		//APPROACH - I
		//generate pre-order and in-order for both tree and check whether 't' contains 's'
		// this approach has TC : O(n)
		return checkSubtreeByOrder(t, s);
		
		//APPROACH - II
		//find the occurrence of root node of 's' in 't', then compare each element of both the trees
		// this approach has TC : O(n^2)
		//checkSubtreeByComparsion(t, s);
	}
	
	/**
	 * TC : O(n), if contains takes O(n) which can be achieved via KMP Algorithm 
	 * @param t
	 * @param s
	 * @return
	 */
	public static boolean checkSubtreeByOrder(Node t, Node s){
		if(s == null)	return true;
		if(t == null)	return false;

		Trees tree = new Trees();
		String tPreOrder = tree.getPreOrder(t).toString();
		tree.preOrder = new StringBuilder();
		String sPreOrder = tree.getPreOrder(s).toString();
		
		if(!tPreOrder.contains(sPreOrder)){
			return false;
		}
		
		String tInOrder = tree.getInOrder(t).toString();
		tree.inOrder = new StringBuilder();
		String sInOrder = tree.getInOrder(s).toString();
		return tInOrder.contains(sInOrder);
	}
	public StringBuilder getPreOrder(Node n) {
		if (n == null) {
			return new StringBuilder();
		}
		preOrder.append(n.toString()).append(" ");
		if (n.hasLeftChild()) {
			getPreOrder(n.leftChild);
		}
		if (n.hasRightChild()) {
			getPreOrder(n.rightChild);
		}
		return preOrder;
	}

	public StringBuilder getInOrder(Node n) {
		if (n == null) {
			return new StringBuilder();
		}
		if (n.hasLeftChild()) {
			getInOrder(n.leftChild);
		}
		inOrder.append(n.toString()).append(" ");
		if (n.hasRightChild()) {
			getInOrder(n.rightChild);
		}
		return inOrder;
	}

	public StringBuilder getPostOrder(Node n) {
		if (n == null) {
			return new StringBuilder();
		}
		if (n.hasLeftChild()) {
			getPostOrder(n.leftChild);
		}
		if (n.hasRightChild()) {
			getPostOrder(n.rightChild);
		}
		postOrder.append(n.toString()).append(" ");
		return postOrder;
	}

	
	private static boolean checkSubtreeByComparsion(Node t, Node s){
		if(s == null)	return true;
		if(t == null)	return false;
		return false;
	}

	/**
	 * TC : O(n)
	 * @param t is root node
	 * @param n is node whose level is to be calculated
	 * @return
	 * NOTE :: algorithm is unstable in case of multiple nodes having same data value 
	 */
	public static Integer getLevel(Node root, Node n){
		if(root == null || n == null){
			return 0;
		}
		if(n.level != null){
			return n.level;
		}
		return evaluateLevel(root, n, 1);
	}
	
	private static Integer evaluateLevel(Node root, Node n, Integer level){
		if(root == null){
			return 0;
		}
		//storing the level for upcoming nodes for future references
		root.level = level;
		if(root.compareTo(n) == 0){
			return level;
		}
		int l = evaluateLevel(root.leftChild, n, level + 1);
		if(l != 0){
			return l;
		}
		return evaluateLevel(root.rightChild, n, level + 1);
	}
	
	/**
	 * @param n
	 * @param hd MUST be passed
	 * and is always '0' for root node 
	 */
	public static void evaluateHorizontalDistance(Node n, Node minHD, Node maxHD, Integer hd){
		if(n == null)	return;
		n.horizontalDistance = hd;
		if(minHD.horizontalDistance > n.horizontalDistance){
			minHD = n;
		}
		if(maxHD.horizontalDistance < n.horizontalDistance){
			maxHD = n;
		}
		evaluateHorizontalDistance(n.leftChild, minHD, maxHD, hd - 1);
		evaluateHorizontalDistance(n.rightChild, minHD, maxHD, hd + 1);
	}
	
	public static boolean areSiblings(Node root, Node a, Node b){
		if(root == null || a == null || b == null){
			return false;
		}
		if( (a.compareTo(root.leftChild) == 0 && b.compareTo(root.rightChild) == 0)
			|| (b.compareTo(root.leftChild) == 0 && a.compareTo(root.rightChild) == 0)){
			return true;
		}
		return areSiblings(root.leftChild, a, b) || areSiblings(root.rightChild, a, b);
	}
	
	/**
	 * @param args
	 * sample trees:
	 * tree1         
		  5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 
        
     tree 2 
         0
       /   \
      1     2
     / \
    3   4
   /
  5 
 /
6        
	 */
	public static void main(String...args){
		Node t1 = new Node(5);
		t1.leftChild = new Node(1);
		t1.leftChild.leftChild = new Node(0);
		t1.rightChild = new Node(2);
		t1.rightChild.leftChild = new Node(3);
		t1.rightChild.leftChild.leftChild = new Node(6);
		t1.rightChild.rightChild = new Node(4);
		//TreeTraversal.inOrder(t1);
		Trees tree = new Trees();
		System.out.println("inorder : "+tree.getInOrder(t1)+", postorder : "+tree.getPostOrder(t1)+", preorder : "+tree.getPreOrder(t1));
		tree.preOrder = new StringBuilder();
		System.out.println("pre oder of subtree : " + tree.getPreOrder(t1.leftChild));
		System.out.println("test subtree : " + isSubtree(t1, t1.leftChild));
//		testAreSiblings(t1);
//		testLevel(t1);
//		testCousins(t1);
	}
	private static void testCousins(Node t1){
		System.out.println("areCousins 3,1: " + areCousins(t1, new Node(3), new Node(1)));
		System.out.println("areCousins 3,0: " + areCousins(t1, new Node(3), new Node(0)));
		System.out.println("areCousins 3,4: " + areCousins(t1, new Node(3), new Node(4)));
		System.out.println("areCousins 4,0: " + areCousins(t1, new Node(4), new Node(0)));
		System.out.println("areCousins 3,null: " + areCousins(t1, new Node(3), null));
	}
	
	private static void testLevel(Node t1){
		System.out.println("default level in new Node : " + new Node().level);
		System.out.println("level of 6 : " + getLevel(t1, new Node(6)));
		System.out.println("auto storage of levels for in between nodes : "+ t1.leftChild.leftChild.level);
		System.out.println("level of 3 : " + getLevel(t1, t1.rightChild.leftChild));
		System.out.println("level of 5 : " + getLevel(t1, new Node(5)));
		System.out.println("level of 6000 : " + getLevel(t1, new Node(6000)));
		System.out.println("level of null : " + getLevel(t1, null));
		System.out.println("level in null : " + getLevel(null, new Node(6)));
	}
	private static void testAreSiblings(Node t1){
		Node a = new Node(3);
		Node b = new Node(4);
		System.out.println("Node comparable test : " + a.compareTo(t1.rightChild.leftChild) + "," + b.compareTo(t1.rightChild.leftChild));
		System.out.println("Node comparable test : " + b.compareTo(t1.rightChild.rightChild) + "," + a.compareTo(t1.rightChild.rightChild));
		System.out.println("areSiblings 3,4: " + areSiblings(t1, a, b));
		System.out.println("areSiblings 3,null: " + areSiblings(t1, a, null));
		System.out.println("areSiblings 3,9: " + areSiblings(t1, a, new Node(9)));		
	}
}