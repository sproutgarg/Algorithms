package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;

public class Graph {
	//number of vertices in the graph
	private final int V;
	
	//adjaceny list in the graph
	private CollectionBag<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.adj = (CollectionBag<Integer>[]) new CollectionBag[this.V];
		for(int v = 0; v < this.V; v++){
			//initializing each vertex with empty Bag (HashBag)
			this.adj[v] = new CollectionBag<Integer>(new HashBag<Integer>());			
		}		
	}
	public Graph(int V){
		this.V = V;
		init();
	}
	public Graph(java.io.File file) throws NumberFormatException, IOException{
		java.io.BufferedReader graphInput = new BufferedReader(new FileReader(file));
		String line=null;
		V = Integer.parseInt(graphInput.readLine());
		init();
		@SuppressWarnings("unused")
		int E = Integer.parseInt(graphInput.readLine());
		while((line=graphInput.readLine()) != null){
			//System.out.print(line);
			line = line.trim();
			String[] vertices = line.split("\\s+");
			addEdge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]));
		}
		graphInput.close();
	}
	
	public void addEdge(int v, int w){
		this.adj[v].add(w);
		this.adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return this.adj[v];
	}
	
	//returns number of edges
	@SuppressWarnings("unused")
	public int E(){
		int e = 0;
		for(int v = 0; v < this.V; v++){
			for(Integer w: adj(v))
				e++;
		}
		e /= 2;
		return e;
	}
	
	//returns number of vertices
	public int V(){
		return V;
	}
	
	//display the graph
	public String toString(){
		String str = "Adjacency List Representation of Graph\n";
		for(int v = 0; v < this.V ; v++){
			str += v;
			str += "------>";
			str += "[";
			for(Integer w: adj(v)){
				str += w;
				str += " ";
			}
			str += "]";
			str += "\n";
		}
		return str;
	}
}