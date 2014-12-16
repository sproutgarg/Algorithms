package string;

/**
 * @question : 
 *  abcd => a bcd,
 *  		a b cd,
 *  		a b c d,
 *  		ab c d,
 *  		abc d  
 *  
 * @author ankugarg
 * 
 * TC : O(N*N) where N is the length of the string
 * 
 * Total number of combinations = 2*(N-1)-1
 *
 */
public class Spaces {

	public static void printCombinations(String s){
		if(s.length() == 1){
			return;
		}
		expansion(s);
		if(s.length() > 1)
			compression(s);
	}
	private static void expansion(String s){
		for(int limit = 1; limit < s.length(); limit++){
			for(int i=0; i<s.length(); i++){
				System.out.print(s.charAt(i));
				if(i<limit){
					System.out.print("_");
				}
			}
			System.out.println();
		}
	}
	
	private static void compression(String s){
		for(int limit = 1; limit < s.length()-1; limit++){
			for(int i=0;i<s.length(); i++){
				System.out.print(s.charAt(i));
				if(i>=limit && i < s.length()-1){
					System.out.print("_");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printCombinations("ABCDE");
		printCombinations("A");
		printCombinations("ABC");
		printCombinations("AB");
	}
}