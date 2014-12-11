/**
 * 
 */
package list;

import java.util.HashSet;

import binary_tree.Node;

/**
 * @author ankugarg
 */
public class SingleLinkedList {

	/**
	 * Question : 
	 * Write a removeDuplicates() function which takes a list and 
	 * deletes any duplicate nodes from the list. The list is not sorted.
		For example if the linked list is 12->11->12->21->41->43->21 
		then removeDuplicates() should convert the list to 12->11->21->41->43.
		
		TC : O(N)
		SC : O(N)
		N is number of Nodes/elements in the link list
		
		this implementation modifies the original link list
	 */
	public static void removeDuplicates(Node list){
		java.util.HashSet<Node> nodeSet = new HashSet<>();
		Node previous = null;
		while(list != null){
			if(!nodeSet.add(list)){
				previous.next = list.next;
			}else{
				previous = list;
			}
			list = list.next;
		}
		return;
	}
	
	/**
	 * TC : O(n), n is the length of the link list
	 * @question : Pairwise swap elements of a given linked list by changing links 
	 * Given a singly linked list, swap kth node from beginning with
	 * kth node from end. Swapping of data is not allowed, only pointers should
	 * be changed. This requirement may be logical in many situations where the
	 * linked list data part is huge
	 * 
	 * The problem seems simple at first look, but it has many interesting
	 * cases.
	 * 
	 * Let X be the kth node from beginning and Y be the kth node from end.
	 * Following are the interesting cases that must be handled. 
	 * 1) Y is next to X 
	 * 2) X is next to Y 
	 * 3) X and Y are same 
	 * 4) X and Y don’t exist (k is more than number of nodes in linked list)
	 * 
	 * @param list is link list in which swap has to happen
	 * @param k is position
	 */
	public static Node swapKthNodeFromStartAndEnd(Node list, long k){
		if(list == null)	return list;
		long n = Node.getListLength(list);
		//position out of bound OR attempt to swap middle element of the list (whose length will be obviously ODD)
		if( k < 1 || n < k || (2*k - 1 == n) )	return list;
		
		Node x = list, previousX = null, y = list, previousY = null;
		for(int i=0;i<k-1;i++){
			previousX = x;
			x = x.next;
		}
		for(int i=0;i<n-k;i++){
			previousY = y;
			y = y.next;
		}		
		if(previousY == null){ // k==n, then swap X and Y
			Node t = y; y=x; x=t;
			t=previousX; previousX = previousY; previousY = t;
		}
		if(previousX == null){ // k==1
			list = y;
			if(previousY == x){ // length of list is 2
				y.next = x;
				x.next = null; 
			}else{
				previousY.next = x;
				Node t = x.next;
				x.next = y.next;
				y.next = t;
			}
			return list;
		}

		if(y.next == x){ // X is next to Y
			Node t = y; y=x; x=t;
			t=previousX; previousX = previousY; previousY = t;			
		}
		if(x.next == y){ // Y is next to X
			previousX.next = y;
			x.next = y.next;
			y.next = x;
			return list;
		}else{// all other cases where X and Y are not at edges/corner or not next to each other
			previousX.next = y;
			Node t = x.next;
			x.next = y.next;
			previousY.next = x;
			y.next = t;
			return list;
		}
	}
	
	public static Node mergeSort(Node list){
		return null;
	}
	
	/**
	 * TC : O(x), x = MIN(m,n) are length of link lists
	 * @param a
	 * @param b
	 * @return
	 * 
	 * below merge can also be implemented in iterative manner
	 */
	public static Node mergeSortedListR(Node a, Node b){
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		Node result;
		if(a.data <= b.data){
			result = a;
			result.next = mergeSortedListR(a.next, b);
		}else{
			result = b;
			result.next = mergeSortedListR(a, b.next);
		}
		return result;
	}
	
	public static void main(String[] args) {
		testRemoveDuplicates();
		testmergeSortedListR();
		testSwap();
	}
	
	private static void testRemoveDuplicates(){
		Node list = new Node(12);
		list.next = new Node(20);
		list.next.next = new Node(120);
		list.next.next.next = new Node(120);
		list.next.next.next.next = new Node(20);
		Node.printLinkList(list);
		removeDuplicates(list);
		Node.printLinkList(list);
				
	}
	
	private static void testNodeComparsion(){
		Node list = new Node(12);
		Node n = new Node(12);
		Node n2 = new Node(121);
		System.out.println(list.equals(n));
		System.out.println(list.equals(n2));
		
		Integer a = 9;
		Integer b = 90;
		System.out.println(a == b);
	}
	
	private static void testSwap(){
		Node l = new Node(1);
		l.next = new Node(2);
		l.next.next = new Node(3);
		l.next.next.next = new Node(4);
		l.next.next.next.next = new Node(5);
		l.next.next.next.next.next = new Node(6);
		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 1);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 2);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 3);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 4);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 5);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 6);		Node.printLinkList(l);
		l = swapKthNodeFromStartAndEnd(l, 7);		Node.printLinkList(l);
	}

	private static void testmergeSortedListR(){
		Node p = new Node(10);
		p.next = new Node(20);
		p.next.next = new Node(30);
		
		Node q = new Node(5);
		q.next = new Node(25);
		q.next.next = new Node(125);
		
		Node.printLinkList(p);
		Node.printLinkList(q);
		Node.printLinkList(mergeSortedListR(p, q));
	}
}
