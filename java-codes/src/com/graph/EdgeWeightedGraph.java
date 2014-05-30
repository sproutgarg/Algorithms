package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;

public class EdgeWeightedGraph {

	//number of vertices in the graph
	private final int V;
	
	//adjaceny list in the graph
	private CollectionBag<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.adj = (CollectionBag<Edge>[]) new CollectionBag[this.V];
		for(int v = 0; v < this.V; v++){
			//initializing each vertex with empty Bag (HashBag)
			this.adj[v] = new CollectionBag<Edge>(new HashBag<Edge>());			
		}		
	}
	
	public EdgeWeightedGraph(int V){
		this.V = V;
		init();
	}
	public EdgeWeightedGraph(java.io.File file) throws NumberFormatException, IOException{
		java.io.BufferedReader graphInput = new BufferedReader(new FileReader(file));
		String line=null;
		V = Integer.parseInt(graphInput.readLine());
		init();
		@SuppressWarnings("unused")
		int E = Integer.parseInt(graphInput.readLine());
		while((line=graphInput.readLine()) != null){
			//System.out.print(line);
			line = line.trim();
			String[] input = line.split("\\s+");
			addEdge(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Double.parseDouble(input[2])));
		}
		graphInput.close();
	}
	
	public void addEdge(Edge e){
		this.adj[e.either()].add(e);
		this.adj[e.other(e.either())].add(e);
	}
	
	public Iterable<Edge> adj(int v){
		return this.adj[v];
	}
	
	//returns number of edges
	@SuppressWarnings("unused")
	public int E(){
		int E = 0;
		for(int v = 0; v < this.V; v++){
			for(Edge e: adj(v))
				E++;
		}
		E /= 2;
		return E;
	}
	
	//returns number of vertices
	public int V(){
		return V;
	}
	
	//display the graph
	public String toString(){
		String str = "List of all weighted edges in the EdgeWeightedGraph\n";
		for(int v = 0; v < this.V ; v++){
			for(Edge e: adj(v)){
				str += e;
			}
		}
		return str;
	}
	
	public Iterable<Edge> edges(){
		java.util.List<Edge> el = new java.util.ArrayList<>();
		for(int v = 0; v < V; v++){
			for(Edge e : adj[v]){
				if(!el.contains(e)){
					el.add(e);
				}
			}
		}
		return el;
	}

}
