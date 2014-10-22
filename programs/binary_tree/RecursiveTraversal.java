package binary_tree;

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
	public static void main(String...args){
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

	}
}
