/**
 * 
 */
package list;

import binary_tree.Node;

/**
 * @author ankugarg
 *
 */
public class SingleLinkedList {

	/**
	 * question : Given a singly linked list, swap kth node from beginning with
	 * kth node from end. Swapping of data is not allowed, only pointers should
	 * be changed. This requirement may be logical in many situations where the
	 * linked list data part is huge
	 * 
	 * The problem seems simple at first look, but it has many interesting
	 * cases.
	 * 
	 * Let X be the kth node from beginning and Y be the kth node from end.
	 * Following are the interesting cases that must be handled. 1) Y is next to
	 * X 2) X is next to Y 3) X and Y are same 4) X and Y don’t exist (k is more
	 * than number of nodes in linked list)
	 * 
	 * @param list
	 * @param k
	 */
	public static void swapKthNodeFromStartAndEnd(Node list, int k){
		
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
	public static Node mergeListR(Node a, Node b){
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		Node result;
		if(a.data <= b.data){
			result = a;
			result.next = mergeListR(a.next, b);
		}else{
			result = b;
			result.next = mergeListR(a, b.next);
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node p = new Node(10);
		p.next = new Node(20);
		p.next.next = new Node(30);
		
		Node q = new Node(5);
		q.next = new Node(25);
		q.next.next = new Node(125);
		
		Node.printLinkList(p);
		Node.printLinkList(q);
		Node.printLinkList(mergeListR(p, q));
	}

}
