package string.symboltable.tries;

import string.symboltable.SymbolTable;

public class RWay<Value> implements SymbolTable<Object>{

	private static final int R = 256;
	private Node root;
	
	private static class Node{
		Object value;
		Node[] next = new Node[R];
	}
	
	public RWay() {
		root = new Node();
	}

	public static void main(String[] args) {
		RWay<Integer> trie = new RWay<Integer>();
		trie.put("go", 1);
		trie.put("good", 2);
		trie.put("goat", 3);
		trie.put("game", 4);
		trie.put("goa", 5);
		
		/*
		trie.put("a", 1);
		trie.put("b", 2);
		trie.put("c", 3);*/
		trie.printKeys();
		System.out.println(trie.get("go"));
		System.out.println(trie.get("goa"));
		System.out.println(trie.get("goo"));
		System.out.println(trie.get("good"));
		
		System.out.println(trie.isLeafNode(trie.root));
		
		trie.delete("good");
		trie.printKeys();
		trie.delete("goa");
		trie.printKeys();
	}

	@Override
	public boolean contains(String key) {
		return get(key) != null;
	}

	@Override
	public Value get(String key) {
		return get(root, key, 0);
	}
	
	@SuppressWarnings("unchecked")
	private Value get(Node n, String key, int p){
		if(n == null) return null;
		if(p == key.length()){
			return (Value)n.value;
		}
		char c = key.charAt(p);
		
		return get(n.next[c], key, p+1);
	}

	@Override
	public void delete(String key) {
		delete(root, key, 0);
	}
	
	private boolean delete(Node n, String key, int p){
		if(n == null)
			return false;
		if(p == key.length())
		{
			if(n.value == null)
				return false;
			else if(isLeafNode(n)){
				n.value = null;
				return true;
			}
			else{
				n.value = null;
				return false;
			}
		}
		char c = key.charAt(p);
		if(delete(n.next[c], key, p+1)){
			n.next[c] = null;
			return isLeafNode(n);
		}
		else
			return false;
	}
	
	public boolean isLeafNode(Node n){
		for(Node i : n.next)
			if(i != null)
				return false;
		return true;
	}

	@Override
	public void printKeys() {
		System.out.println("TRIE\n-----");
		printKeys(root, new StringBuilder());
		System.out.println("----");
	}
	
	private void printKeys(Node n, StringBuilder key){
		if(n.value != null){
			System.out.println(key + "=" + n.value);
		}
		for(int i=0; i < n.next.length; i++){
			if(n.next[i] != null){
				key.append((char)i);
				printKeys(n.next[i], key);
				key.deleteCharAt(key.length()-1);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(String key, Object v) {
		root = put(root, key, (Value)v, 0);
	}

	private Node put(Node n, String key, Value v, int p){
		if(n == null)
			n = new Node();
		if(p == key.length()){
			n.value = v;
			return n;
		}
		char c = key.charAt(p);
		n.next[c] = put(n.next[c], key, v, p+1);
		return n;
	}

}