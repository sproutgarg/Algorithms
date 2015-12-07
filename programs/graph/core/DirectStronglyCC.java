package com.graph;

public class DirectStronglyCC {
	private boolean[] marked;
	private Integer[] id;
	private int count;
	public DirectStronglyCC(Digraph G){
		count = 0;
		marked = new boolean[G.V()];
		id = new Integer[G.V()];
		Digraph _G = G.reverse();
		DirectTopoSort topoG = new DirectTopoSort(_G);
		for(Integer v : topoG.getTopoOrder()){
			if(!marked[v]){
				dfs(G,v);
				count++;
			}
		}
		System.out.println("count : " +count);	
	}
	
	public int count(){
		return count;
	}
	
	public Integer id(int v){
		return id[v];
	}
	
	public boolean isStronglyConnected(int v, int w){
		return id[v] == id[w];
	}
	
	private void dfs(Digraph G, int s){
		id[s] = count; 
		marked[s] = true;
		for(Integer w : G.adj(s)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	public String toString(){
		String str = "";
		for(int v=0; v < id.length; v++){
			str += v + " --> " + id[v]+"\n";
		}
		return str;
	}
	
}