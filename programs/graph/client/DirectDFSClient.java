package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.DirectDFS;

public class DirectDFSClient {
	public static void main(String...asd){
		try {
			//String inputFileName = "graph_input_files/digraph-api-test-input-1";
			String inputFileName = "graph_input_files/digraph-api-test-input-2";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Digraph dg = new com.graph.Digraph(file);
			System.out.println(dg);
			com.graph.DirectDFS dfp = new DirectDFS(dg, 0);
			System.out.println("has path to null : "+ dfp.hasPathTo(null));
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
