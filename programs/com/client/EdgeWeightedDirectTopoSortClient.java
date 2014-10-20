package com.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.graph.EdgeWeightedDirectTopoSort;

public class EdgeWeightedDirectTopoSortClient {

	public static void main(String...asd){
		try {
			String inputFileName = "graph_input_files/dijkastra-graph-input-1";
			java.io.File file = new java.io.File(inputFileName);
			com.graph.EdgeWeightedDiGraph G = new com.graph.EdgeWeightedDiGraph(file);
			com.graph.EdgeWeightedDirectTopoSort dts = new EdgeWeightedDirectTopoSort(G);
			System.out.println(dts);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
