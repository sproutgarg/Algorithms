package hit_and_try;

import java.util.*;

public class CollectionTry {
	public static void main(String...arg){
		PriorityQueue q = new PriorityQueue();
		q.add(1);
		q.add(null);// NullPointerException
		q.add(2);
		System.out.println(q);
	}
}
