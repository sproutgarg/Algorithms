package cache;

import binary_tree.Node;

public class Queue {
	private Node front = null;
	private Node rear = null;
	private int capacity;
	
	public Queue(){
	}
	public Queue(int capacity){
		this.capacity = capacity;
	}
	
	public Node getFront(){
		return front;
	}
	public Node getRear(){
		return rear;
	}
	
	public void enque(Node n){
		if(rear == null){
			rear = n;
			front = rear;
			n.next = null;
			n.previous = null;
		}else{
			n.next = null;
			n.previous = rear;
			rear.next = n;
			rear = n;
		}
	}
	
	public void deque(){
		if(front == null){
			return;
		}

		if(front == rear){
			front = rear = null;
			return;
		}
		
		front = front.next;
		front.previous.next = null;
		front.previous = null;
		return;
	}
	
	public void delete(Node n){
		if(n == null){
			return ;
		}
		
		Node left = n.previous;
		Node right = n.next;
		
		// n is the only node in the Queue
		if(n == front && left == null && right == null){
			front = rear = null;
		}
		
		if(left != null){
			left.next = right;
			if(right == null){
				rear = left;
			}else{
				right.previous = left;
			}
		}
		
		if(right != null){
			right.previous = left;
			if(left == null){
				front = right;
			}else{
				left.next = right;
			}
		}
	}

	public String toString(){
		String q = "FRONT->";
		if(front == null){
			q += " <-REAR";
			return q;
		}
		Node n = front;
		while(n != null){
			q = q +" "+ n;
			n = n.next;
		}
		q += " <-REAR";
		return q;
	}
	
	public boolean isEmpty(){
		return front == null;
	}

	public static void main(String[] args){
		Queue q = new Queue();
		Node a = new Node(9);
		Node b = new Node(3);
		Node c = new Node(2);
		Node d = new Node(8);
		q.enque(a);
		q.enque(b);
		q.enque(c);
		q.enque(d);
		System.out.println(q);
		q.deque();
		System.out.println(q);
		q.delete(a);
		System.out.println(q);
		q.delete(c);
		System.out.println(q);
		q.delete(b);
		System.out.println(q);
		q.deque();
		q.deque();
		System.out.println(q);
	}
}