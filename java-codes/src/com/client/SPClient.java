package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SPClient {
	public static void main(String...asd){
		try {
			//String inputFileName = "graph_input_files/edge-weighted-di-graph-test-input-1";
			// above input gives endless execution of program...check why ?
			
			String inputFileName = "graph_input_files/dijkastra-graph-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.EdgeWeightedDiGraph g = new com.graph.EdgeWeightedDiGraph(file);
			int source = 0;
			com.graph.DijkstraSP dSP = new com.graph.DijkstraSP(g, source);
			System.out.println(dSP);
			int v = 4;
			System.out.println("distance to "+ v+" = " + dSP.distTo(v));
			System.out.println(dSP.pathTo(v));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}