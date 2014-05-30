package com.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnionFind {
	private java.util.List<java.util.Set<Integer>> vertexSets;
	public UnionFind(int N){
		vertexSets = new ArrayList<java.util.Set<Integer>>();
		for(int n = 0; n< N; n++){
			Set<Integer> s = new HashSet<>();
			s.add(n);
			vertexSets.add(s);
		}
	}
	
	public boolean find(int v, int w){
		for(Set s : vertexSets){
			if(s.contains(v) && s.contains(w)){
				return true;
			}
		}
		return false;
	}
	
	private Set getSetFor(int v){
		for(Set s : vertexSets){
			if(s.contains(v))
				return s;
		}
		return null;
	}
	
	public void union(int v, int w){
		Set s1 = null;
		Set s2 = null;
		for(Set s : vertexSets){
			if(s.contains(v) && s.contains(w)){
				return;
			}else if(s.contains(v)){
				s1 = getSetFor(w);
				s2 = s;
				break;
			}else if(s.contains(w)){
				s1 = getSetFor(v);
				s2 = s;
				break;
			}
		}
		vertexSets.remove(s1);
		s2.addAll(s1);
		
	}
}