package com.graph;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;

public class DirectBFS implements Paths{

	private boolean[] marked;
	private Integer[] edgeTo;
	private int s = 0;
	
	public DirectBFS(Digraph G, int source){
		this.s = source;
		marked = new boolean[G.V()];
		edgeTo = new Integer[G.V()];
		marked[s] = true;
		edgeTo[s] = null;
		bfs(G, s);
		System.out.println(G);
		for(int v = 0; v< G.V();v++){
			System.out.println(v+"\t"+marked[v]+"\t"+edgeTo[v]);
		}
	}
	
	public void bfs(Digraph G, int s){
		java.util.Queue<Integer> q = new java.util.LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()){
			int v = q.remove();
			for(Integer w : G.adj(v)){
				System.out.print(w+ " ");
				if(!marked[w]){
					marked[w] = true;
					edgeTo[w] = v;
					q.add(w);
				}
			}
			System.out.println();
		}
	}
	@Override
	public boolean hasPathTo(Integer v) {
		// there shouldn't be any self loops in the Digraph
		try{
			if(v == s)
				return true;
			else
				return hasPathTo(edgeTo[v]);
		}catch(java.lang.NullPointerException e){
			return false;
		}
	}

	@Override
	public Iterable<Integer> pathTo(Integer v){
		if(!hasPathTo(v)){
			return new CollectionBag<Integer>(new HashBag<Integer>());
		}else{
			return getPathTo(v);
		}
	}
	private java.util.List<Integer> getPathTo(int v){
		java.util.List<Integer> b = null;
		//System.out.println("v="+v);
		if(v == s){
			b = new java.util.LinkedList<Integer>();
			b.add(v);
			return  b;
		}else{
			b = new java.util.LinkedList<Integer>(getPathTo(edgeTo[v]));
			b.add(v);
			return b;
		}
	}

	@Override
	public int pathLength(Integer v){
		int l = -1;
		for(Integer w : pathTo(v))
			l++;
		return l;
	}
}