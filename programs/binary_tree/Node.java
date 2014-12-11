package binary_tree;

import java.util.List;

public class Node implements java.lang.Comparable<Node>{
	public Integer data;
	public Integer level;
	public Integer horizontalDistance;
	public boolean visited;
	public Node leftChild;
	public Node rightChild;
	public Node next;
	public Node previous;
	public Node child;

	/*
	 * By Default instance references are initialized with null
	 */
	private Node(){
	}
	
	public Node(Integer data){
		this.data = data;
		this.visited = false;
	}
	
	public Node(Integer data, Node leftChild, Node rightChild){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.visited = false;
	}
	
	public Node(Integer data, Node leftChild, Node rightChild, Integer level){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.level = level;
		this.visited = false;
	}
	
	public boolean isLeafNode(){
		return leftChild == null && rightChild == null;
	}
	
	public boolean hasLeftChild(){
		return leftChild != null;
	}
	
	public boolean hasRightChild(){
		return rightChild != null;
	}
	
	public boolean isComplete(){
		return leftChild != null && rightChild != null;
	}
	
	public String toString(){
		return data.toString();
	}
	
	public void display(){
		System.out.print("(" + data + ")");
	}
	
	public void displayNodeLevel(){
		System.out.print("(D:" + data + ",L:" + level + ")" );
	}
	
	public void displayNodeHD(){
		System.out.print("(D:" + data+", HD:" + horizontalDistance + ")");
	}
	
	public static void displayNodeList(List<Node> nodeList, boolean isLeftToRight){
		if(isLeftToRight){
			for(Node n : nodeList){
				n.displayNodeLevel();
			}
		}else{
			for(int i = nodeList.size()-1; i>=0;i--){
				nodeList.get(i).displayNodeLevel();
			}
		}
	}
	
	public static void printLinkList(Node list){
		while(list != null){
			list.display();
			System.out.print("--->");
			list = list.next;
		}
		System.out.println("NULL");
	}
	
	public static long getListLength(Node list){
		long length = 0L;
		while(list != null){
			length++;
			list = list.next;
		}
		return length;
	}
	
	public static Node getLinkListTail(Node list){
		if(list == null)	return null;
		while(list.next != null){
			list = list.next;
		}
		return list;
	}
	
	@Override
	public int compareTo(Node n) {
		if(this.data == null || n == null || n.data == null){
			return -1;
		}
		return this.data.compareTo(n.data);
	}
	
	@Override
	public boolean equals(Object n){
		if(n != null && n instanceof Node){
			Node temp = (Node)n;
			if(temp.data == null || this.data == null){
				return false;
			}
			return temp.data == this.data;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		if(data != null){
			return data.hashCode();
		}
		return 0;
	}
}
