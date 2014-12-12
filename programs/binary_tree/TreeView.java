package binary_tree;

import java.util.HashSet;
import java.util.TreeMap;

public class TreeView {

	/**
	 * @question: Top view of a binary tree is the set of nodes visible when the
	 *            tree is viewed from the top. Given a binary tree, print the
	 *            top view of it. The output nodes can be printed in any order.
	 *            Expected time complexity is O(n)
	 * 
	 *            A node x is there in output if x is the topmost node at its
	 *            horizontal distance. Horizontal distance of a child of a node
	 *            x is equal to horizontal distance of x minus 1, and that of
	 *            right child is horizontal distance of x plus 1.
	 *            
	 *   TC : O(n)
	 *   SC : O(n)
	 *   where n is number of node in tree
	 */
	public static void topViewUnordered(Node tree){
		java.util.HashSet<Integer> set = new HashSet<>();
		internalTopViewUnorder(tree, 0, set);
		
	}
	private static void internalTopViewUnorder(Node tree, Integer hd, java.util.HashSet<Integer> set){
		if(tree == null){
			return;
		}
		tree.horizontalDistance = hd;
		if(set.add(tree.horizontalDistance)){
			tree.displayNodeHD();
		}
		internalTopViewUnorder(tree.leftChild, hd - 1, set);
		internalTopViewUnorder(tree.rightChild, hd + 1, set);
	}

	public static void topViewOrdered(Node t) {
		//just like unordered, only change will be data structure, 
		//use TreeMap where key is HD, value is Node
		// then display the treemap
	}
	
	/**
	 * TC : Theta(2n) or O(n)
	 * SC : Theta(3n) or O(n) 
	 * @param tree
	 */
	public static void bottomView(Node tree){
		java.util.TreeMap<Integer, Node> table = new TreeMap<>();
		internalBottomView(tree, 0, 0, table);
		for(java.util.Map.Entry<Integer, Node> hdNode : table.entrySet()){
			hdNode.getValue().displayNodeHDLevel();
		}
	}
	private static void internalBottomView(Node tree, Integer level, Integer hd, java.util.TreeMap<Integer, Node> table){
		if(tree == null){
			return;
		}
		tree.horizontalDistance = hd;
		tree.level = level;
		if(table.containsKey(hd)){
			Node temp = table.get(hd);
			/*
			 * ASSUMPTION : if 2 nodes are at same level and horizontal distance 
			 * then display the Node that appears while traversing
			 */
			if(temp.level < tree.level){
				table.put(hd, tree);
			}
		}else{
			table.put(hd, tree);
		}
		internalBottomView(tree.leftChild, level + 1, hd - 1, table);
		internalBottomView(tree.rightChild, level + 1, hd + 1, table);
	}
	
	/**
	 * both right and left are similar, below method give left view of the tree
	 * @param tree
	 * TC : O(n)
	 * SC : O(n)
	 * where n is number of Node is tree
	 * 
	 * this function will print the Nodes that will be visible from left view.
	 * 
	 * Idea :
	 * assign the heights to the each node in Preorder
	 * for each node insert it's height into a hashset, 
	 * if height is already present, which means some Node
	 * with this height has already appeared on the left side from this node, 
	 * so this node will not visible from left side, there by not printing.
	 * other wise if the height is not present in hashset then print that node because
	 * this node is first node to be visible in this height.
	 */
	public static void sideView(Node tree){
		java.util.HashSet<Integer> set = new HashSet<Integer>();
		internalSideView(tree, 0, set);
	}
	
 	private static void internalSideView(Node tree, int level, java.util.HashSet<Integer> set){
		if(tree == null){
			return;
		}
		tree.level = level;
		if(set.add(tree.level)){
			tree.displayNodeLevel();
		}
		internalSideView(tree.leftChild, level + 1, set);
		internalSideView(tree.rightChild, level + 1, set);
	}
	
	
	public static void main(String...args){
		testSideView();
		testTopViewUnorder();
		testBottomView();
	}
	private static void testBottomView(){
		Node tree = new Node(10);
		tree.rightChild = new Node(20);
		tree.rightChild.leftChild = new Node(30);
		tree.rightChild.leftChild.leftChild = new Node(35);
		tree.rightChild.rightChild = new Node(40);
		tree.rightChild.rightChild.leftChild = new Node(50);
		tree.rightChild.rightChild.rightChild = new Node(60);
		System.out.print("IN-ORDER BEFORE : ");TreeTraversal.inOrder(tree);
		System.out.print("\nBOTTOM_VIEW_ORDERED : ");bottomView(tree);
		System.out.print("\nIN-ORDER AFTER : ");TreeTraversal.inOrder(tree);			
	}
	private static void testTopViewUnorder(){
		Node tree = new Node(10);
		tree.rightChild = new Node(20);
		tree.rightChild.leftChild = new Node(30);
		tree.rightChild.leftChild.leftChild = new Node(35);
		tree.rightChild.rightChild = new Node(40);
		tree.rightChild.rightChild.leftChild = new Node(50);
		tree.rightChild.rightChild.rightChild = new Node(60);
		System.out.print("IN-ORDER BEFORE : ");TreeTraversal.inOrder(tree);
		System.out.print("\nTOP_VIEW_UNORDERED : ");topViewUnordered(tree);
		System.out.print("\nIN-ORDER AFTER : ");TreeTraversal.inOrder(tree);	
	}
	
	private static void testSideView(){
		Node tree = new Node(10);
		tree.rightChild = new Node(20);
		tree.rightChild.leftChild = new Node(30);
		tree.rightChild.rightChild = new Node(40);
		tree.rightChild.rightChild.leftChild = new Node(50);
		tree.rightChild.rightChild.rightChild = new Node(60);
		System.out.print("IN-ORDER BEFORE : ");
		TreeTraversal.inOrder(tree);
		System.out.print("\nSIDE_VIEW : ");
		sideView(tree);
		System.out.print("\nIN-ORDER AFTER : ");
		TreeTraversal.inOrder(tree);
	}


}