package elitmus.hemant;

/*
 * Write a program to format the input string such that every character is of alternative case. Given input string can contain any characters, spaces, alphabets, special characters like *, + etc

e.g :

1. Hello world needs to be formatted as hElLo WoRlD

2. yellow sea needs to be formatted as YeLlOw SeA

Instructions:

    If you introduce any additional cout or printf statements, comment it out for the test cases to succeed


 */
public class DancingString {

	

	public static String charConversion(String s){
		String dancingStr = "";
		s = s.trim();
		
		/*
		 * Deciding dance steps based on first character of the input string 
		 */
		
		int step = 0;

		for(Character ch :  s.toCharArray()){
			if(Character.isAlphabetic(ch)){
				if(step == 0){
					step = Character.isLowerCase(s.charAt(0)) ? 1 : 0;
				}
				if(isOdd(step)){
					dancingStr += Character.toUpperCase(ch);
				}else{
					dancingStr += Character.toLowerCase(ch);
				}
				step++;
			}else{
				dancingStr += ch;
			}
		}
		return dancingStr;
	}
	
	private static boolean isOdd(int n){
		return n % 2 != 0;
	}
	
	public static void main(String[] args){
		String s1 = "Hello world";
		String s2 = "yellow sea";
		
		System.out.println(charConversion(s1)+"  |  "+charConversion(s2));
		
	}
}
