package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;


public class DirectStronglyCCClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/digraph-api-test-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Digraph G = new com.graph.Digraph(file);
			com.graph.DirectStronglyCC dscc = new com.graph.DirectStronglyCC(G);
			System.out.println(dscc);
			int v = 1;
			int w = 6;
			System.out.println(v+ ", " + w + " is connected ? : " + dscc.isStronglyConnected(v, w));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
