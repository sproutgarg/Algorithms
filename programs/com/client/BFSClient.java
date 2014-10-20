package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.BreadthFirstPaths;

public class BFSClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/graph-api-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Graph G = new com.graph.Graph(file);
			com.graph.BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
			Integer v = 6;
			System.out.println("has path to " + v + " : "+ bfp.hasPathTo(v));
			Iterable<Integer> path = bfp.pathTo(v);
			System.out.print("path : ");
			for(int w : path)
				System.out.print(w +" ");
			
			System.out.println("\npath length : " + bfp.pathLength(v));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
