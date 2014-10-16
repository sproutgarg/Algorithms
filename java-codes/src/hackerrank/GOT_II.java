package hackerrank;
/*
This follows from Game of Thrones - I.

Now that the king knows how to find out whether a given word has an anagram which is a palindrome or not, he encounters another challenge. He realizes that there can be more than one palindrome anagrams for a given word. Can you help him find out how many palindrome anagrams are possible for a given word ?

The king has many words. For each given word, he needs to find out the number of palindrome anagrams of the string. As the number of anagrams can be large, the king needs the number of anagrams % (109+ 7).

Input format :
A single line which contains the input string

Output format :
A single line which contains the number of anagram strings which are palindrome % (109 + 7).

Constraints :
1<=length of string <= 10^5
Each character of the string is a lowercase alphabet.
Each test case has at least 1 anagram which is a palindrome.

Sample Input 01 :

aaabbbb
Sample Output 01 :

3 
Explanation :
Three palindrome permutations of the given string are abbabba , bbaaabb and bababab.

Sample Input 02 :

cdcdcdcdeeeef
Sample Output 02 :

90
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class GOT_II {

    public static void main(String[] args) {
    	
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
         BigInteger denominator=new BigInteger("1"), numerator=new BigInteger("0");
         for(int a:alphabets){
        	 
        	 if(a%2==0 && a > 0){
        		 Integer x = a/2;
        		 numerator = numerator.add(BigInteger.valueOf(x.intValue()));
        		 denominator = denominator.multiply(factorial(BigInteger.valueOf(x.intValue())));
        		 System.out.print(x.toString()+":"+numerator.toString()+"/"+denominator.toString()+",");
        	 }else if(a>0){
        		 Integer x = (a-1)/2;
        		 numerator = numerator.add(new BigInteger(x.toString()));
        		 denominator=denominator.multiply(factorial(new BigInteger(x.toString())));
        		 System.out.print(x.toString()+":"+numerator.toString()+"/"+denominator.toString()+",");
        	 }
         }
         System.out.println();
         numerator = factorial(numerator);
//         System.out.println(numerator.toString()+"/"+denominator.toString());
         BigInteger result = numerator.divide(denominator);
//         System.out.println(result.toString());
         Long prime = (long)Math.pow(10, 9) + 7;
         result = (result.divideAndRemainder(BigInteger.valueOf(prime.longValue())))[1];
         System.out.println(result);
      } catch (Exception e) {
         e.printStackTrace();
      }
    }
    public static BigInteger factorial(BigInteger n){
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= n.intValue(); i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }
    
}