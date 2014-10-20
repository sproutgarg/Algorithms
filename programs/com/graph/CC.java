package com.graph;

public class CC {
	private boolean[] marked;
	private Integer[] id;
	private int count;
	public CC(Graph G){
		count = 0;
		marked = new boolean[G.V()];
		id = new Integer[G.V()];
		for(int v = 0; v < G.V(); v++){
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
	
	public boolean isConnected(int v, int w){
		return id[v] == id[w];
	}
	
	private void dfs(Graph G, int s){
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