package language;

public class Compatibility {

	public static void main(String...args){
		//testPassByReference();
		testStringBuffer(new StringBuffer(), 3);
		System.out.println();
		testString(new String(), 3);
	}
	
	private static void testStringBuffer(StringBuffer s, int counter){
		if(counter == 0 ){
			return ;
		}
		s.append('a');
		testStringBuffer(s, counter-1);
		System.out.println(s);
	}
	
	private static void testString(String s, int counter){
		if(counter == 0 ){
			return ;
		}
		s += "a";
		testString(s, counter-1);
		System.out.println(s);
	}
	
	private static void testPassByReference(){
		Integer i = new Integer(10);
		System.out.println("BEFORE="+i);
		modify(i);
		System.out.println("AFTER="+i);
		
		PInteger j = new PInteger();
		j.value = 90;
		
		System.out.println("BEFORE="+j);
		modify(j);
		System.out.println("AFTER="+j);
				
	}
	
	private static void modify(Integer n){
		n = 20;
	}
	private static void modify(PInteger p){
		p.value = 80;
	}
}

class PInteger{
	public int value;
	public String toString(){
		return Integer.toString(value);
	}
}