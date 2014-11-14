package binary_tree;

import java.util.List;

public class Node implements java.lang.Comparable<Node>{
	public Integer data;
	public Integer level;
	public boolean visited;
	public Node leftChild;
	public Node rightChild;

	/*
	 * By Default instance references are initialized with null
	 */
	public Node(){
	}
	
	public Node(Integer data){
		this.data = data;
		this.level = 0;
		this.visited = false;
	}
	
	public Node(Integer data, Node leftChild, Node rightChild){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.level = 0;
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
	
	@Override
	public int compareTo(Node n) {
		if(this.data == null || n == null || n.data == null){
			return -1;
		}
		return this.data.compareTo(n.data);
	}
}
