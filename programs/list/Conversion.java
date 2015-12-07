package list;

import binary_tree.Node;

public class Conversion {
	
	/**
	 * question:Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. 
The flattened linked list should also be sorted. 
For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
	 * @param mutliLevelLinkedList
	 * @return
	 * 
	 * Node -> right
	 *  |
	 *  V
	 * next(here) OR down
	 * but it should not be considered as of tree element
	 * 
	 */
	public static Node flatteningMutlilevelLinkedListR(Node root){
		if(root == null || root.rightChild == null){
			return root;
		}
		return SingleLinkedList.mergeSortedListR(root, flatteningMutlilevelLinkedListR(root.rightChild));
	}
	public static Node flatteningMutlilevelLinkedListI(Node root){
		if(root == null || root.rightChild == null){
			return root;
		}
		Node fl;
		fl = root;
		Node n = root;
		while(n!= null){
			fl = SingleLinkedList.mergeSortedListR(fl, n.rightChild);
			n = n.rightChild;
		}
		return fl;
	}
		
	
	public static void main(String...args){
		testFlatteningMutlilevelLinkedListR();
		testFlatteningMutlilevelLinkedListI();
	}
	private static void testFlatteningMutlilevelLinkedListI(){
		Node ml = new Node(5);
		ml.next = new Node(7);
		ml.next.next = new Node(8);
		ml.next.next.next = new Node(30);
		
		ml.rightChild = new Node(10);
		ml.rightChild.next = new Node(20);
		
		ml.rightChild.rightChild = new Node(19);
		ml.rightChild.rightChild.next = new Node(22);
		ml.rightChild.rightChild.next.next = new Node(50);
		
		ml.rightChild.rightChild.rightChild = new Node(28);
		ml.rightChild.rightChild.rightChild.next = new Node(35);
		ml.rightChild.rightChild.rightChild.next.next = new Node(40);
		ml.rightChild.rightChild.rightChild.next.next.next = new Node(45);

		Node f = flatteningMutlilevelLinkedListI(ml);
		Node.printLinkList(f);
	}
	
	private static void testFlatteningMutlilevelLinkedListR(){
		Node ml = new Node(5);
		ml.next = new Node(7);
		ml.next.next = new Node(8);
		ml.next.next.next = new Node(30);
		
		ml.rightChild = new Node(10);
		ml.rightChild.next = new Node(20);
		
		ml.rightChild.rightChild = new Node(19);
		ml.rightChild.rightChild.next = new Node(22);
		ml.rightChild.rightChild.next.next = new Node(50);
		
		ml.rightChild.rightChild.rightChild = new Node(28);
		ml.rightChild.rightChild.rightChild.next = new Node(35);
		ml.rightChild.rightChild.rightChild.next.next = new Node(40);
		ml.rightChild.rightChild.rightChild.next.next.next = new Node(45);
		
		Node fl = flatteningMutlilevelLinkedListR(ml);
		Node.printLinkList(fl);
	}
}