package com.graph;

public class DirectedEdge implements Comparable<DirectedEdge>{

	private final int v;
	private final int w;
	private final double weight;
	public DirectedEdge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}
	
	public double weight(){
		return weight;
	}
	
	public String toString(){
		String str = "";
		str += "(" + v +")>>-------[" + weight + "]--------->(" + w + ")\n";
		return str;
	}

	@Override
	public int compareTo(DirectedEdge that) {
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

}
