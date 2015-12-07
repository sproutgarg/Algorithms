package com.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DirectTopoSort {
	private boolean[] marked;
	private java.util.Stack<Integer> postOrder;
	
	public DirectTopoSort(Digraph G){
		marked = new boolean[G.V()];
		postOrder = new Stack<>();
		for(int v = 0; v < G.V(); v++){
			if(!marked[v])
				directDFS(G, v);
		}
		
	}
	public void directDFS(Digraph G, int v){
		marked[v] = true;
		for(Integer w : G.adj(v)){
			if(!marked[w]){
				directDFS(G, w);
			}
		}
		postOrder.push(v);
	}
	public Iterable<Integer> getPostOrder(){
		return postOrder;
	}
	public Iterable<Integer> getTopoOrder(){
		java.util.List<Integer> reversePostOrder = new ArrayList<Integer>(postOrder);
		java.util.Collections.reverse(reversePostOrder);
		return reversePostOrder;
	}
}