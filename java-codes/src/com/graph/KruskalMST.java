package com.graph;

import java.util.Collection;
import java.util.PriorityQueue;

public class KruskalMST {
	private java.util.Queue<Edge> mst = new java.util.LinkedList<>();
	private double weight = 0.0;
	public KruskalMST(EdgeWeightedGraph G){
		java.util.PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		edges.addAll((Collection<? extends Edge>) G.edges());
		/* G.edges() returns reference to ArrayList object which is-a Collection<? extends E>
		 * again PriorityQueue is-a Collection<? extends E>, therefore we can type cast the returned ref. to PQ
		 * Note : above funda may not have full clarity
		 *  
		 *  Concept :
		 * "is-a" relationship like for example: "skyline GT R" is-a Car, as "skyline GT R" will be 
		 * implementing Car and providing implementation for all the methods in Car interface like 
		 * brake, accelerate, changeGear etc. 
		 */
		UnionFind uf = new UnionFind(G.V());
		int v,w;
		while(!edges.isEmpty() && mst.size() < G.V() - 1){
			Edge e = edges.poll();
			v = e.either();
			w = e.other(v);
			if(!uf.find(v, w)){
				uf.union(v, w);
				mst.add(e);
				weight += e.weight();
			}
		}
		
	}
	
	public Iterable<Edge> getMST(){
		return mst;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public String toString(){
		String str = "KRUSKAL MST\n";
		for(Edge e : mst)
			str += e.toString();
		return str;
	}
}
