package technical;

import java.util.*;

public class CollectionTry {
	public static void main(String...arg){
		testGeneric();
		//testQ();
	}
	public static void testQ(){
		PriorityQueue q = new PriorityQueue();
		q.add(1);
		q.add(null);// NullPointerException
		q.add(2);
		System.out.println(q);		
	}
	
	public static void testGeneric(){
		java.util.ArrayList<String> car = new ArrayList<>();
		car.add("a");
		java.util.ArrayList supercar = car;
		supercar.add(10);
		java.util.ArrayList<? extends Number> range = new ArrayList<Integer>();
		range.add(null);
		java.util.ArrayList<Integer> ints = (java.util.ArrayList<Integer>)range;
		ints.add(12);
		System.out.println(range);
		System.out.println(car);
	}
}
