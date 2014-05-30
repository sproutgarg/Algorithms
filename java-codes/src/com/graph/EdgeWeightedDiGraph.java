package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;

public class EdgeWeightedDiGraph {

	//number of vertices in the graph
	private final int V;
	
	//adjaceny list in the graph
	private CollectionBag<DirectedEdge>[] adj;
	
	//file name for passing input
	private java.io.File inputFilename;
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.adj = (CollectionBag<DirectedEdge>[]) new CollectionBag[this.V];
		for(int v = 0; v < this.V; v++){
			//initializing each vertex with empty Bag (HashBag)
			this.adj[v] = new CollectionBag<DirectedEdge>(new HashBag<DirectedEdge>());			
		}		
	}
	
	public EdgeWeightedDiGraph(int V){
		this.V = V;
		init();
	}
	public EdgeWeightedDiGraph(java.io.File file) throws NumberFormatException, IOException{
		this.inputFilename = file;
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
			addEdge(new DirectedEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Double.parseDouble(input[2])));
		}
		graphInput.close();
	}
	
	public void addEdge(DirectedEdge e){
		this.adj[e.from()].add(e);
	}
	
	public java.util.Collection<? extends DirectedEdge> adj(int v){
		return this.adj[v];
	}
	
	//returns number of DirectedEdges
	@SuppressWarnings("unused")
	public int E(){
		int E = 0;
		for(int v = 0; v < this.V; v++){
			for(DirectedEdge e: adj(v))
				E++;
		}
		return E;
	}
	
	//returns number of vertices
	public int V(){
		return V;
	}
	
	//display the graph
	public String toString(){
		String str = "List of all direct weighted edges in the EdgeWeightedDiGraph\n";
		for(int v = 0; v < this.V ; v++){
			for(DirectedEdge e: adj(v)){
				str += e;
			}
		}
		return str;
	}
	
	public Iterable<DirectedEdge> edges(){
		java.util.List<DirectedEdge> el = new java.util.ArrayList<>();
		for(int v = 0; v < V; v++){
			for(DirectedEdge e : adj[v]){
				if(!el.contains(e)){
					el.add(e);
				}
			}
		}
		return el;
	}
	
	public Digraph getDigraph() throws NumberFormatException, IOException{
		return new Digraph(this.inputFilename);
	}

}