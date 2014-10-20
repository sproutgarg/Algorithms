package random;

public class StringSplit {
	public static void main(String...args){
		//String s1 = "Today is very sunny day and is very favourable to plan any journey";
		String s1 = "the odour coming out of the left over food was intolerable";
		String s2 = "mmonia has a very pungent odor";
		String pattern = "odour|odor";//"is|very";
		String[] count = s1.split(pattern);
		System.out.println(pattern + " = " + (count.length - 1));
	}
}
