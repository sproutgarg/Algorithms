package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DigraphApiClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/digraph-api-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Digraph dg = new com.graph.Digraph(file);
			System.out.println(dg);
			System.out.println(dg.V() + ", " + dg.E());
			com.graph.Digraph reversed = dg.reverse();
			System.out.println(reversed);
			System.out.println(reversed.V()+" , "+reversed.E());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
