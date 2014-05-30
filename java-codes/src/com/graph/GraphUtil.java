package com.graph;

public class GraphUtil {
	
	private static boolean[] marked;
	public static int degree(Graph G, int v){
		int d = 0;
		for(Integer w: G.adj(v))
			d++;
		return d;
	}
	
	public static int maxDegree(Graph G){
		int max = 0;
		int d = 0;
		for(int v = 0; v < G.V(); v++){
			d = 0;
			for(Integer w : G.adj(v))
				d++;
			if(max < d){
				max = d;
			}
		}
		return max;
	}
	
	public static double averageDegree(Graph G){
		return (2.0*G.E()/G.V());
	}
	
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int v = 0; v < G.V(); v++){
			for(Integer w : G.adj(v)){
				if(w == v){
					count++;
				}
			}
		}
		count /= 2;
		return count;
	}
	
	public static boolean hasCycle(Graph G){
		marked = new boolean[G.V()];
		for(int v = 0; v< G.V(); v++){
			if(!marked[v]){
				if(_hasCycle(G, v)){
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean _hasCycle(Graph G, int v){
		marked[v] = true;
		for(Integer w : G.adj(v)){
			if(!marked[w]){
				return _hasCycle(G, w);
			}else{
				return true;
			}
		}
		return false;
	}
}