package stack;

import binary_tree.Node;

/**
 * This stack has following operations with constant time complexity O(1): 
 * 1) push() which adds an element to the top of stack. 
 * 2) pop() which removes an element from top of stack. 
 * 3) findMiddle() which will return middle element of the stack. 
 * 4) deleteMiddle() which will delete the middle element.
 */
public class Stack {
	
	private long counter;
	private Node head;
	private Node middle;
	private Node tail;

	public Stack(){
		counter = 0;
		head = tail = middle = null;
	}
	public boolean isEmpty(){
		return counter <= 0;
	}
	
	public void push(Node n){
		counter++;
		n.next = n.previous = null;
		if(tail == null){
			head = tail = middle = n;
			return;
		}
		tail.next = n;
		n.previous = tail;
		tail = n;
		if(counter % 2 != 0){
			middle = middle.next;
		}
	}
	
	public Node pop(){
		if(tail == null){
			return null;
		}
		counter--;
		if(counter%2 ==0){
			middle = middle.previous;
		}
		Node temp = tail;
		tail = tail.previous;
		temp.previous = temp.next = null;
		if(tail == null){
			head = tail;
		}else{
			tail.next = null;
		}
		return temp;
	}
	public Node findMiddle(){
		return middle;
	}
	public Node deleteMiddle(){
		if(counter == 0)	return null;
		counter--;
		Node n = middle;
		if(counter == 0){
			middle = head = tail = null;
		}
		else if(counter % 2 != 0){
			middle = middle.next;
			if(head == n){// corner case when counter becomes 1
				head = middle;
			}else{
				n.previous.next = middle;
				middle.previous = n.previous;
			}
		}else{
			middle = middle.previous;
			middle.next = n.next;
			n.next.previous = middle;
		}
		n.next = n.previous = null;
		return n;
	}
	
	public void printStack(){
		Node.printLinkList(head);
	}
	
	/**
	 * TC : O(N), n is size of the stack
	 * SC : O(N)
	 * this function will modify stack 
	 * will use temporary stack
	 */
	public void sort(){
		
	}
	
	public static void main(String...args){
		testDeleteMiddle();
	}
	private static void testDeleteMiddle(){
		Stack s = new Stack();
		s.push(new Node(20));
		s.push(new Node(12));
		s.push(new Node(30));
		s.push(new Node(40));
		s.push(new Node(90));
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
		s.printStack();
		System.out.println("findMiddle   : " + s.findMiddle());
		System.out.println("deleteMiddle : " + s.deleteMiddle());
	}
	private static void testPop(){
		Stack s = new Stack();
		System.out.println("pop : "+s.pop());
		s.push(new Node(20));
		s.push(new Node(12));
		System.out.println("middle  :"+s.findMiddle());
		s.push(new Node(30));
		System.out.println("middle  :"+s.findMiddle());
		s.push(new Node(40));
		System.out.println("middle  :"+s.findMiddle());
		s.push(new Node(90));
		System.out.println("middle  :"+s.findMiddle());
		s.printStack();
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());
		System.out.println("pop : "+s.pop());
		s.printStack();
		System.out.println("middle  :"+s.findMiddle());		
	}
}