package cache;

import binary_tree.Node;
import hash.Hash;

public class LRU {

	public static final int CACHE_SIZE = 10;
	private Queue q = null;
	private Hash h = null;
	private int load = 0;
	
	public LRU(){
		q = new Queue();
		h = new Hash();
	}
	
	public Object getPage(int pageIndex){
		Node page = (Node)h.getObjectReference(pageIndex);
		if(page == null){
			System.out.println("CACHE MISS");
			//loading page from disk, mocking the same here by object creation
			page = new Node(pageIndex);
			if(load >= CACHE_SIZE){//REACHED MAX LIMIT, THEN DELETE the LRU i.e. front node of the queue
				System.out.println("CACHE EXHAUSTED");
				h.resetKey(q.getFront().data);
				q.delete(q.getFront());
				load--;
			}
			q.enque(page);
			h.setObjectReference(pageIndex, page);
			load++;
		}else{
			System.out.println("CACHE HIT");
			q.delete(page);
			q.enque(page);
		}
		System.out.println(q);
		return page;
	}
	
	public static void main(String[] args){
		
		LRU cache = new LRU();
		
		cache.getPage(9);
		cache.getPage(10);
		cache.getPage(6);
		cache.getPage(4);
		cache.getPage(1);
		cache.getPage(8);
		cache.getPage(3);
		cache.getPage(4);
		cache.getPage(2);
		cache.getPage(5);
		cache.getPage(6);
		cache.getPage(7);
		cache.getPage(0);
		cache.getPage(15);
	}
}