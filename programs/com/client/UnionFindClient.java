package com.client;

public class UnionFindClient {
	public static void main(String[] args){
		int N = 9;
		com.graph.UnionFind uf = new com.graph.UnionFind(N);
		uf.union(3, 4);
		uf.union(8, 0);
		uf.union(2, 3);
		uf.union(5, 6);
		System.out.println(uf.find(0, 2));
		System.out.println(uf.find(2, 4));
		uf.union(5, 1);
		uf.union(7, 3);
		uf.union(1, 6);
		uf.union(4, 8);
		System.out.println(uf.find(0, 2));
		System.out.println(uf.find(2, 4));
		System.out.println(uf.find(0, 7));
		System.out.println(uf.find(8, 7));
		System.out.println(uf.find(6, 7));
		System.out.println(uf.find(1, 0));
	}
}
