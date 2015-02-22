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
		if(list != null && list.next != null){
			Node mid = getMiddleNode(list);
			Node midNext = mid.next;
			mid.next = null;
			list = mergeSort(list);
			midNext = mergeSort(midNext);
			list = mergeSortedListI(list, midNext);
			Node.printLinkList(list);
		}
		return list;
	}
	
	/**
	 * API : write a function to fetch the middle element of the linked list.
	 * TC : O(n/2) SC : O(1)
	 * @param list
	 * @return
	 */
	public static Node getMiddleNode(Node list){
		if(list == null || list.next == null){
			return list;
		}
		Node mid = list;
		Node fast = list.next;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
				mid = mid.next;
			}
		}
		return mid;
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
	
	/**
	 * iterative version of merging the 2 sorted link list.
	 * TC : O(x), x=min(n,m); n,m is length of link list a and b respectively
	 * @param aList
	 * @param bList
	 * @return
	 */
	public static Node mergeSortedListI(Node aList, Node bList){
		if(aList == null){
			return bList;
		}
		if(bList == null){
			return aList;
		}
		Node list = new Node(0);//dummy node
		Node currentNode = list;
		while(aList != null && bList!= null){
			if(aList.compareTo(bList) < 0){ // a < b
				currentNode.next = aList;
				aList = aList.next;
			}else{
				currentNode.next = bList;
				bList = bList.next;
			}
			currentNode = currentNode.next;
			currentNode.next = null;
		}
		if(aList == null){
			currentNode.next = bList;
		}else{
			currentNode.next = aList;
		}
		list = list.next;
		return list;
	}
	
	/**
	 * API : reverse the given linked list.
	 * TC : O(n) SC : O(n)
	 * @param args
	 */
	public static Node reverse(Node list){
		if(list == null || list.next == null) return list;
		Node current = list;
		Node next = null;
		Node previous = null;

		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	/**
	 * API has loop
	 * TC : O(n) SC : O(n)
	 * @param args
	 */
	public static boolean hasLoop(Node list){
		if(list == null) return false;
		Node current = list;
		Node fast = list.next;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
				current = current.next;
			}
			if(fast == current){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.

Example 1

Input:
  First List: 5->6->3  // represents number 3<-6<-5<-
  Second List: 8->4->2 //  represents number 2<-4<-8<-
Output
  Resultant list: 3->1->6  // represents number 613
Example 2

Input:
  First List: 7->5->9->4->6  // represents number 64957
  Second List: 8->4 //  represents number 48
Output
  Resultant list: 5->0->0->5->6  // represents number 65005
  NOTE : list link starts pointing the digits from right to left (this makes the algo elegant)
  there can also be a case where link list is pointing the digits from left to right (will be reversed to use above approach)
	 * @param args
	 * TC : O(n), n is length of bigger number rept in form of link list
	 */
	public static Node addTwoNumbersRTL(Node x, Node y){
		if(x == null) return y;
		if(y == null) return x;
		return addTwoNumbersRTL(x,y,0);
	}
	
	private static Node addTwoNumbersRTL(Node x, Node y, int carry){
		if(x == null && y == null && carry == 0) return null;

		if(x == null)	x = new Node(0);
		if(y == null)	y = new Node(0);
		
		int data = x.data + y.data + carry;
		
		carry = data / 10;
		data = data % 10;
		
		Node z = new Node(data);
		z.next = addTwoNumbersRTL(x.next, y.next, carry); 
		
		return z;
	}
	
	/**
	 * The Usual of way of passing data where link list points digits from left to right
	 * @param x
	 * @param y
	 * TC : O(n), n is length of bigger number rept in form of link list
	 * @return Sum 
	 */
	public static Node addTwoNumbersLTR(Node x, Node y){
		x = reverse(x);
		y = reverse(y);
		Node z = addTwoNumbersRTL(x, y);
		z = reverse(z);
		return z;
	}
	
	/**
	 * @Question : 
	 * Given two SORTED linked lists, construct a linked list that contains maximum sum path from start to end. The result list may contain nodes from both input lists. When constructing the result list, we may switch to the other input list only at the point of intersection (which mean the two node with the same value in the lists). You are allowed to use O(1) extra space.

Input:
List1 =  1->3->30->90->120->240->511
List2 =  0->3->12->32->90->125->240->249

Output: Following is maximum sum linked list out of two input lists
list =  1->3->12->32->90->125->240->511
we switch at 3 and 240 to get above maximum sum linked list
	 * @param args
	 * TC : O(n) length of longer link list
	 */
	public static Node maxSumLinkList(Node a, Node b){
		if(a == null)	return b;
		if(b == null)	return a;
		
		Node c = new Node(0);
		
		Node currentA = a;
		Node previousA = a;
		Node currentB = b;
		Node previousB = b;
		Node currentC = c;

		int sumA = 0;
		int sumB = 0;
		
		while(currentA != null && currentB != null){
			if(currentA.compareTo(currentB) == 0){ // found a common point b/w 2 lists
				if(sumA < sumB){
					currentC.next = previousB;
					currentC = currentB;
				}else{
					currentC.next = previousA;
					currentC = currentA;
				}
				previousA = currentA.next;
				previousB = currentB.next;
				sumA = 0;
				sumB = 0;
				currentA = currentA.next;
				currentB = currentB.next;
			}
			else if(currentA.compareTo(currentB) < 0){
				sumA += currentA.data;
				currentA = currentA.next;
			}
			else{
				sumB += currentB.data;
				currentB = currentB.next;
			}
		}
		if(currentA != null){
			currentC.next = previousA;
		}
		if(currentB != null){
			currentC.next = previousB;
		}
		
		return c.next;
	}
	
	public static void main(String[] args) {
		testMaxSumLinkList();
//		testAddTwoLinkList();
//		testLoop();
//		testReverse();
//		testMiddleElement();
//		testRemoveDuplicates();
//		testmergeSortedList();
//		testMergeSort();
//		testSwap();
	}
	
	private static void testMaxSumLinkList(){
		Node m = new Node(1);
		m.next = new Node(3);
		m.next.next = new Node(30);
		m.next.next.next = new Node(90);
		m.next.next.next.next = new Node(120);
		m.next.next.next.next.next = new Node(240);
		m.next.next.next.next.next.next = new Node(511);
		
		Node n = new Node(0);
		n.next = new Node(3);
		n.next.next = new Node(12);
		n.next.next.next = new Node(32);
		n.next.next.next.next = new Node(90);
		n.next.next.next.next.next = new Node(125);
		n.next.next.next.next.next.next = new Node(240);
		
		Node.printLinkList(m);
		Node.printLinkList(n);
		
		Node.printLinkList(maxSumLinkList(m, n));
		 
	}
	
	private static void testAddTwoLinkList(){
		Node x = new Node(5);
		x.next = new Node(6);
		x.next.next = new Node(9);
		
		Node y = new Node(7);
		y.next = new Node(8);
		
		Node.printLinkList(x);
		Node.printLinkList(y);
		
		Node.printLinkList(addTwoNumbersRTL(x, y));
		Node.printLinkList(addTwoNumbersLTR(x, y));
	}
	
	private static void testLoop(){
		Node list = new Node(10);
		list.next = list;//new Node(20);
//		list.next.next = list;//new Node(30);
//		list.next.next.next = new Node(40);
//		list.next.next.next.next = list.next;
//		Node.printLinkList(list);
		System.out.println("hasLoop = " + hasLoop(list));
	}
	
	private static void testReverse(){
		Node list = new Node(912);
		list.next = new Node(290);
		list.next.next = new Node(120);
		Node.printLinkList(list);
		list = reverse(list);
		Node.printLinkList(list);		
	}
	
	private static void testMergeSort(){
		Node list = new Node(912);
		list.next = new Node(290);
		list.next.next = new Node(120);
		list.next.next.next = new Node(120);
		list.next.next.next.next = new Node(20);		
		Node.printLinkList(list);
		list = mergeSort(list);
		Node.printLinkList(list);
	}
	
	private static void testMiddleElement(){
		Node list = new Node(12);
		list.next = new Node(20);
		list.next.next = new Node(120);
		list.next.next.next = new Node(120);
		list.next.next.next.next = new Node(20);
		Node.printLinkList(list);
		System.out.println(getMiddleNode(list));
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

	private static void testmergeSortedList(){
		Node p = new Node(10);
		p.next = new Node(20);
		p.next.next = new Node(30);
		
		Node q = new Node(5);
		q.next = new Node(25);
		q.next.next = new Node(125);
		
		Node.printLinkList(p);
		Node.printLinkList(q);
		Node.printLinkList(mergeSortedListI(p, q));
		//Node.printLinkList(mergeSortedListR(p, q));
	}
}
