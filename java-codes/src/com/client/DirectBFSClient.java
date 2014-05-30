package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;


public class DirectBFSClient {
	public static void main(String...asd){
		try {
			//String inputFileName = "graph_input_files/digraph-api-test-input-1";
			String inputFileName = "graph_input_files/digraph-api-test-input-2";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Digraph G = new com.graph.Digraph(file);
			com.graph.DirectBFS bfp = new com.graph.DirectBFS(G, 0);
			Integer v = 2;
			System.out.println("Digraph  : \n" + G);
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
