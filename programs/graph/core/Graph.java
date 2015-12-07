package com.graph;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
	//number of vertices in the graph
	private final int V;
	
	//Adjacency list in the graph
	private List<List<Integer>> adj;
	
	private void init(){
		System.out.println("Vertex set size="+V);
		this.adj = new ArrayList<List<Integer>>(this.V);
		System.out.println(adj.size());
		for(int v = 0; v < this.V; v++){
			//initializing each vertex with empty Bag (HashBag)
			adj.add(v, new ArrayList<Integer>());
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
		this.adj.get(v).add(w);
		this.adj.get(w).add(v);
	}
	
	public List<Integer> adj(int v){
		return this.adj.get(v);
	}
	
	//returns number of edges
	public int E(){
		int e = 0;
		for(int v = 0; v < this.V; v++){
			e += adj(v).size();
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