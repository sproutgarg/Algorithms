package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;


public class CCClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/graph-api-test-input-2";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Graph G = new com.graph.Graph(file);
			com.graph.CC cc = new com.graph.CC(G);
			System.out.println(cc);
			int v = 1;
			int w = 1;
			System.out.println(v+ ", " + w + " is connected ? : " + cc.isConnected(v, w));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
