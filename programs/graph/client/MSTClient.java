package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MSTClient {
	public static void main(String...asd){
		try {
			//String inputFileName = "graph_input_files/graph-api-test-input-1";
			String inputFileName = "graph_input_files/mst-graph-input-test-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.EdgeWeightedGraph g = new com.graph.EdgeWeightedGraph(file);
			com.graph.KruskalMST kMST = new com.graph.KruskalMST(g);
			System.out.println(kMST);
			System.out.println("weight = " + kMST.getWeight());
			System.out.println("\n\n NOW CALLING PRIM'S ALGORITHM FOR MST");
			
			com.graph.PrimMST pMST = new com.graph.PrimMST(g);
			System.out.println(pMST);
			System.out.println("weight = " + pMST.getWeight());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}