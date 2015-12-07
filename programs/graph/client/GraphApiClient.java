package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.GraphUtil;

public class GraphApiClient {
	
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/graph-api-test-input-1";
			//String inputFileName = "graph_input_files/disconnected-graph-cycle-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Graph g = new com.graph.Graph(file);
			System.out.println(g);
			System.out.println(g.V() + ", " + g.E());
			System.out.println(GraphUtil.degree(g, 3));
			System.out.println("max degree : " + GraphUtil.maxDegree(g));
			System.out.println("average degree : "+ GraphUtil.averageDegree(g));
			System.out.println("self loops : " + GraphUtil.numberOfSelfLoops(g));
			System.out.println("has cycle : " + GraphUtil.hasCycle(g));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
