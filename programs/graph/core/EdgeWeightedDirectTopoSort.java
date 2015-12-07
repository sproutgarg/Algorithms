package com.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EdgeWeightedDirectTopoSort {

	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private int source;
	private List<Integer> topoOrder;
	public EdgeWeightedDirectTopoSort(EdgeWeightedDiGraph G) throws NumberFormatException, IOException{
		source = 0;
		edgeTo = new DirectedEdge[G.V()]; 
		distTo = new double[G.V()];
		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		distTo[source] = 0.0;
		
		Digraph dg = G.getDigraph();
		DirectTopoSort dts = new DirectTopoSort(dg);
		topoOrder = (List<Integer>) dts.getTopoOrder();
		//for every vertex in the topological order
		for(Integer v : topoOrder){
			relax(G, v);
		}
	}
	
	public void relax(EdgeWeightedDiGraph G, int v){
		for(DirectedEdge de : G.adj(v)){
			int p = de.from();
			int q = de.to();
			double wt = de.weight();
			if(distTo[q] >= distTo[p] + wt){
				distTo[q] = distTo[p] + wt;
				edgeTo[q] = de;
			}
		}
	}
	
	public String toString(){
		String str = "Topo Order : " + topoOrder + "\n\n"; 
		str +="vertex\t\tedgeTo[]\t\tdistTo[]\n";
		for(int v = 0; v < distTo.length; v++){
			str += v + "\t";
			str += edgeTo[v] == null ? "null" : edgeTo[v].toString().trim();
			str += "\t" + distTo[v] + "\n";
		}
		return str;
	}
}
