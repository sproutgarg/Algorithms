package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.DirectTopoSort;

public class DirectTopoSortClient {
	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/digraph-topo-sort-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.Digraph G = new com.graph.Digraph(file);
			com.graph.DirectTopoSort dts = new DirectTopoSort(G);
			System.out.println(G);
			for(Integer w : dts.getTopoOrder()){
				System.out.print(w + " ");
			}
			System.out.println();
			for(Integer w : dts.getPostOrder()){
				System.out.print(w + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}