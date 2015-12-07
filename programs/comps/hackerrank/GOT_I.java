package hackerrank;
/*
King Robert has 7 kingdoms under his rule. He gets to know from Raven that the Dothraki are going to wage a war against him soon. But, he knows the Dothraki need to cross the narrow river to enter his dynasty. There is only one bridge that connects both sides of the river which is sealed by a huge door.

door

The king wants to lock the door, so that, the Dothraki can�t enter. But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a list of words. Help him figure out if any anagram of the words can be a palindrome or not?

Input Format
A single line which contains the input string

Constraints
1<=length of string <= 10^5 Each character of the string is a lowercase english alphabet.

Output Format
A single line which contains YES/NO in capital letter of english alphabet.

Sample Input : 01

aaabbbb
Sample Output : 01

YES
Explanation
A palindrome permutation of the given string is bbaaabb. 

Sample Input : 02

cdefghmnopqrstuvw
Sample Output : 02

NO
Explanation
You can verify that the given string has no palindrome permutation. 

Sample Input : 03

cdcdcdcdeeeef
Sample Output : 03

YES
Explanation
A palindrome permutation of the given string is ddcceefeeccdd .
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class GOT_I {
	public static void main(String...args){
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
	      String input = br.readLine();
	      System.out.println(input);
	      input = input.toLowerCase();
	      char[] ch = input.toCharArray();
	      int[] alphabets = new int[26];
	      Arrays.fill(alphabets, 0);
	      for(char c : ch){
	     	 alphabets[(int)c-(int)'a']++;
	      }
	      int odd = 0;
	      for(int a : alphabets){
	    	  if(a%2!=0) odd++;
	      }
	      if(odd<2){
	    	  System.out.println("YES");
	      }else{
	    	  System.out.println("NO");
	      }
	    }catch(Exception e){
	    	
	    }
	}
}
