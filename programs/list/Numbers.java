/**
 * 
 */
package list;

import binary_tree.Node;

/**
 * @author ankugarg
 *
 */
public class Numbers {
	private static Integer carry = 0;
	/**
	 * perform a + b and display result return linked list representing
	 * resultant value
	 * 
	 * @question : Given two numbers represented by two linked lists, write a
	 *           function that returns sum list. The sum list is linked list
	 *           representation of addition of two input numbers. It is not
	 *           allowed to modify the lists. Also, not allowed to use explicit
	 *           extra space
Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
	 * 
	 * 
	 * ONLY FOR ADDING THE DIGITS AND NOT MEANT FOR SUBTRACTION IN FORM
	 * for example adding 985 + -9 won't work here instead result will be 98-4 
	 */
	public static Node addNumber(Node x, Node y) {
		if(x == null)	return y;
		if(y == null)	return x;
		carry = 0;
		long xLength = Node.getListLength(x);
		long yLength = Node.getListLength(y);
		
		//making x as the longer list for ease of applying logic
		if(xLength < yLength){
			xLength = xLength + yLength; yLength = xLength - yLength; xLength = xLength - yLength;// swapping
			Node t =x; x = y; y = t;
		}
		
		long diff = xLength - yLength;
		Node z = null, zMSB = null;
		Node xCorrected = x;
		for(int i = 1; i <= diff; i++){
			xCorrected = xCorrected.next;
		}
		
		z = sumUp(xCorrected, y);
		if(diff != 0){
			zMSB = carryForward(x, diff);
			Node zTail = Node.getLinkListTail(zMSB);
			zTail.next = z;
			z = zMSB;
		}
		if(carry > 0){
			Node zCarry = new Node(carry);
			zCarry.next = z;
			z = zCarry;
		}
		return z;
	}
	public static Node sumUp(Node x, Node y){
		if(x == null) return y;
		if(y == null) return x;
		
		Node z = new Node();
		z.next = sumUp(x.next, y.next);
		Integer data = x.data + y.data + carry;
		carry = data / 10;
		z.data = data % 10;
		return z;
	}
	
	public static Node carryForward(Node n, long k){
		if(k == 0 || n == null)	return null;
		Node z = new Node();
		z.next = carryForward(n.next, k - 1);
		Integer data = n.data + carry;
		carry = data /10;
		z.data = data % 10;
		return z;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(8);
		x.next.next = new Node(5);
		
		Node y = new Node(4);
		y.next = new Node(4);
		y.next.next = new Node(9);
		
		Node.printLinkList(x);
		Node.printLinkList(y);
		
		Node z = addNumber(x, y);
		Node.printLinkList(z);
	}

}
