package com.graph;

public interface Paths {
	
	public abstract boolean hasPathTo(Integer v);
	
	public abstract Iterable<Integer> pathTo(Integer v);

	public abstract int pathLength(Integer v);
}
