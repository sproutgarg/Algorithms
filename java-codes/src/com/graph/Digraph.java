package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections4.bag.CollectionBag;
import org.apache.commons.collections4.bag.HashBag;

public class Digraph {
	//number of vertices in the digraph
	private final int V;
	
	//adjaceny list in the digraph
	private CollectionBag<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	private void init(){
		this.adj = (CollectionBag<Integer>[]) new CollectionBag[this.V];
		for(int v = 0; v < this.V; v++){
			//initializing each vertex with empty Bag (HashBag)
			this.adj[v] = new CollectionBag<Integer>(new HashBag<Integer>());			
		}		
	}
	public Digraph(int V){
		this.V = V;
		init();
	}
	public Digraph(java.io.File file) throws NumberFormatException, IOException{
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
		return e;
	}
	
	//returns number of vertices
	public int V(){
		return V;
	}
	
	//display the digraph
	public String toString(){
		String str = "Adjacency List Representation of Digraph\n";
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

	//reverses the edge direction of the directed graph and returns the new digraph
	public Digraph reverse(){
		Digraph d = new Digraph(this.V);
		for(int v = 0; v < this.V(); v++){
			for(Integer w : this.adj(v)){
				d.addEdge(w, v);
			}
		}
		return d;
	}
}