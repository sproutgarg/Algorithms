package hash;

import java.util.Arrays;

import binary_tree.Node;

public class Hash {
	public static final int MAX = 10;
	public static final int KEY = MAX + 1; //Better be a prime number
	
	private Object[] objectReferences;
	
	public Hash(){
		objectReferences = new Object[KEY];
		Arrays.fill(objectReferences, null);
	}
	
	public Hash(int capacity){
		
	}
	
	public Object getObjectReference(int key){
		return objectReferences[getHashKey(key)];
	}
	
	//Do not allows null values.
	public boolean setObjectReference(int key, Object ref){
		if(ref == null){
			return false;
		}
		
		int hashKey = getHashKey(key);
		
		/**
		 * OVERRIDABLE HASHING
		if(objectReferences[hashKey] != null){
			return false;
		}
		*/
		objectReferences[hashKey] = ref;
		return true;		
	}
	
	public void resetKey(int key){
		objectReferences[getHashKey(key)] = null;
	}
	
	private int getHashKey(int key){
		return key%KEY;
	}
	
	public static void main(String[] args){
		Hash h = new Hash();
		Node a = new Node(10);
		Node b = new Node(1);
		Node c = new Node(3);
		Node d = new Node(4);
		System.out.println(h.setObjectReference(a.data, a));
		System.out.println(h.setObjectReference(b.data, b));
		System.out.println(h.setObjectReference(c.data, c));
		System.out.println(h.setObjectReference(d.data, d));
		System.out.println(h.getObjectReference(d.data));
	}
}