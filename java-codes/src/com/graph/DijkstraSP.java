package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraSP {

	//contains distance to vertex 'v' from the source
	private double[] distTo;
	
	//contains the known edges in ascending order of their weight
	private java.util.PriorityQueue<DirectedEdge> minQ;
	
	//contains parent vertex information for vertex 'v'
	private Integer[] edgeTo;
	
	//source vertex to calculate shortest path from to every other vertices in the graph
	private int source;
	
	public DijkstraSP(EdgeWeightedDiGraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new Integer[G.V()];
		minQ = new java.util.PriorityQueue<>();
		
		//initialize the array with inifinty values
		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		distTo[source] = 0.0;
		//adding sentinal edge "0 -> 0" with weight 0 to the minQ
		minQ.add(new DirectedEdge(0, 0, 0.0));
		List<DirectedEdge> visitedEdges = new ArrayList<DirectedEdge>();
		while(!minQ.isEmpty()){
			DirectedEdge e = minQ.poll();
			visitedEdges.add(e);
			//System.out.println("======\n" + e + "----\n");
			for(DirectedEdge de : G.adj(e.to())){
				int v = de.from(), w = de.to();
				double wt = de.weight();
				if(distTo[w] >= distTo[v] + wt){
					distTo[w] = distTo[v] + wt;
					edgeTo[w] = v;
					
				}
				if(!visitedEdges.contains(de) && !minQ.contains(de)){
					minQ.add(de);
				}
			}
			//System.out.println(this+"~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
	}
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public String pathTo(int v){
		//new approach
		String path = "path : ";
		for(Integer w = v; w != null; w = edgeTo[w]){
			path += w +" <-- ";
		}
		return path;
	}
	
	public String toString(){
		String str = "vertex\tedgeTo[]\tdistTo[]\n";
		for(int v= 0 ; v < distTo.length; v++){
			str += v+"\t\t"+edgeTo[v]+"\t\t"+distTo[v]+"\n";
		}
		return str;
	}
}
