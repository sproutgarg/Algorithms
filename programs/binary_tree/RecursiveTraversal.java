package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class RecursiveTraversal {

	public static void preOrder(Node n){
		if(n == null){
			return;
		}
		n.display();
		if(n.hasLeftChild()){
			preOrder(n.leftChild);
		}
		if(n.hasRightChild()){
			preOrder(n.rightChild);
		}
	}
	
	public static void inOrder(Node n){
		if(n == null){
			return;
		}
		if(n.hasLeftChild()){
			inOrder(n.leftChild);
		}
		n.display();
		if(n.hasRightChild()){
			inOrder(n.rightChild);
		}
	}
	
	public static void postOrder(Node n){
		if(n == null){
			return;
		}
		if(n.hasLeftChild()){
			postOrder(n.leftChild);
		}
		if(n.hasRightChild()){
			postOrder(n.rightChild);
		}
		n.display();
	}
	
	public static void levelOrder(Queue<Node> queue){
		Node n = queue.poll();
		if(n == null){
			return;
		}
		n.display();
		if(n.hasLeftChild()){
			queue.add(n.leftChild);
		}
		if(n.hasRightChild()){
			queue.add(n.rightChild);
		}
		levelOrder(queue);
	}
	
	public static void levelSpiralOrder(Queue<Node> queue, boolean isLeftToRight){
		do{
			
		}while(false);
		Node n = queue.poll();
		if(n == null){
			return;
		}
		n.displayNodeLevel();
		if(n.hasLeftChild()){
			n.leftChild.level = n.level + 1;
			queue.add(n.leftChild);
		}
		if(n.hasRightChild()){
			n.rightChild.level = n.level + 1;
			queue.add(n.rightChild);
		}
		levelSpiralOrder(queue, !isLeftToRight);
	}
	
	
	
	public static void main(String...args){
		tc1();
	}
	
	public static void tc1(){
		Node tree = new Node(5);
		tree.leftChild = new Node(23);
		tree.rightChild = new Node(11);
		tree.rightChild.leftChild = new Node(9);
		tree.rightChild.rightChild = new Node(6);
		System.out.print("inorder traversal : ");
		inOrder(tree);System.out.println();
		
		System.out.print("postorder traversal : ");
		postOrder(tree);System.out.println();

		System.out.print("preorder traversal : ");
		preOrder(tree);System.out.println();
		
		System.out.print("level order traversal : ");
		Queue<Node> q = new LinkedList<Node>();
		tree.level = 0;
		q.add(tree);
		levelOrder(q);System.out.println();
		
		q.add(tree);
		System.out.print("Level spiral order traversal : ");
		levelSpiralOrder(q, true);System.out.println();
		System.out.println("queue : " + q);
		
		
	}
}
