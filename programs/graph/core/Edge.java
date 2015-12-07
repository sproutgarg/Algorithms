package com.graph;

public class Edge implements Comparable<Edge>{
	private final int v;
	private final int w;
	private final double weight;
	public Edge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either(){
		return this.v;
	}
	
	public int other(int v){
		if(v == this.v){
			return w;
		}else{
			return v;
		}
	}
	
	public double weight(){
		return this.weight;
	}

	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		return Edge.sign(this.weight - that.weight);
	}
	
	public static int sign(double f){
		if(f != f){
			throw new IllegalArgumentException("NaN");
		}
		if (f == 0){
			return 0;
		}
	    f *= Double.POSITIVE_INFINITY;
	    if (f == Double.POSITIVE_INFINITY) return +1;
	    if (f == Double.NEGATIVE_INFINITY) return -1;

	    //this should never be reached, but I've been wrong before...
	    throw new IllegalArgumentException("Unfathomed double");
	}
	
	public String toString(){
		String str = "";
		str += "(" + v + ")------[" + weight + "]------(" + w + ")\n";
		return str;
	}
	
}