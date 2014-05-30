package com.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMST {
	
	//list containing known vertices of the minimum spannig tree
	private java.util.List<Integer> tree = new java.util.ArrayList<Integer>();
	
	//priorityqueue for having the min. weighted edge at the top
	private java.util.PriorityQueue<Edge> minQ = new PriorityQueue<Edge>();
	
	//list of edges for expressing MST
	private List<Edge> mst = new ArrayList<>();
	
	//visited list of edges
	private List<Edge> visitedEdges = new ArrayList<>();
	
	//weight of mst
	private double weight = 0.0;
	
	public PrimMST(EdgeWeightedGraph G){
		int source = 0;  // assuming "0" to be the source  
		
		tree.add(source);
		minQ.addAll((Collection<? extends Edge>) G.adj(source));
		
		while(!minQ.isEmpty() && mst.size() < G.V() - 1){
			Edge e = minQ.poll();
			int v = e.either();
			int w = e.other(v);
			if(tree.contains(v) && tree.contains(w)){
				continue;
			}
			visitedEdges.add(e);
			mst.add(e);
			weight += e.weight();
			//finding out new vertex 'x'
			int x = v;
			if(!tree.contains(w)){
				x = w;
			}
			
			//adding new vertex to tree
			tree.add(x);
			
			//adding new adjacent edges to minQ such that already visited edges do not appear again in minQ.
			Collection<? extends Edge> adj = (Collection<? extends Edge>) G.adj(x);
			for(Edge e1 : adj){
				if(!visitedEdges.contains(e1)){
					minQ.add(e1);
				}
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
		String str = "Prim's MST\n";
		for(Edge e : mst){
			str += e;
		}
		return str;
	}
}
