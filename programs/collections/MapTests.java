package collections;

import org.junit.Test;

public class MapTests {
	
	@Test(expected=NullPointerException.class)
	public void testHashtableNullValues(){
		java.util.Map<String, Integer> table = new java.util.Hashtable<String, Integer>();
		table.put("key", null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testHashtableNullKeys(){
		java.util.Map<String, Integer> table = new java.util.Hashtable<String, Integer>();
		table.put(null, 10);		
	}

	@Test
	public void testHashMapNullValues(){
		java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();
		map.put("key", null);
		System.out.println(map);
	}
	
	@Test
	public void testHashMapNullKeys(){
		java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();
		map.put(null, 10);
		System.out.println(map);
	}
}