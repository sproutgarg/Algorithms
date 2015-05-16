package string.symboltable.tries;

import string.symboltable.SymbolTable;

public class TST<Value> implements SymbolTable<Value>{

	private Node root;
	
	private static class Node{
		char c;
		Object value;
		Node smaller;
		Node bigger;
		Node inWord;
	}
	
	public TST() {
		root = new Node();
	}

	public static void main(String[] args) {
		TST<Integer> trie = new TST<Integer>();
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
	public void put(String key, Value v) {
		root = put(root, key, v, 0);
	}
	
	private Node put(Node n, String key, Value v, int p){
		if(p >= key.length())
			return null;
		char c = key.charAt(p);
		if(n == null){
			n = new Node();
			n.c = c;
		}
		if(c < n.c)
			n.smaller = put(n.smaller, key, v, p);
		else if(c > n.c)
			n.bigger = put(n.bigger, key, v, p);
		else if(p == key.length() - 1)
			n.value = v;
		else
			n.inWord = put(n.inWord, key, v, p+1);
		return n;
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
		if(p >= key.length())
			return null;
		char c = key.charAt(p);
		if(c < n.c)
			return get(n.smaller, key, p);
		else if(c > n.c)
			return get(n.bigger, key, p);
		else if(p == key.length() - 1)
			return (Value)n.value;
		else
			return get(n.inWord, key, p+1);		
	}

	@Override
	public void delete(String key) {
		deleteShallow(root, key, 0);
	}
	
	private void deleteShallow(Node n, String key, int p){
		if(p >= key.length())
			return;
		char c = key.charAt(p);
		if(c < n.c)
			deleteShallow(n.smaller, key, p);
		else if(c > n.c)
			deleteShallow(n.bigger, key, p);
		else if(p == key.length() - 1){
			n.value = null;
			return;
		}
		else
			deleteShallow(n.inWord, key, p+1);		
	}

	@Override
	public void printKeys() {
		System.out.println("TRIE\n----");
		printKeys(root, new StringBuilder());
		System.out.println("----");
	}
	
	private void printKeys(Node n, StringBuilder key){
		if(n == null)
			return;
		key.append(n.c);
		if(n.value != null)
			System.out.println(key+"="+n.value);
		printKeys(n.inWord, key);
		
		key.deleteCharAt(key.length()-1);
		printKeys(n.smaller, key);
		printKeys(n.bigger, key);
	}
	
	public boolean isLeafNode(Node n){
		return n.inWord == null && n.smaller == null && n.bigger == null;
	}

}