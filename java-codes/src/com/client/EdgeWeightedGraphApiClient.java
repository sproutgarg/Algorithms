package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.GraphUtil;

public class EdgeWeightedGraphApiClient {
	
	public static void main(String...asd){
		try {
			//String inputFileName = "graph_input_files/graph-api-test-input-1";
			String inputFileName = "graph_input_files/edge-weighted-graph-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.EdgeWeightedGraph g = new com.graph.EdgeWeightedGraph(file);
			System.out.println(g);
			System.out.println(g.V() + ", " + g.E());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
