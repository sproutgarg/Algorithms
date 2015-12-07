package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.DepthFirstPaths;
import com.graph.GraphUtil;

public class DFSClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/graph-api-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Graph G = new com.graph.Graph(file);
			com.graph.DepthFirstPaths dfp = new DepthFirstPaths(G, 0);
			System.out.println("has path to : "+ dfp.hasPathTo(null));
			Integer v = 2;
			Iterable<Integer> path = dfp.pathTo(v);
			for(int w : path)
				System.out.print(w +" ");
			
			System.out.println("\npath length : " + dfp.pathLength(v));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
